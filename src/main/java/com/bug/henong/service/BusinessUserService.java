package com.bug.henong.service;

import cn.hutool.core.util.RandomUtil;
import com.bug.henong.dao.BusinessUserDao;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("BusinessUserService")
public class BusinessUserService {

    private BusinessUserDao businessUserDao = new BusinessUserDao();

    /** 得到买家信息 */
    public List<BusinessUser> getBusinessUserDetailById(String userId) throws SQLException {
        return businessUserDao.findAll(userId);
    }

    /** 修改昵称 */
    public Boolean updateNickName(String userId, String newNickName) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updateNickName(userId, newNickName);
            return rw > 0;

        }

        return false;
    }

    /** 修改签名 */
    public Boolean updateUserIntro(String userId, String newUserIntro) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updateUserIntro(userId, newUserIntro);
            return rw > 0;

        }

        return false;
    }

    /** 修改头像 */
    public Boolean updateAvatar(String userId, String newAvatar) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updateAvatar(userId, newAvatar);
            return rw > 0;

        }

        return false;
    }

    /** 修改手机号 */
    public Boolean updatePhone(String userId, String newPhone) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updatePhone(userId, newPhone);
            return rw > 0;

        }

        return false;
    }

    /** 修改密码 */
    public Boolean updateUserPass(String userId, String newUserPass) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updateUserPass(userId, newUserPass);
            return rw > 0;

        }

        return false;
    }

    /** 修改密码盐 */
    public Boolean updatePassSalt(String userId, String newPassSalt) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updatePassSalt(userId, newPassSalt);
            return rw > 0;

        }

        return false;
    }

    /** 修改状态 */
    public Boolean updateUserStatus(String userId, String newUserStatus) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        // 当前用户非空才可以进行更改
        if (businessUser != null) {

            int rw = businessUserDao.updateUserStatus(userId, newUserStatus);
            return rw > 0;

        }

        return false;
    }

    /**
     * 修改信息
     * 
     * @return 0: 无此用户ID 1：修改成功 2：密码不符
     */
    public int updateInfo(String userId, String nickName, String userIntro, String phone, String originalUserPass,
            String newUserPass, String userStatus) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        if (businessUser == null) {
            return 0;
        }
        if (!businessUser.getUserPass().equals(originalUserPass)) {
            return 2;
        }
        if (!businessUser.getNickName().equals(nickName)) {
            businessUserDao.updateNickName(userId, nickName);
        }
        if (!businessUser.getUserIntro().equals(userIntro)) {
            businessUserDao.updateUserIntro(userId, userIntro);
        }
        if (!businessUser.getPhone().equals(phone)) {
            businessUserDao.updatePhone(userId, phone);
        }
        if (!originalUserPass.equals(newUserPass)) {
            if (newUserPass != null) {
                String passSalt= RandomUtil.randomString(10);
                String encyptPassWord = EncryptUtil.getDigestHex(newUserPass,passSalt);
                businessUserDao.updateUserPass(userId, encyptPassWord);
            }
        }

        if (!businessUser.getUserStatus().equals(userStatus)) {
            businessUserDao.updateUserStatus(userId, userStatus);
        }
        return 1;

    }

    /** 注册用户 */
    public Boolean BusinessUserRegister(String userId, String userName, String nickName, String phone, String userPass)
            throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);
        if (businessUser != null) {
            return false;
        } else {
            businessUser= new BusinessUser();
            businessUser.setUserId(userId);
            businessUser.setUserName(userName);
            businessUser.setNickName(nickName);
            String  passSalt= RandomUtil.randomString(10);
            String encryptPassword = EncryptUtil.getDigestHex(userPass,passSalt);
            businessUser.setUserPass(encryptPassword);
            businessUser.setPassSalt(passSalt);
            businessUser.setPhone(phone);
            return businessUserDao.insert(businessUser) > 0;
        }

    }

}
