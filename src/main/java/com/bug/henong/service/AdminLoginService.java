package com.bug.henong.service;


import com.bug.henong.dao.AdminDao;
import com.bug.henong.entity.Admin;
import com.bug.henong.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("AdminLoginService")
public class AdminLoginService {

    private AdminDao adminDao = new AdminDao();

    /**
     * 管理员登录
     */
    public Admin adminLogin(String id, String password) throws SQLException {
        String passSalt= adminDao.getAdminPassSalt(id);
        String encyptPassWord = EncryptUtil.getDigestHex(password,passSalt);
        return adminDao.login(id, encyptPassWord);
    }


}
