package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.FarmerService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

@RestController
public class FarmerInfoController {
    private FarmerService farmerService = new FarmerService();

    @RequestMapping("/farmer/showAllInfo")
    public String showAllInfo(HttpSession session) throws SQLException{
        Object userId = session.getAttribute("userId");
        String id = (String) userId;
        Farmer farmer = farmerService.getFarmerDetailById(id);
        if(farmer == null){
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;

        }
        String json = JSON.toJSONString(farmer);
        return json;
    }

    @PostMapping("/farmer/update")
    public Map<String , Object> updateInfo(@RequestParam("farmerName") String farmerName , @RequestParam("farmerAge") int farmerAge, @RequestParam("farmerPlace") String farmerPlace
                            , @RequestParam("businessId") String businessId, @RequestParam("originUserPass") String originalUserPass, @RequestParam("newUserPass") String newUserPass,
                          @RequestParam("userId") String userId,HttpSession session) throws SQLException {


        Farmer farmer = farmerService.getFarmerDetailById(userId);
        if (farmer == null) {
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;
        }
        if (!farmer.getUserPass().equals(originalUserPass)) {
            session.setAttribute("errorMsg", "原密码不等");
            return null;
        }
        if (!farmer.getFarmerName().equals(farmerName)) {
            farmerService.updateFarmerName(userId, farmerName);
        }
        if (farmer.getFarmerAge() != farmer.getFarmerAge()) {
            farmerService.updateFarmerAge(userId, farmerAge);
        }
        if (!farmer.getFarmerPlace().equals(farmerPlace)) {
            farmerService.updatePlace(userId, farmerPlace);
        }
        if (!farmer.getBusinessId().equals(businessId)) {
            farmerService.updateBusinessId(userId, businessId);
        }
        if (!originalUserPass.equals(newUserPass)) {
            if (newUserPass != null) {
                farmerService.updatePassword(userId, newUserPass);
                //修改密码盐

            }
        }
        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
}
