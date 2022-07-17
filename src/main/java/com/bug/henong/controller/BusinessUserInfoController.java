package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.service.BusinessUserService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.SQLException;

@Controller
public class BusinessUserInfoController {

    private BusinessUserService businessUserService = new BusinessUserService();

    /**
     * 查询卖家所有信息
     * */
    @RequestMapping(value = "/businessUser/showAllInfo", method = RequestMethod.GET)
    public String showAllInfo(HttpSession session) throws SQLException{
       Object userId = session.getAttribute("userId");
       String id = (String) userId;
       BusinessUser businessUser = businessUserService.getBusinessUserDetailById(id);
       if(businessUser == null) {
           session.setAttribute("errorMsg", "查找不到用户id");
           return  null;

       }

       String json = JSON.toJSONString(businessUser);
       return json;

    }

    @PostMapping("/businessUser/update")
    public String updateInfo(@RequestParam("userId") String userId,
                             @RequestParam("nickName") String nickName,
                             @RequestParam("userIntro") String userIntro,
                             @RequestParam("phone") String phone,
                             @RequestParam("originalUserPass") String originalUserPass,
                             @RequestParam("newUserPass") String newUserPass,
                             @RequestParam("userStatus") String userStatus,
                             HttpSession session) throws SQLException, FileNotFoundException {

        int result = businessUserService.updateInfo(userId, nickName, userIntro, phone, originalUserPass, newUserPass, userStatus);

        if (result==0) {
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;
        }
        if (result == 2 ) {
            session.setAttribute("errorMsg", "原密码不等");
            return null;
        }

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @PostMapping("/business/register")
    public String businessUserRegister (@RequestParam("userId") String userId,
                                        @RequestParam("userName")String userName,
                                        @RequestParam("nickName")String nickName,
                                        @RequestParam("phone")String phone,
                                        @RequestParam("userPass")String userPass,
                                        HttpSession session) throws SQLException{

        Boolean result = businessUserService.BusinessUserRegister(userId, userName, nickName, phone, userPass);
        if(result==false){
            session.setAttribute("errorMsg", "id已被占用");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
}
