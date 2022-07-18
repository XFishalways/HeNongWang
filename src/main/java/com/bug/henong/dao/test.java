package com.bug.henong.dao;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.*;
import com.bug.henong.utils.EncryptUtil;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static  void main(String args[]) throws SQLException {
       BusinessItemDao businessItemDao = new BusinessItemDao();
       BusinessItem item = businessItemDao.findOneItem("1548891270070542336");
       GoodsDao goodsDao = new GoodsDao();
       Goods goods = goodsDao.findOneGoods("1548891270070542336");
       Double q= item.getQuantity();
       Double q2= goods.getGoodsQuantity();
       System.out.println(q);
    }
}
