package com.bug.henong.dao;

import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class test {
    public static  void main(String args[]) throws SQLException {
        Farmer farmer =new Farmer();
        farmer.setFarmerId("1");
        farmer.setFarmerName("Tan");
        farmer.setFarmerAge(19);
        farmer.setFarmerValue(0.0);
        farmer.setFarmerPlace("CD");
        FarmerDao farmerDao = new FarmerDao();
        System.out.println(farmerDao.insert(farmer)+"row changed");
    }
}
