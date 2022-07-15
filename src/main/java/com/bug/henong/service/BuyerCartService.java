package com.bug.henong.service;

import com.bug.henong.dao.BuyerAddressDao;
import com.bug.henong.dao.BuyerCartDao;
import com.bug.henong.entity.BuyerCart;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BuyerCartService {

    private BuyerCartDao buyerCartDao =new BuyerCartDao();

    /**得到购物车信息*/
    public BuyerCart getCartDetailById(String cartId) throws SQLException {
        return buyerCartDao.findOneCart(cartId);
    }

    /**修改总金额*/
    public Boolean updateTotalPrice(String cartId, Double originalTotalPrice, Double newTotalPrice) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);

        //当前用户非空才可以进行更改
        if (buyerCart != null) {
            if (originalTotalPrice == buyerCart.getTotalPrice()) {
                int rw = buyerCartDao.updateTotalPrice(cartId, newTotalPrice);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改应付金额*/
    public Boolean updatePayablePrice(String cartId, Double originalPayablePrice, Double newPayablePrice) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);

        //当前用户非空才可以进行更改
        if (buyerCart != null) {
            if (originalPayablePrice == buyerCart.getPayablePrice()) {
                int rw = buyerCartDao.updatePayablePrice(cartId, newPayablePrice);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改购物车状态*/
    public Boolean updateCartStatus(String cartId, String originalCartStatus, String newCartStatus) throws SQLException {
        BuyerCart buyerCart = buyerCartDao.findOneCart(cartId);

        //当前用户非空才可以进行更改
        if (buyerCart != null) {
            if (originalCartStatus.equals(buyerCart.getCartStatus())) {
                int rw = buyerCartDao.updateCartStatus(cartId, newCartStatus);
                return rw > 0;
            }

        }

        return false;
    }

}
