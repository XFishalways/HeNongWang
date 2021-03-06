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
    @ResponseBody
    public String showAllInfo(@RequestParam String userId, HttpSession session) throws SQLException{
        Farmer farmer = farmerService.getFarmerDetailById(userId);
        if(farmer == null){
            session.setAttribute("errorMsg", "查找不到用户id");
            return null;

        }
        String json = JSON.toJSONString(farmer);
        return json;
    }

    /**
     *调试用代码
     *
     */

    @GetMapping(value = "/farmer/update")
    @ResponseBody
    public String update(@RequestParam("farmerName") String farmerName) {
        System.out.println("1");
        return farmerName;
    }

    @PostMapping("/farmer/update")
    @ResponseBody
    public String updateInfo(@RequestParam("userId") String userId, @RequestParam("farmerName") String farmerName , @RequestParam("farmerAge") String farmerage, @RequestParam("farmerPlace") String farmerPlace
                            , @RequestParam("businessId") String businessId, @RequestParam("originalUserPass") String originalUserPass, @RequestParam("newUserPass") String newUserPass,
                          HttpSession session) throws SQLException {

        int farmerAge = Integer.parseInt(farmerage);
        int result = farmerService.updateInfo(userId,farmerName,farmerAge,farmerPlace,businessId,originalUserPass,newUserPass);


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
    @PostMapping("/farmer/register")
    @ResponseBody
    public String register(@RequestParam("farmerId") String farmerId,@RequestParam("farmerName") String farmerName,
                           @RequestParam("password")String password ,@RequestParam("farmerAge") String farmerage,
                           @RequestParam("farmerPlace")String farmerPlace, HttpSession session  ) throws SQLException {
        int farmerAge = Integer.parseInt(farmerage);
        Boolean result = farmerService.register(farmerId, farmerName, password,farmerAge,farmerPlace);
        if(result==false){
            session.setAttribute("errorMsg", "id已被占用");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
}

