package com.bug.henong.controller;

import com.bug.henong.dao.AdminDao;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.AdminLoginService;
import com.bug.henong.utils.EncryptUtil;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class AdminLoginController {

    private AdminLoginService adminLoginService = new AdminLoginService();

    @PostMapping(value = "/admin/login" )
    @ResponseBody
    public String login(@RequestParam("adminId") String adminId,
                        @RequestParam("adminPasswd") String adminPasswd,
                        HttpSession session) throws SQLException{
        if (adminId == null || adminPasswd ==null){
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return null;
        }

        else{
            MapFactory mapFactory =new MapFactory();
            adminLoginService.adminLogin(adminId, adminPasswd);
            session.setAttribute("adminId", adminId);
            return mapFactory.getStringObjectMap(session);

        }

    }

}
