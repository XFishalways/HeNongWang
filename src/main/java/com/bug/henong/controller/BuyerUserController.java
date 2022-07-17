package com.bug.henong.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.service.BuyerUserService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class BuyerUserController {

    private BuyerUserService buyerUserService = new BuyerUserService();

    /**
     * 查询买家信息
     */
    @GetMapping("/buyer/findAllInfo")
    public String showAllInfo(@RequestParam("userId") String userId,
                              HttpSession session) throws SQLException {
        String json;

        List<BuyerUser> buyerUsers = buyerUserService.getUserDetailById(userId);

        if(buyerUsers == null){
            session.setAttribute("errorMsg", "查找不到卖家地址id");
            return JSONUtil.toJsonStr(buyerUsers);
        }

        json = JSON.toJSONString(buyerUsers);
        return json;
    }

    /**
     *更新买家信息
     */
    @RequestMapping(value = "/buyer/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateInfo(@RequestParam("userId") String userId,
                             @RequestParam("nickName") String nickName,
                             @RequestParam("userIntro") String userIntro,
                             @RequestParam("phone") String phone,
                             @RequestParam("userStatus") String userStatus,
                             @RequestParam("originalPass") String originalPass,
                             @RequestParam("newPass") String newPass,
                             HttpSession session)throws SQLException{

        int result = buyerUserService.updateInfo(userId, nickName, userIntro, phone, userStatus, originalPass, newPass);

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
