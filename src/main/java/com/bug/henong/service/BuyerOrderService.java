package com.bug.henong.service;

import com.bug.henong.dao.BuyerOrderDao;
import com.bug.henong.entity.BuyerOrder;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BuyerOrderService {

    private BuyerOrderDao buyerOrderDao;

    /**得到订单信息*/
    public BuyerOrder getBuyerOrderById(String orderId) throws SQLException {
        return buyerOrderDao.findOneOrder(orderId);
    }

    /**修改地址*/
    public Boolean updateAddressId(String orderId, String originalAddressId, String newAddressId) throws SQLException {
        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (buyerOrder != null) {
            if (originalAddressId.equals(buyerOrder.getAddressId())) {
                int rw = buyerOrderDao.updateAddressId(orderId, newAddressId);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改订单状态*/
    public Boolean updateInvoiceTplId(String orderId, String originalInvoiceTplId, String newInvoiceTplId) throws SQLException {
        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (buyerOrder != null) {
            if (originalInvoiceTplId.equals(buyerOrder.getInvoiceTplId())) {
                int rw = buyerOrderDao.updateInvoiceTplId(orderId, newInvoiceTplId);
                return rw > 0;
            }

        }

        return false;
    }

}
