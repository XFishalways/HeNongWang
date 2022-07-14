package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rui
 * @version 1.0.0
 * @date 22.07.13
 */
public class BusinessOrderDao {

    /**添加*/
    public int insert(BusinessOrder order) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(order);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUSINESS_ORDER").set("ORDER_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<BusinessOrder> findAll() throws SQLException {

        String sql = "SELECT * FROM BUSINESS_ORDER";

        List<BusinessOrder> businessOrders = new ArrayList<BusinessOrder>();
        List<Entity> entities = Db.use().findAll("BUSINESS_ORDER");

        for(Entity e : entities){
            String orderStr = JSONUtil.toJsonStr(e);
            BusinessOrder businessOrder = JSONUtil.toBean(orderStr,BusinessOrder.class);
            businessOrders.add(businessOrder);
        }

        return businessOrders;
    }

    /**通过id查找某一行数据*/
    public BusinessOrder findOneOrder(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUSINESS_ORDER").set("ORDER_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e =entities.get(0);
        String orderStr = JSONUtil.toJsonStr(e);
        BusinessOrder businessOrder = JSONUtil.toBean(orderStr,BusinessOrder.class);

        return  businessOrder;
    }

    /**更新地址ID*/
    public int updateAddressID(String addressID, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADDRESS_ID",addressID),
                Entity.create("BUSINESS_ORDER").set("ORDER_ID",id)
        );

        return rw;
    }

    /**更新订单状态*/
    public int updateOrderStatus(String orderStatus, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ORDER_STATUS",orderStatus),
                Entity.create("BUSINESS_ORDER").set("ORDER_ID",id)
        );

        return rw;
    }

}