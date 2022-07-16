package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static  void main(String args[]) throws SQLException {
       GoodsDao goodsDao = new GoodsDao();
        List<Entity> entities = Db.use().query("SELECT * FROM GOODS WHERE FARMER_ID LIKE ?", "%"+1+"%");
       String json = JSON.toJSONString(entities);
       System.out.println(json);
    }
}
