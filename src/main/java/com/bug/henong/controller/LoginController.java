package com.bug.henong.controller;

import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * @author Tan
 */
@Controller

public class LoginController {

    private LoginService loginService;
    @GetMapping(value = "/login")
    public String login() {
        //填入返回地址
        return "/login";
    }

//    @PostMapping(value = "/login")
//    public String login(@RequestParam("userId") String userId,
//                        @RequestParam("password") String password,
//                        @RequestParam("type") String type,
//                        HttpSession session) throws SQLException {
//        if (userId==null || password==null) {
//            session.setAttribute("errorMsg", "用户名或密码不能为空");
//            return "/login";
//        }
//        switch (type){
//            case "farmer":
//                Farmer farmer = loginService.farmerLogin(userId,password);
//                if(farmer!=null){
//                    session.setAttribute("loginUser", farmer.getFarmerName());
//                    session.setAttribute("loginUserId", farmer.getFarmerId());
//                    //session过期时间设置为7200秒 即两小时
//                    session.setMaxInactiveInterval(60 * 60 * 2);
//                    return "redirect:/farmer/index";
//                }
//            case "buyer":
//                BuyerUser buyerUser = loginService.buyerLogin(userId,password);
//                if(buyerUser!=null){
//                    session.setAttribute("loginUser", buyerUser.getUserName());
//                    session.setAttribute("loginUserId", buyerUser.getUserId());
//                    //session过期时间设置为7200秒 即两小时
//                    session.setMaxInactiveInterval(60 * 60 * 2);
//                    return "redirect:/index";
//                }
//            case "business":
//                BusinessUser businessUser = loginService.businessUserLogin(userId,password);
//                if(businessUser!=null){
//                    session.setAttribute("loginUser", businessUser.getUserName());
//                    session.setAttribute("loginUserId", businessUser.getUserId());
//                    //session过期时间设置为7200秒 即两小时
//                    session.setMaxInactiveInterval(60 * 60 * 2);
//                    return "redirect:/business/index";
//                }
//            default:
//                break;
//        }
//        return "/login";
//    }
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        String id = request.getParameter("userId");
        System.out.println(id);
        return "/login";
    }
//    @GetMapping("/login1")
//    @ResponseBody
//    public String login1(HttpServletRequest request){
//        System.out.println("success");
//        return "/index";
//    }
    @PostMapping("/login1")
    @ResponseBody
    public String login1(HttpServletRequest request){
        System.out.println("success");
        return "/index";
    }
}
