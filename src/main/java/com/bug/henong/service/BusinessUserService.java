package com.bug.henong.service;

import com.bug.henong.dao.BusinessUserDao;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("BusinessUserService")
public class BusinessUserService {

    private BusinessUserDao businessUserDao =new BusinessUserDao();

    /**得到买家信息*/
    public BusinessUser getBusinessUserDetailById(String userId) throws SQLException {
        return businessUserDao.findOneBusiness(userId);
    }

    /**修改昵称*/
    public Boolean updateNickName(String userId, String newNickName) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updateNickName(userId, newNickName);
                return rw > 0;


        }

        return false;
    }

    /**修改签名*/
    public Boolean updateUserIntro(String userId,  String newUserIntro) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updateUserIntro(userId, newUserIntro);
                return rw > 0;


        }

        return false;
    }

    /**修改头像*/
    public Boolean updateAvatar(String userId,String newAvatar) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updateAvatar(userId, newAvatar);
                return rw > 0;


        }

        return false;
    }

    /**修改手机号*/
    public Boolean updatePhone(String userId, String newPhone) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updatePhone(userId, newPhone);
                return rw > 0;


        }

        return false;
    }

    /**修改密码*/
    public Boolean updateUserPass(String userId, String newUserPass) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updateUserPass(userId, newUserPass);
                return rw > 0;


        }

        return false;
    }

    /**修改密码盐*/
    public Boolean updatePassSalt(String userId,  String newPassSalt) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updatePassSalt(userId, newPassSalt);
                return rw > 0;


        }

        return false;
    }

    /**修改状态*/
    public Boolean updateUserStatus(String userId,  String newUserStatus) throws SQLException {
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);

        //当前用户非空才可以进行更改
        if (businessUser != null) {

                int rw = businessUserDao.updateUserStatus(userId, newUserStatus);
                return rw > 0;


        }

        return false;
    }

    /**修改信息
     * @return  0: 无此用户ID 1：修改成功 2：密码不符
     * */
    public int updateInfo(String userId, String nickName, String userIntro, String avatar, String phone, String originalUserPass, String newUserPass, String passSalt, String userStatus) throws SQLException{
        BusinessUser businessUser = getBusinessUserDetailById((String) userId);

        if (businessUser == null) {
            return 0;
        }
        if (!businessUser.getUserPass().equals(originalUserPass)){
            return  2;
        }
        if (!businessUser.getNickName().equals(nickName)){
            updateNickName((String) userId , nickName );
        }
        if (!businessUser.getUserIntro().equals(userIntro)){
            updateUserIntro((String) userId , userIntro );
        }
        if (!businessUser.getAvatar().equals(avatar)){
            updateAvatar((String) userId , avatar );
        }
        if (!businessUser.getPhone().equals(phone)){
            updatePhone((String) userId , phone );
        }
            if (!originalUserPass.equals(newUserPass)){
                if (newUserPass != null) {
                    updateUserPass((String) userId, newUserPass);
                }
        }
        if (!businessUser.getPassSalt().equals(passSalt)){
            updatePassSalt((String) userId , passSalt );
        }
        if (!businessUser.getUserStatus().equals(userStatus)){
            updateUserStatus((String) userId , userStatus );
        }
        return 1;

    }
    /**注册用户*/
    public Boolean BusinessUserRegister(String userId, String userName, String nickName, String userIntro, String avatar, String phone, String userPass) throws SQLException{
        BusinessUser businessUser = businessUserDao.findOneBusiness(userId);
        if (businessUser==null){
            return  false;
        }else {
            businessUser.setUserId(userId);
            businessUser.setUserName(userName);
            businessUser.setNickName(nickName);
            businessUser.setUserIntro(userIntro);
            businessUser.setAvatar(avatar);
            businessUser.setUserPass(userPass);
            businessUser.setPhone(phone);
            return businessUserDao.insert(businessUser)>0;
        }

    }

}
