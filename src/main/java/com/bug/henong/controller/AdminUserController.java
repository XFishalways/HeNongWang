package com.bug.henong.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.service.AdminUserService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class AdminUserController {
    private AdminUserService adminUserService = new AdminUserService();

    /**
     * 查询管理员信息
     */
    @GetMapping("/admin/findAdmin")
    public String findOneAdmin(@RequestParam("userId") String userId,
                              HttpSession session) throws SQLException {
        String json;

        List<Admin> admins = adminUserService.getAdminDetailById(userId);

        if(admins == null){
            session.setAttribute("errorMsg", "查找不到管理员地址id");
            Admin admin = new Admin();
            return JSONUtil.toJsonStr(admin);
        }

        json = JSON.toJSONString(admins);
        return json;
    }

    /**
     *更新管理员信息
     */
    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateInfo(@RequestParam("adminId") String adminId,
                             @RequestParam("adminName") String adminName,
                             @RequestParam("phone") String phone,
                             @RequestParam("originalPass") String originalPass,
                             @RequestParam("newPass") String newPass,
                             HttpSession session)throws SQLException{

        int result = adminUserService.updateInfo(adminId, adminName, phone, originalPass, newPass);

        if (result == 0 ) {
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

    /**
     * 注册买家信息
     */
    @PostMapping("/admin/register")
    public String register(@RequestParam("adminId") String adminId,
                           @RequestParam("adminName") String adminName,
                           @RequestParam("phone") String phone,
                           @RequestParam("adminPass") String adminPass,
                           HttpSession session) throws SQLException{
        Boolean result = adminUserService.register(adminId, adminName, phone, adminPass); if(result==false){
            session.setAttribute("errorMsg", "id已被占用");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }

}
