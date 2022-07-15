package com.bug.henong.controller;

import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Map<String,Object> login(@RequestParam("userId") String userId,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        HttpSession session) throws SQLException {

        if (userId==null || password==null) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return null;
        }

        switch (type){

            case "farmer":
                Farmer farmer = loginService.farmerLogin(userId,password);
                if(farmer!=null){
                    session.setAttribute("userId", farmer.getFarmerName());
                    session.setAttribute("loginUserId", farmer.getFarmerId());

                    return getStringObjectMap(session,type);
                }

            case "buyer":
                BuyerUser buyerUser = loginService.buyerLogin(userId,password);
                if(buyerUser!=null){
                    session.setAttribute("loginUser", buyerUser.getUserName());
                    session.setAttribute("loginUserId", buyerUser.getUserId());

                    return getStringObjectMap(session,type);
                }

            case "business":
                BusinessUser businessUser = loginService.businessUserLogin(userId,password);
                if(businessUser!=null){
                    session.setAttribute("loginUser", businessUser.getUserName());
                    session.setAttribute("loginUserId", businessUser.getUserId());

                    return getStringObjectMap(session,type);
                }
            default:
                break;
        }
        return null;
    }

    private Map<String, Object> getStringObjectMap(HttpSession session,String type) {

        session.setMaxInactiveInterval(60 * 60 * 2);
        //session过期时间设置为7200秒 即两小时

        Map<String,Object> map = new HashMap<>();
        map.put("message","ok");
        map.put("code",0);
        map.put("success","success");
        map.put("type",type);

        return map;
    }
}
