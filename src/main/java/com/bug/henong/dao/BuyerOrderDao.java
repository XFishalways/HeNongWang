package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerOrder;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerOrderDao {
    //添加
    public int insert(BuyerOrder order) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(order);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    //删除
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_ORDER").set("ORDER_ID",id)
        );
        return rw;

    }

    //返回所有信息
    public List<BuyerOrder> findAll() throws SQLException {

        String sql = "SELECT * FROM BUYER_ORDER";

        List<BuyerOrder> buyerOrders = new ArrayList<BuyerOrder>();
        List<Entity> entities = Db.use().findAll("BUYER_ORDER");

        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerOrder buyerOrder = JSONUtil.toBean(buyerStr,BuyerOrder.class);
            buyerOrders.add(buyerOrder);
        }

        return buyerOrders;
    }

    //通过id查找某一行数据
    public BuyerOrder findOneOrder(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_ORDER").set("ORDER_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerOrder buyerOrder = JSONUtil.toBean(buyerStr,BuyerOrder.class);

        return  buyerOrder;
    }


    //更新地址
    public int updateAddressId(String id, String addressId) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADDRESS_ID",addressId),
                Entity.create("BUYER_ORDER").set("ORDER_ID",id)
        );

        return rw;
    }

    //更新订单状态
    public int updateInvoiceTplId(String id, String invoiceTplId) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ORDER_STATUS",invoiceTplId),
                Entity.create("BUYER_ORDER").set("ORDER_ID",id)
        );

        return rw;
    }

    /**
     *通过userID查找
     */
    public List<BuyerOrder> findBuyerOrderByUserId(String userId) throws SQLException {
        List<BuyerOrder> buyerOrders = new ArrayList<BuyerOrder>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_ORDER Where USER_ID LIKE /'%?%/'", userId);

        for (Entity e : entities) {
            String userStr = JSONUtil.toJsonStr(e);
            BuyerOrder buyerOrder = JSONUtil.toBean(userStr, BuyerOrder.class);
            buyerOrders.add(buyerOrder);
        }
        return buyerOrders;
    }

}
