package com.bug.henong.service;

import cn.hutool.core.util.RandomUtil;
import com.bug.henong.dao.AdminUserDao;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("AdminUserService")
public class AdminUserService {

    private AdminUserDao adminUserDao = new AdminUserDao();

    /**
     * 得到管理员信息
     */
    public List<Admin> getAdminDetailById(String adminId) throws SQLException {
        return adminUserDao.findAll(adminId);
    }

    /**
     * 修改管理员用户名
     */
    public Boolean updateAdminName(String userId,  String adminkName) throws SQLException {
        Admin admin = adminUserDao.findOneAdmin(userId);

        //当前用户非空才可以进行更改
        if (admin != null) {

            int rw = adminUserDao.updateAdminName(userId, adminkName);
            return rw > 0;


        }

        return false;
    }

    /**
     * 修改手机号
     */
    public Boolean updatePhone(String userId,  String phone) throws SQLException {
        Admin admin = adminUserDao.findOneAdmin(userId);

        //当前用户非空才可以进行更改
        if (admin != null) {

            int rw = adminUserDao.updatePhone(userId, phone);
            return rw > 0;


        }

        return false;
    }

    /**
     * 修改密码
     */
    public Boolean updatePassWD(String userId,  String passWD) throws SQLException {
        Admin admin = adminUserDao.findOneAdmin(userId);

        //当前用户非空才可以进行更改
        if (admin != null) {

            int rw = adminUserDao.updatePass(userId, passWD);
            return rw > 0;


        }

        return false;
    }

    /**
     * 修改密码盐
     */
    public Boolean updatePassSalt(String userId,  String passSalt) throws SQLException {
        Admin admin = adminUserDao.findOneAdmin(userId);

        //当前用户非空才可以进行更改
        if (admin != null) {

            int rw = adminUserDao.updatePassSalt(userId, passSalt);
            return rw > 0;


        }

        return false;
    }

    public int updateInfo(String adminId, String adminName, String phone, String originalPass, String newPass)throws SQLException{
        Admin admin = adminUserDao.findOneAdmin(adminId);

        if(admin == null){
            return 0;
        }
        if(!admin.getAdminName().equals(adminName)){
            return 2;
        }
        if(!admin.getAdminPhone().equals(phone)){
            return 2;
        }
        if(!originalPass.equals(newPass)){
            if(newPass != null){
                String passSalt = RandomUtil.randomString(10);
                String encyptPassWord = EncryptUtil.getDigestHex(newPass,passSalt);
                adminUserDao.updatePass(adminId, encyptPassWord);
            }
            return 2;
        }
        return 1;
    }

    public Boolean register(String adminId, String adminName,
                            String phone, String adminPass)throws SQLException{
        Admin admin = adminUserDao.findOneAdmin(adminId);
        if(admin == null){
            return false;
        }else{
            admin.setAdminId(adminId);
            admin.setAdminName(adminName);
            admin.setAdminPhone(phone);
            String  passSalt= RandomUtil.randomString(10);
            String encryptPassword = EncryptUtil.getDigestHex(adminPass,passSalt);
            admin.setAdminPasswd(encryptPassword);
            return adminUserDao.insert(admin)>0;
        }
    }

}
