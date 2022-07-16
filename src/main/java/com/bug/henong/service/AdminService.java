package com.bug.henong.service;

import com.bug.henong.dao.AdminDao;
import com.bug.henong.dao.ProductExamineDao;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.ProductExamine;
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


}
