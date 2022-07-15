package com.bug.henong.service;

import com.bug.henong.dao.BusinessOrderDao;
import com.bug.henong.entity.BusinessOrder;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BusinessOrderService {

    private BusinessOrderDao businessOrderDao = new BusinessOrderDao();

    /**得到订单信息*/
    public BusinessOrder getOrderDetailById(String orderId) throws SQLException {
        return businessOrderDao.findOneOrder(orderId);
    }

    /**修改地址ID*/
    public Boolean updateAddressId(String orderId, String newAddressId) throws SQLException {
        BusinessOrder businessOrder = businessOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (businessOrder != null) {

                int rw = businessOrderDao.updateAddressID(orderId, newAddressId);
                return rw > 0;


        }

        return false;
    }

    /**修改订单状态*/
    public Boolean updateOrderStatus(String orderId,  String newOrderStatus) throws SQLException {
        BusinessOrder businessOrder = businessOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (businessOrder != null) {

                int rw = businessOrderDao.updateOrderStatus(orderId, newOrderStatus);
                return rw > 0;


        }

        return false;
    }

}
