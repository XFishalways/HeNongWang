package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.*;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static  void main(String args[]) throws SQLException {
       BusinessItemDao businessItemDao =new BusinessItemDao();
       List<BusinessItem>businessItems =businessItemDao.findBusinessItemsByTitleAndBusinessId("1","1");
       System.out.println(JSON.toJSONString(businessItems));
    }
}
