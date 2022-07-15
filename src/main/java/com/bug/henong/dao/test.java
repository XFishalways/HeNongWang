package com.bug.henong.dao;

import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class test {
    public static  void main(String args[]) throws SQLException {
        FarmerDao farmerDao = new FarmerDao();

        System.out.println(farmerDao.findOneFarmer("1").getUserPass());

    }
}
