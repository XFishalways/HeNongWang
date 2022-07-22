package com.bug.henong.dao;

import com.bug.henong.entity.Admin;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class test {
    public static  void main(String args[]) throws SQLException {

        Admin admin =new Admin();
        admin.setAdminId("1");
        admin.setAdminName("Gao");
        admin.setAdminPasswd("123");
        admin.setAdminPhone("111");
        admin.setPassSalt("qwe");
        AdminUserDao adminUserDao = new AdminUserDao();
        adminUserDao.insert(admin);
        System.out.println(adminUserDao.findOneAdmin("1").getPassSalt());
        System.out.println(adminUserDao.findOneAdmin("1").getAdminPasswd());
    }
}