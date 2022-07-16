package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.FarmerService;
import com.bug.henong.utils.MapFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

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
        int result = farmerService.updateInfo(userId,farmerName,farmerAge,farmerPlace,businessId,originalUserPass,newUserPass);


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
    @PostMapping("/farmer/register")
    public String register(@RequestParam("userId") String farmerId,@RequestParam("farmerName") String farmerName,
                           @RequestParam("password") String password,HttpSession session  ) throws SQLException {
        Boolean result = farmerService.register(farmerId, farmerName, password);
        if(result==false){
            session.setAttribute("errorMsg", "id已被占用");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
}

