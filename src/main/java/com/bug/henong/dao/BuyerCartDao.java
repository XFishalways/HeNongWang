package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerCart;
import com.bug.henong.entity.BuyerUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerCartDao {
    //添加
    public int insert(BuyerCart cart) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(cart);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    //删除
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_CART").set("USER_ID",id)
        );
        return rw;

    }

    //返回所有信息
    public List<BuyerCart> findAll() throws SQLException {

        String sql = "SELECT * FROM BUYER_CART";

        List<BuyerCart> buyerCarts = new ArrayList<BuyerCart>();
        List<Entity> entities = Db.use().findAll("BUYER_CART");

        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerCart buyerCart = JSONUtil.toBean(buyerStr,BuyerCart.class);
            buyerCarts.add(buyerCart);
        }

        return buyerCarts;
    }

    //通过id查找某一行数据
    public BuyerCart findOneCart(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_CART").set("USER_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerCart buyerCart = JSONUtil.toBean(buyerStr,BuyerCart.class);

        return  buyerCart;
    }

    //更新总金额
    public int updateTotalPrice(String totalPrice, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("TOTAL_PRICE",totalPrice),
                Entity.create("BUYER_CART").set("USER_ID",id)
        );

        return rw;
    }

    //更新应付金额
    public int updatePayablePrice(String payablePrice, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PAYABLE_PRICE",payablePrice),
                Entity.create("BUYER_CART").set("USER_ID",id)
        );

        return rw;
    }

    //更新购物车状态
    public int updateCartStatus(String cartStatus, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("CART_STATUS",cartStatus),
                Entity.create("BUYER_CART").set("USER_ID",id)
        );

        return rw;
    }

}
