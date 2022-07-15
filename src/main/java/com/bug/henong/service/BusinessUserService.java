package com.bug.henong.service;

import com.bug.henong.dao.BusinessUserDao;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BusinessUserService {

    private BusinessUserDao businessUserDao =new BusinessUserDao();

    /**得到买家信息*/
    public BusinessUser getBusinessUserDetailById(String userId) throws SQLException {
        return businessUserDao.findOneBusiness(userId);
    }

    /**修改昵称*/
    public Boolean updateNickName(String userId, String originalNickName, String newNickName) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalNickName.equals(businessUser.getNickName())) {
                int rw = businessUserDao.updateNickName(userId, newNickName);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改签名*/
    public Boolean updateUserIntro(String userId, String originalUserIntro, String newUserIntro) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalUserIntro.equals(businessUser.getUserIntro())) {
                int rw = businessUserDao.updateUserIntro(userId, newUserIntro);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改头像*/
    public Boolean updateAvatar(String userId, String originalAvatar, String newAvatar) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalAvatar.equals(businessUser.getAvatar())) {
                int rw = businessUserDao.updateAvatar(userId, newAvatar);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改手机号*/
    public Boolean updatePhone(String userId, String originalPhone, String newPhone) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalPhone.equals(businessUser.getPhone())) {
                int rw = businessUserDao.updatePhone(userId, newPhone);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改密码*/
    public Boolean updateUserPass(String userId, String originalUserPass, String newUserPass) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalUserPass.equals(businessUser.getUserPass())) {
                int rw = businessUserDao.updateUserPass(userId, newUserPass);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改密码盐*/
    public Boolean updatePassSalt(String userId, String originalPassSalt, String newPassSalt) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalPassSalt.equals(businessUser.getPassSalt())) {
                int rw = businessUserDao.updatePassSalt(userId, newPassSalt);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改状态*/
    public Boolean updateUserStatus(String userId, String originalUserStatus, String newUserStatus) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {
            if (originalUserStatus.equals(businessUser.getUserStatus())) {
                int rw = businessUserDao.updateUserStatus(userId, newUserStatus);
                return rw > 0;
            }

        }

        return false;
    }
}
