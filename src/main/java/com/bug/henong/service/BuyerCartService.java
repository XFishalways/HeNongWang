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
    public Boolean cleanCart(String userId) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(userId);
        if(buyerCart == null){
            return false;
        }
        buyerCart.setCartStatus("N");
        BuyerItemDao buyerItemDao = new BuyerItemDao();
        List<BuyerItem> buyerItems = getItemsInCart(buyerCart.getUserId());
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
        buyerOrder.setUserId(userId);
        buyerOrder.setOrderStatus("uncofirmed");
        buyerOrder.setTotalPrice(totalPrice);
        BuyerOrderDao buyerOrderDao = new BuyerOrderDao();

        int rs=buyerOrderDao.insert(buyerOrder);
        return rs>0;
    }
    /**得到购物车所有商品*/
    public List<BuyerItem> getItemsInCart(String userId) throws SQLException {
        BuyerItemDao buyerItemDao = new BuyerItemDao();
        List<BuyerItem> buyerItems = buyerItemDao.findBuyerItemByUserId(userId);
        for(BuyerItem item : buyerItems){
           if(item.getOrderId()==null){
               buyerItems.add(item);
           }

        }
        return buyerItems;
    }
    /**删除购物车中商品*/
    public Boolean delete(String skuId,String userId) throws SQLException {
        BuyerItemDao buyerItemDao = new BuyerItemDao();
        BuyerItem buyerItem = buyerItemDao.findBuyerItemByUserIdAndSkuID(userId,skuId);
        if(buyerItem.getOrderId()!=""){
            return false;
        }
        int rs= buyerItemDao.delete(skuId);
        if(getItemsInCart(userId)==null){
            buyerCartDao.updateCartStatus(userId,"N");
        }
        return rs>0;

    }
    /**确认生成订单*/
    public Boolean confirm(List<String> skuIds,String userId) throws SQLException {
        BuyerItemDao buyerItemDao = new BuyerItemDao();
        //4代表买家端
        Snowflake snowflake = IdUtil.getSnowflake(4, 1);
        String orderId = snowflake.nextIdStr();
        Double totalPrice = 0.0;
        for(String id:skuIds){
            BuyerItem buyerItem = buyerItemDao.findBuyerItemByUserIdAndSkuID(userId,id);
            if(buyerItem.getOrderId()!=""){
                return false;
            }else {
                buyerItemDao.updateOrderID(buyerItem.getSkuId(),orderId);
                totalPrice+=buyerItem.getPrice()* buyerItem.getQuantity();
            }

        }
        BuyerOrder buyerOrder = new BuyerOrder();
        buyerOrder.setOrderId(orderId);
        buyerOrder.setUserId(userId);
        buyerOrder.setOrderStatus("uncofirmed");
        buyerOrder.setTotalPrice(totalPrice);
        BuyerOrderDao buyerOrderDao = new BuyerOrderDao();

        int rs=buyerOrderDao.insert(buyerOrder);
        return rs>0;
    }
}
