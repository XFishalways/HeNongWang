package com.bug.henong.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.*;
import com.bug.henong.entity.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("BuyerOrderService")
public class BuyerOrderService {

    private BuyerOrderDao buyerOrderDao =new BuyerOrderDao();

    /**得到订单信息*/
    public BuyerOrder getBuyerOrderById(String orderId) throws SQLException {
        return buyerOrderDao.findOneOrder(orderId);
    }
    /**得到用户所有订单*/
    public List<BuyerOrder> getBuyerOrderByBuyerId(String userId) throws SQLException {
        return buyerOrderDao.findOrdersByUserId(userId);
    }
    /**修改地址*/
    public Boolean updateAddressId(String orderId,  String newAddressId) throws SQLException {
        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (buyerOrder != null) {

                int rw = buyerOrderDao.updateAddressId(orderId, newAddressId);
                return rw > 0;


        }

        return false;
    }

    /**修改订单状态*/
    public Boolean updateStatus(String orderId,String status) throws SQLException {
        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (buyerOrder != null) {

                int rw = buyerOrderDao.updateStatus(orderId, status);
                return rw > 0;


        }

        return false;
    }

    /**确认订单*/
    public Boolean confirmOrder(String orderId,String addressId,String payMethod) throws SQLException {
        updateAddressId(orderId,addressId);
        updatePayMethod(orderId,payMethod);
        Boolean rs= updateStatus(orderId,"confirmed");
        if(rs==false){
            return false;
        }
        BuyerItemDao buyerItemDao = new BuyerItemDao();
        List<BuyerItem> buyerItems= buyerItemDao.findBuyerItemByOrderId(orderId);
        BusinessItemDao businessItemDao = new BusinessItemDao();
        BusinessOrderDao businessOrderDao = new BusinessOrderDao();
        GoodsDao goodsDao =new GoodsDao();

        for(BuyerItem item:buyerItems){
            String itemId = item.getSkuId();
            Double quantity = item.getQuantity();

            Goods goods =goodsDao.findOneGoods(itemId);
            Double orginalQuantity=goods.getGoodsQuantity();
            businessItemDao.updateQuantity(itemId,orginalQuantity-quantity);
            BusinessOrder businessOrder = new BusinessOrder();
            Snowflake snowflake = IdUtil.getSnowflake(3, 1);
            String businessOrderId = snowflake.nextIdStr();
            businessOrder.setOrderId(businessOrderId);
            businessOrder.setPayMethod(payMethod);
            businessOrder.setOrderStatus("needToPay");
            businessOrder.setAddressId(addressId);
            businessOrder.setSkuAmount(item.getQuantity().toString());
            businessOrder.setPayablePrice(item.getPrice());
            businessOrder.setTotalPrice(item.getQuantity()*item.getPrice());
            businessOrderDao.insert(businessOrder);
        }
        return  rs;
    }


    /**取消订单*/
    public Boolean denyOrder(String orderId) throws SQLException {
        Boolean rs = updateStatus(orderId, "refused");
        if (rs == false) {
            return false;
        }
        return true;
    }
    /**修改支付方式*/
    public Boolean updatePayMethod(String orderId,String payMethod) throws SQLException {
        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(orderId);

        //当前用户非空才可以进行更改
        if (buyerOrder != null) {

            int rw = buyerOrderDao.updatePayMethod(orderId, payMethod);
            return rw > 0;


        }

        return false;
    }

    /**得到当前用户所有address*/
    public Map<String,String> getAddress(String userId) throws SQLException {
        BuyerAddressDao buyerAddressDao = new BuyerAddressDao();
        List<BuyerAddress> buyerAddresses = buyerAddressDao.findAddressByBuyerId(userId);
        if(buyerAddresses.isEmpty()){
            return null;
        }
        int i=1;
        Map<String ,String>map = new HashMap<>();

        for(BuyerAddress buyerAddress :buyerAddresses){
            String id =buyerAddress.getAddressId();
            map.put("address"+i,id);
        }
        return map;
    }

}
