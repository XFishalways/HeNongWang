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
    public Map<String , Object> updateInfo(@RequestParam String farmerName , @RequestParam int farmerAge, @RequestParam String farmerPlace
                            , @RequestParam String businessId, @RequestParam String originalUserPass, @RequestParam String newUserPass,
                          HttpSession session) throws SQLException {
        Object userId = session.getAttribute("userId");
        String id = (String) userId;

        Farmer farmer = farmerService.getFarmerDetailById(id);
        if (farmer == null) {
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;
        }
        if (!farmer.getUserPass().equals(originalUserPass)) {
            session.setAttribute("errorMsg", "原密码不等");
            return null;
        }
        if (!farmer.getFarmerName().equals(farmerName)) {
            farmerService.updateFarmerName(id, farmerName);
        }
        if (farmer.getFarmerAge() != farmer.getFarmerAge()) {
            farmerService.updateFarmerAge(id, farmerAge);
        }
        if (!farmer.getFarmerPlace().equals(farmerPlace)) {
            farmerService.updatePlace(id, farmerPlace);
        }
        if (!farmer.getBusinessId().equals(businessId)) {
            farmerService.updateBusinessId(id, businessId);
        }
        if (!originalUserPass.equals(newUserPass)) {
            if (newUserPass != null) {
                farmerService.updatePassword(id, newUserPass);
                //修改密码盐

            }
        }
        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
}
