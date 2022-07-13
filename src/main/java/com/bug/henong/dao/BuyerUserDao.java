package com.bug.henong.dao;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Tan
 * @version 1.0.0
 * @date 22.07.13
 */
public class BuyerUserDao {

    /**添加*/
    public int insert(BuyerUser user) throws SQLException {
        Entity entity = Entity.parse(user);

        int rw = Db.use().insert(entity);

        return  rw;
    }

    /**删除*/
    public int delete(int id) throws SQLException {
        int rw=Db.use().del(
                Entity.create("BUYER_USER").set("USER_ID",id)
        );
        return rw;
    }

    /**返回所有信息*/
    public List<BuyerUser> findAll() throws SQLException {
        String sql = "SELECT * FROM BUYER_USER";

        List<BuyerUser> buyerUsers = new ArrayList<BuyerUser>();
        List<Entity> entities = Db.use().findAll("BUYER_USER");
        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerUser buyerUser = BeanUtil.toBean(buyerStr,BuyerUser.class);
            buyerUsers.add(buyerUser);
        }

        return buyerUsers;
    }

    /**通过id查找某一行数据*/
    public BuyerUser findOneBuyer(String id) throws SQLException {
        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        Entity e = entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerUser buyerUser = BeanUtil.toBean(buyerStr,BuyerUser.class);

        return  buyerUser;
    }
}