package com.bug.henong.service;

import cn.hutool.core.util.RandomUtil;
import com.bug.henong.dao.AdminDao;
import com.bug.henong.dao.ProductExamineDao;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.ProductExamine;
import com.bug.henong.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("AdminService")
public class AdminService {



    private AdminDao adminDao = new AdminDao();



    /**
     * 得到管理员ID信息
     */
    public Admin getAdminId(String loginAdminId) throws SQLException {
        return adminDao.findOneAdmin(loginAdminId);
    }

    /**
     * 修改管理员用户名
     */
    public Boolean updateNickName(String loginAdminId, String newNickName) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
                int rw = adminDao.updateName(newNickName,loginAdminId);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改管理员密码
     */
    public Boolean updatePassword(String loginAdminId, String newPassword) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
                int rw = adminDao.updatePass(newPassword,loginAdminId);
                return rw > 0;

        }

        return false;
    }
    /**
     * 修改管理员手机
     */
    public Boolean updatePhone(String loginAdminId, String newPhone) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
                int rw = adminDao.updatePhone(newPhone,loginAdminId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改管理员密码盐
     */
    public Boolean updatePassSalt(String loginAdminId, String newPassSalt) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
                int rw = adminDao.updatePassSalt(newPassSalt,loginAdminId);
                return rw > 0;

        }

        return false;
    }

    /**修改信息
     * @return  0: 无此用户ID 1：修改成功 2：密码不符
     * */
    public int updateInfo(String adminId, String adminName, String originalAdminPass, String newAdminPass, String phone) throws SQLException{
        Admin admin = adminDao.findOneAdmin(adminId);

        if (admin == null){
            return 0;
        }
        String originalPassSalt =admin.getPassSalt();
        String realEncryptPassword = admin.getAdminPasswd();
        String originalEncryptPassWord = EncryptUtil.getDigestHex(originalAdminPass,originalPassSalt);
        if (!realEncryptPassword.equals(originalEncryptPassWord)) {
            return 2;
        }
        if (!admin.getAdminName().equals(adminName)){
            adminDao.updateName(adminId,adminName);
        }
        if (!admin.getAdminPhone().equals(phone)){
            adminDao.updatePhone(adminId,phone);
        }
        if (!originalAdminPass.equals(newAdminPass)) {
            if (newAdminPass != null) {
                String passSalt= RandomUtil.randomString(10);
                String encyptPassWord = EncryptUtil.getDigestHex(newAdminPass,passSalt);
                updatePassword(adminId, encyptPassWord);
                //修改密码盐

            }
        }
        return 1;

    }

}
