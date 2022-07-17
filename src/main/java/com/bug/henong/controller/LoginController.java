package com.bug.henong.controller;

import com.bug.henong.utils.MapFactory;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tan
 */
@Controller

public class LoginController {

    private LoginService loginService = new LoginService();

    @PostMapping(value = "/login" )
    @ResponseBody
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        HttpSession session) throws SQLException {

        if (userId==null || password==null) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return null;
        }

        MapFactory mapFactory =new MapFactory();

        if(loginService.login(userId,password,type)){

            session.setAttribute("loginUserId",userId );
            return mapFactory.getStringObjectMap(session);
        }
        return null ;
    }

}
