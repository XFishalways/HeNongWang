package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.service.BuyerUserService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;

@Controller
public class BuyerUserController {
    private BuyerUserService buyerUserService = new BuyerUserService();

    /**
     * 查询买家信息
     */
    @GetMapping("/buyer/showAllInfo")
    public String showAllInfo(HttpSession session) throws SQLException {
        Object buyerUserId = session.getAttribute("buyerUserId");
        String id = (String) buyerUserId;
        BuyerUser buyerUser = buyerUserService.getUserDetailById(id);

        if(buyerUser == null){
            session.setAttribute("errorMsg", "查找不到卖家地址id");
            return null;
        }

        String json = JSON.toJSONString(buyerUser);
        return json;
    }

    /**
     *更新买家信息
     */
    @PostMapping("/buyer/update")
    public String updateInfo(@RequestParam("userId") String userId,
                             @RequestParam("nickName") String nickName,
                             @RequestParam("userIntro") String userIntro,
                             @RequestParam("avatar") String avatar,
                             @RequestParam("phone") String phone,
                             @RequestParam("userStatus") String userStatus,
                             @RequestParam("originalPass") String originalPass,
                             @RequestParam("newPass") String newPass,
                             HttpSession session)throws SQLException{

        int result = buyerUserService.updateInfo(userId,nickName, userIntro, avatar,
                 phone,  userStatus, originalPass, newPass);

        if (result==0) {
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;
        }
        if (result == 1 ) {
            session.setAttribute("errorMsg", "原密码不等");
            return null;
        }

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }

    /**
     * 注册买家信息
     */
    @PostMapping("/buyer/register")
    public String register(@RequestParam("userId") String userId,
                           @RequestParam("userName") String userName,
                           @RequestParam("nickName") String nickName,
                           @RequestParam("phone") String phone,
                           @RequestParam("userPass") String userPass,
                           HttpSession session) throws SQLException{
        Boolean result = buyerUserService.register(userId, userName, nickName, phone, userPass); if(result==false){
            session.setAttribute("errorMsg", "id已被占用");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }

}
