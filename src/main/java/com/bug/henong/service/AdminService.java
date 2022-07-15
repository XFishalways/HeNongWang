package com.bug.henong.service;

import com.bug.henong.dao.AdminDao;
import com.bug.henong.dao.ProductExamineDao;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.ProductExamine;
import java.sql.SQLException;

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
    public Boolean updateNickName(String loginAdminId, String originalNickName, String newNickName) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
            if (originalNickName.equals(admin.getAdminName())) {
                int rw = adminDao.updateName(newNickName,loginAdminId);
                return rw > 0;
            }

        }

        return false;
    }

    /**
     * 修改管理员密码
     */
    public Boolean updatePassword(String loginAdminId, String originalPassword, String newPassword) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
            if (originalPassword.equals(admin.getAdminPasswd())) {
                int rw = adminDao.updatePass(newPassword,loginAdminId);
                return rw > 0;
            }

        }

        return false;
    }
    /**
     * 修改管理员手机
     */
    public Boolean updatePhone(String loginAdminId, String originalPhone, String newPhone) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
            if (originalPhone.equals(admin.getAdminPhone())) {
                int rw = adminDao.updatePhone(newPhone,loginAdminId);
                return rw > 0;
            }

        }

        return false;
    }

    /**
     * 修改管理员密码盐
     */
    public Boolean updatePassSalt(String loginAdminId, String originalPassSalt, String newPassSalt) throws SQLException {
        Admin admin = adminDao.findOneAdmin(loginAdminId);

        //当前用户非空才可以进行更改
        if (admin != null) {
            if (originalPassSalt.equals(admin.getPassSalt())) {
                int rw = adminDao.updatePassSalt(newPassSalt,loginAdminId);
                return rw > 0;
            }

        }

        return false;
    }


}
