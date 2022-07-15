package com.bug.henong.service;

import com.bug.henong.dao.FarmerDao;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author Tan
 * @version 1.0.0
 */
@Service("FarmerService")
public class FarmerService {

     private FarmerDao farmerDao = new FarmerDao();

    /**
     * 登录
     */
    public Farmer login(String id, String password) throws SQLException {
        return farmerDao.login(id, password);
    }

    /**
     * 得到用户信息
     */
    public Farmer getFarmerDetailById(String loginUserId) throws SQLException {
        return farmerDao.findOneFarmer(loginUserId);
    }

    /**
     * 修改密码
     */
    public Boolean updatePassword(String loginUserId,  String newPassword) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {

                int rw = farmerDao.updateUserPass(loginUserId, newPassword);
                return rw > 0;


        }

        return false;
    }

    /**
     * 修改姓名
     */
    public Boolean updateFarmerName(String loginUserId,  String newName) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {

                int rw = farmerDao.updateName(loginUserId, newName);
                return rw > 0;


        }
        return false;
    }

    /**
     * 修改年龄
     */
    public Boolean updateFarmerAge(String loginUserId,  int newAge) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改

            if (farmer.getFarmerAge() == (farmer.getFarmerAge())) {
                int rw = farmerDao.updateAge(loginUserId, newAge);
                return rw > 0;


        }
        return false;
    }


    /**
     * 修改所在地
     */
    public Boolean updatePlace(String loginUserId,  String newPlace) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {

                int rw = farmerDao.updatePlace(loginUserId, newPlace);
                return rw > 0;


        }
        return false;
    }

    /**
     * 修改资产
     */
    public Boolean updateValue(String loginUserId, Double newValue) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {

                int rw = farmerDao.updateValue(loginUserId, newValue);
                return rw > 0;


        }

        return false;
    }

    /**
     * 修改信誉度
     */
    public Boolean updateCredibility(String loginUserId, String newCredit) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
                int rw = farmerDao.updateCredibility(loginUserId, newCredit);
                return rw > 0;
        }

        return false;
    }
    /**修改密码盐 */
    public Boolean updatePassSalt(String loginUserId,  String newPassSalt) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {

                int rw = farmerDao.updatePassSalt(loginUserId, newPassSalt);
                return rw > 0;


        }

        return false;
    }

    /**修改所属卖家ID号*/
    public Boolean updateBusinessId(String loginUserId,  String newBusinessId) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {

                int rw = farmerDao.updateCredibility(loginUserId, newBusinessId);
                return rw > 0;


        }

        return false;
    }
}



