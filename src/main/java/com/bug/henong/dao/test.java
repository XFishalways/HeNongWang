package com.bug.henong.dao;

import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class test {
    public static  void main(String args[]) throws SQLException {
        BuyerUserDao userDao = new BuyerUserDao();

        System.out.println(userDao.findOneBuyer("1").getUserPass());
       // int rw = userDao.insert(user);

    }
}
