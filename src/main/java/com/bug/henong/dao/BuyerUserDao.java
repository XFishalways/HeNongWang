package com.bug.henong.dao;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BuyerUserDao {
    //添加
    public int insert(BuyerUser user) throws SQLException {
        Entity entity = Entity.parse(user);

        int rw = Db.use().insert(entity);

        return  rw;
    }
    //删除
    public int delete(int id) throws SQLException {
        int rw=Db.use().del(
                Entity.create("BUYER_USER").set("id",id)
        );
        return rw;
    }
    public List<BuyerUser> findAll() throws SQLException {
        String sql = "SELECT * FROM BUYERUSER";

        List<BuyerUser> buyerUsers = new ArrayList<BuyerUser>();
        List<Entity> entities = Db.use().findAll("BUYERUSER");
        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerUser buyerUser = BeanUtil.toBean(buyerStr,BuyerUser.class);
            buyerUsers.add(buyerUser);
        }

        return buyerUsers;
    }
}