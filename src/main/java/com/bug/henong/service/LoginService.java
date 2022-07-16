package com.bug.henong.service;

import com.bug.henong.dao.BusinessUserDao;
import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.dao.FarmerDao;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

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

    public Boolean login(String id, String password, String type) throws  SQLException{

        switch (type){
            case "farmer":
                if(farmerLogin(id, password)!=null){
                    return true;
                }
                break;
            case "buyer":
                if(buyerLogin(id, password)!=null){
                return true;
            }
            break;
            case "business":
                if(businessUserLogin(id, password)!=null){
                    return true;
                }
                break;
            default:
                return false;
        }

        return false;
    }
}