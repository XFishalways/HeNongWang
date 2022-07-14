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

    private FarmerDao farmerDao;

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
    public Boolean updatePassword(String loginUserId, String originalPassword, String newPassword) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
            if (originalPassword.equals(farmer.getUserPass())) {
                int rw = farmerDao.updateUserPass(loginUserId, newPassword);
                return rw > 0;
            }

        }

        return false;
    }

    /**
     * 修改所在地
     */
    public Boolean updatePlace(String loginUserId, String originalPlace, String newPlace) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
            if (originalPlace.equals(farmer.getFarmerPlace())) {
                int rw = farmerDao.updatePlace(loginUserId, newPlace);
                return rw > 0;
            }

        }
        return false;
    }

    /**
     * 修改资产
     */
    public Boolean updateValue(String loginUserId, Double originalValue, Double newValue) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
            if (originalValue.equals(farmer.getFarmerValue())) {
                int rw = farmerDao.updateValue(loginUserId, newValue);
                return rw > 0;
            }

        }

        return false;
    }

    /**
     * 修改信誉度
     */
    public Boolean updateCredibility(String loginUserId, String originalCredit, String newCredit) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
            if (originalCredit.equals(farmer.getFarmerCredibility())) {
                int rw = farmerDao.updateCredibility(loginUserId, newCredit);
                return rw > 0;
            }

        }

        return false;
    }
    /**修改密码盐 */
    public Boolean updatePassSalt(String loginUserId, String originalPassSalt, String newPassSalt) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
            if (originalPassSalt.equals(farmer.getPassSalt())) {
                int rw = farmerDao.updatePassSalt(loginUserId, newPassSalt);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改所属卖家ID号*/
    public Boolean updateBusinessId(String loginUserId, String originalBusinessId, String newBusinessId) throws SQLException {
        Farmer farmer = farmerDao.findOneFarmer(loginUserId);

        //当前用户非空才可以进行更改
        if (farmer != null) {
            if (originalBusinessId.equals(farmer.getBusinessId())) {
                int rw = farmerDao.updateCredibility(loginUserId, newBusinessId);
                return rw > 0;
            }

        }

        return false;
    }
}



