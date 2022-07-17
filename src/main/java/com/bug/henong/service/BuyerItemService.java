package com.bug.henong.service;

import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.dao.BuyerCartDao;
import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.dao.BuyerOrderDao;
import com.bug.henong.entity.BuyerCart;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.entity.BuyerOrder;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("BuyerItemService")
public class BuyerItemService {

    private BuyerItemDao buyerItemDao =new BuyerItemDao();

    /**得到商品信息*/
    public BuyerItem getBuyerItemDetailById(String itemId) throws SQLException {
        return buyerItemDao.findOneItem(itemId);
    }

    public Boolean cartInsert (String userId, Double price, Double payablePrice, String cartStatus) throws SQLException {

        BuyerCartDao buyerCartDao = new BuyerCartDao();
        BuyerCart buyerCart = buyerCartDao.findOneCart(userId);

        if (buyerCart == null) return false;

        buyerCart.setUserId(userId);
        buyerCart.setTotalPrice(price);
        buyerCart.setPayablePrice(payablePrice);
        buyerCart.setCartStatus(cartStatus);

        return buyerCartDao.insert(buyerCart) > 0;
    }

    public Boolean orderInsert (String orderId, String addressId, Double price, Double couponPrice, Double payablePrice, String payMethod, String invoiceTplId, String orderStatus) throws SQLException {

        BuyerOrderDao buyerOrderDao = new BuyerOrderDao();
        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(orderId);

        if(buyerOrder == null) return false;

        buyerOrder.setOrderId(orderId);
        buyerOrder.setAddressId(addressId);
        buyerOrder.setTotalPrice(price);
        buyerOrder.setCouponPrice(couponPrice);
        buyerOrder.setPayablePrice(payablePrice);
        buyerOrder.setInvoiceTplId(invoiceTplId);
        buyerOrder.setPayMethod(payMethod);

        return buyerOrderDao.insert(buyerOrder) > 0;
    }

    /**修改商品标题*/
    public Boolean updateSkuTitle(String skuId,String newSkuTitle) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateSkuTitle(skuId, newSkuTitle);
                return rw > 0;

        }

        return false;
    }

    /**修改商品介绍*/
    public Boolean updateSkuIntro(String skuId,  String newSkuIntro) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateSkuIntro(skuId, newSkuIntro);
                return rw > 0;


        }

        return false;
    }

    /**修改订单留言备注*/
    public Boolean updateLeaveComment(String skuId,  String newLeaveComment) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateLeaveComment(skuId, newLeaveComment);
                return rw > 0;


        }

        return false;
    }

    /**修改售价*/
    public Boolean updateSalePrice(String skuId,Double newSalePrice) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateSalePrice(skuId, newSalePrice);
                return rw > 0;


        }

        return false;
    }

}
