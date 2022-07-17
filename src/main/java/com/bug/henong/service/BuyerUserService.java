package com.bug.henong.service;

import cn.hutool.core.util.RandomUtil;
import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service("BuyerUserService")
public class BuyerUserService {

    private BuyerUserDao buyerUserDao = new BuyerUserDao();

    /**
     * 得到买家信息
     */
    public List<BuyerUser> getUserDetailById(String UserId) throws SQLException {
        return buyerUserDao.findAll(UserId);
    }

    /**
     * 修改昵称
     */
    public Boolean updateNickName(String userId,  String newNickName) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateNickName(userId, newNickName);
                return rw > 0;


        }

        return false;
    }

    /**
     * 修改签名
     */
    public Boolean updateUserIntro(String userId, String newUserIntro) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateUserIntro(userId, newUserIntro);
                return rw > 0;


        }
        return false;
    }

    /**修改头像*/
    public Boolean updateAvatar(String userId, String newAvatar) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateAvatar(userId, newAvatar);
                return rw > 0;


        }
        return false;
    }

    /**修改手机号*/
    public Boolean updatePhone(String userId, String newPhone) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updatePhone(userId, newPhone);
                return rw > 0;


        }
        return false;
    }

    /**修改密码*/
    public Boolean updateUserPass(String userId, String newUserPass) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateUserPass(userId, newUserPass);
                return rw > 0;


        }
        return false;
    }

    /**修改密码盐*/
    public Boolean updatePassSalt(String userId, String newPassSalt) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updatePassSalt(userId, newPassSalt);
                return rw > 0;


        }
        return false;
    }

    /**修改状态*/
    public Boolean updateUserStatus(String userId,  String newUserStatus) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateUserStatus(userId, newUserStatus);
                return rw > 0;


        }
        return false;
    }

    /**修改累计消费金额*/
    public Boolean updateTotalCostAmt(String userId,  Double newTotalCostAmt) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateTotalCostAmt(userId, newTotalCostAmt);
                return rw > 0;


        }
        return false;
    }

    /**修改最后登录时间*/
    public Boolean updateLastLoginTime(String userId,  Timestamp newLastLoginTime) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        //当前用户非空才可以进行更改
        if (buyerUser != null) {

                int rw = buyerUserDao.updateLastLoginTime(userId, newLastLoginTime);
                return rw > 0;


        }
        return false;
    }

    public int updateInfo(String userId, String nickName, String userIntro, String phone, String userStatus, String originalPass, String newPass) throws SQLException {
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);

        if (buyerUser == null) {
            return 0;
        }

        if (!buyerUser.getUserPass().equals(originalPass)) {
            return 2;
        }
        if (!buyerUser.getNickName().equals(nickName)) {
            buyerUserDao.updateNickName(userId, nickName);
        }
        if (!buyerUser.getUserIntro().equals(userIntro)) {
            buyerUserDao.updateUserIntro(userId, userIntro);
        }
        if (!buyerUser.getPhone().equals(phone)) {
            buyerUserDao.updatePhone(userId, phone);
        }
        if (!buyerUser.getUserStatus().equals(userStatus)) {
            buyerUserDao.updateUserStatus(userId, userStatus);
        }
        if (!originalPass.equals(newPass)) {
            if (newPass != null) {
                buyerUserDao.updatePassSalt(userId, newPass);
                //修改密码盐

            }
        }


        return 1;

    }


    public Boolean register(String userId, String userName, String nickName,
                             String phone, String userPass)throws SQLException{
        BuyerUser buyerUser = buyerUserDao.findOneBuyer(userId);
        if(buyerUser == null){
            return false;
        }else{
            buyerUser.setUserId(userId);
            buyerUser.setUserName(userName);
            buyerUser.setNickName(nickName);
            buyerUser.setPhone(phone);
            String  passSalt= RandomUtil.randomString(10);
            String encryptPassword = EncryptUtil.getDigestHex(userPass,passSalt);
            buyerUser.setUserPass(encryptPassword);
            return buyerUserDao.insert(buyerUser)>0;
        }
    }

}
