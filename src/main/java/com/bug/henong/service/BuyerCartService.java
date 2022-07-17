package com.bug.henong.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.BuyerAddressDao;
import com.bug.henong.dao.BuyerCartDao;
import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.dao.BuyerOrderDao;
import com.bug.henong.entity.BuyerCart;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.entity.BuyerOrder;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("BuyerCartService")
public class BuyerCartService {

    private BuyerCartDao buyerCartDao =new BuyerCartDao();

    /**得到购物车信息*/
    public BuyerCart getCartByUserId(String userId) throws SQLException {
        return buyerCartDao.findOneCart(userId);
    }


    /**修改总金额*/
    public Boolean updateTotalPrice(String cartId,  Double newTotalPrice) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);

        //当前用户非空才可以进行更改
        if (buyerCart != null) {

                int rw = buyerCartDao.updateTotalPrice(cartId, newTotalPrice);
                return rw > 0;


        }

        return false;
    }

    /**修改应付金额*/
    public Boolean updatePayablePrice(String cartId, Double newPayablePrice) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);

        //当前用户非空才可以进行更改
        if (buyerCart != null) {

                int rw = buyerCartDao.updatePayablePrice(cartId, newPayablePrice);
                return rw > 0;


        }

        return false;
    }

    /**修改购物车状态*/
    public Boolean updateCartStatus(String cartId,  String newCartStatus) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);

        //当前用户非空才可以进行更改
        if (buyerCart != null) {

                int rw = buyerCartDao.updateCartStatus(cartId, newCartStatus);
                return rw > 0;


        }

        return false;
    }

    /**清空购物车购买其中所有*/
    public Boolean cleanCart(String cartId) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);
        if(buyerCart == null){
            return false;
        }
        buyerCart.setCartStatus("N");
        BuyerItemDao buyerItemDao = new BuyerItemDao();
        List<BuyerItem> buyerItems = buyerItemDao.findBuyerItemByUserId(buyerCart.getUserId());
        //4代表买家端
        Snowflake snowflake = IdUtil.getSnowflake(4, 1);
        String orderId = snowflake.nextIdStr();

        Double totalPrice = 0.0;
        for(BuyerItem item : buyerItems){
            buyerItemDao.updateOrderID(item.getSkuId(),orderId);
            totalPrice+=item.getPrice()* item.getQuantity();
        }
        BuyerOrder buyerOrder = new BuyerOrder();
        buyerOrder.setOrderId(orderId);
        buyerOrder.setUserId(buyerCart.getUserId());
        buyerOrder.setOrderStatus("uncofirmed");
        buyerOrder.setTotalPrice(totalPrice);
        BuyerOrderDao buyerOrderDao = new BuyerOrderDao();

        int rs=buyerOrderDao.insert(buyerOrder);
        return rs>0;
    }

}
