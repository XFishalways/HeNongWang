package com.bug.henong.controller;

import com.bug.henong.utils.MapFactory;
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

        switch (type){

            case "farmer":
                Farmer farmer = loginService.farmerLogin(userId,password);
                if(farmer!=null){
                    session.setAttribute("userId", farmer.getFarmerName());
                    session.setAttribute("loginUserId", farmer.getFarmerId());

                    System.out.println(mapFactory.getStringObjectMapWithType(session,type));
                    return mapFactory.getStringObjectMap(session);
                }

            case "buyer":
                BuyerUser buyerUser = loginService.buyerLogin(userId,password);
                if(buyerUser!=null){
                    session.setAttribute("loginUser", buyerUser.getUserName());
                    session.setAttribute("loginUserId", buyerUser.getUserId());

                    return mapFactory.getStringObjectMap(session);
                }

            case "business":
                BusinessUser businessUser = loginService.businessUserLogin(userId,password);
                if(businessUser!=null){
                    session.setAttribute("loginUser", businessUser.getUserName());
                    session.setAttribute("loginUserId", businessUser.getUserId());

                    return mapFactory.getStringObjectMap(session);
                }
            default:
                break;
        }
        return null ;
    }

}
