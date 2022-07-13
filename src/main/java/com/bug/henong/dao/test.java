package com.bug.henong.dao;

import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class test {
    public static  void main(String args[]) throws SQLException {
        BuyerUserDao userDao = new BuyerUserDao();
        BuyerUser user = new BuyerUser();
        user.setUserId("1");
        user.setUserPass("11");
        user.setPassSalt("14");
        user.setUserName("Tan");
        int rw = userDao.insert(user);
        System.out.println(rw+"has changed");
    }
}
