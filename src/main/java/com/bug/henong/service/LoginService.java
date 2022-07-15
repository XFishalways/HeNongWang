package com.bug.henong.service;

import com.bug.henong.dao.BusinessUserDao;
import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.dao.FarmerDao;

import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.sql.SQLException;

@Service("LoginService")
public class LoginService {


    private FarmerDao farmerDao =new FarmerDao();

    private BuyerUserDao buyerUserDao = new BuyerUserDao();

    private BusinessUserDao businessUserDao = new BusinessUserDao();

    /**
     * 农户登录
     */
    public Farmer farmerLogin(String id, String password) throws SQLException {
        return farmerDao.login(id, password);
    }

    /**买家登录*/
    public BuyerUser buyerLogin(String id, String password)throws SQLException{
        return buyerUserDao.login(id, password);
    }
    /**卖家登录*/
    public BusinessUser businessUserLogin(String id, String password) throws SQLException {
        return businessUserDao.login(id, password);
    }


}
