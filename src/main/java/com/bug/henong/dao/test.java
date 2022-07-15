package com.bug.henong.dao;

import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class test {
    public static  void main(String args[]) throws SQLException {
        BuyerUserDao buyerUserDao = new BuyerUserDao();
        for(int i =0; i<50;i++){
            BuyerUser buyerUser =new BuyerUser();
            buyerUser.setUserId(Integer.toString(i));
            buyerUser.setUserName(Integer.toString(i));
            buyerUserDao.insert(buyerUser);
        }

    }
}
