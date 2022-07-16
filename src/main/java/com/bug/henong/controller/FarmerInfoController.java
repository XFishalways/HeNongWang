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

    @GetMapping(value = "/farmer/update")
    public String update(@RequestParam("farmerName") String farmerName) {
        System.out.println("1");
        return farmerName;
    }

    @PostMapping("/farmer/update")
    public String updateInfo(@RequestParam("userId") String userId, @RequestParam("farmerName") String farmerName , @RequestParam("farmerAge") String farmerage, @RequestParam("farmerPlace") String farmerPlace
                            , @RequestParam("businessId") String businessId, @RequestParam("originalUserPass") String originalUserPass, @RequestParam("newUserPass") String newUserPass,
                          HttpSession session) throws SQLException {

        int farmerAge = Integer.parseInt(farmerage);
        Farmer farmer = farmerService.getFarmerDetailById((String) userId);
        if (farmer == null) {
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;
        }
        if (!farmer.getUserPass().equals(originalUserPass)) {
            session.setAttribute("errorMsg", "原密码不等");
            return null;
        }
        if (!farmer.getFarmerName().equals(farmerName)) {
            farmerService.updateFarmerName((String) userId, farmerName);
        }
        if (farmer.getFarmerAge() != farmer.getFarmerAge()) {
            farmerService.updateFarmerAge((String) userId, farmerAge);
        }
        if (!farmer.getFarmerPlace().equals(farmerPlace)) {
            farmerService.updatePlace((String) userId, farmerPlace);
        }
        if (!farmer.getBusinessId().equals(businessId)) {
            farmerService.updateBusinessId((String) userId, businessId);
        }
        if (!originalUserPass.equals(newUserPass)) {
            if (newUserPass != null) {
                farmerService.updatePassword((String) userId, newUserPass);
                //修改密码盐

            }
        }
        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
}
