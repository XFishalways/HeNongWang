package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessBuyrecord;
import com.bug.henong.service.BusinessBuyRecordService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class BusinessBuyRecordController {
    BusinessBuyRecordService businessBuyRecordService = new BusinessBuyRecordService();

    @RequestMapping("/business/buyrecord/getRecordsByName")
    @ResponseBody
    public String getRecordsByBusinessId(@RequestParam("userId")String userId, HttpSession session) throws SQLException {
        List<BusinessBuyrecord>businessBuyrecords = businessBuyRecordService.getBuyRecordByByBusinessId(userId);
        if(businessBuyrecords==null){
            session.setAttribute("errorMsg","未找到该记录");
            return null;
        }else {
            String json = JSON.toJSONString(businessBuyrecords);
            return json;
        }
    }

    @PostMapping("/business/buyrecord/confirm")
    @ResponseBody
    public String confirm(@RequestParam("recordId")String recordId,@RequestParam("addressId")String addressId, HttpSession session) throws SQLException {
        boolean result = businessBuyRecordService.confirmRecord(recordId,addressId);
        if(result==false){
            session.setAttribute("errorMsg","无法确认");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
    @PostMapping("/business/buyrecord/deny")
    @ResponseBody
    public String deny(@RequestParam("recordId")String recordId,HttpSession session) throws SQLException {
        boolean result = businessBuyRecordService.denyRecord(recordId);
        if(result==false){
            session.setAttribute("errorMsg","无法删除");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
    @GetMapping("/business/buyrecord/getAddressId")
    @ResponseBody
    public String getAddressId(@RequestParam("userId")String businessId,HttpSession session) throws SQLException {
        Map<String,String> addressIds = businessBuyRecordService.getAddressByBusinessId(businessId);

        if(addressIds==null){
            session.setAttribute("errorMsg","请求失败");
            return  null;
        }else{
            String json =JSON.toJSONString(addressIds);
            return json;
        }
    }
    @GetMapping("/business/buyrecord/getRecordsByFarmerName")
    @ResponseBody
    public String getRecordsByFarmerName(@RequestParam("userId")String businessId,@RequestParam("farmerName")String farmerName,HttpSession session) throws SQLException {
        List<BusinessBuyrecord> businessBuyrecords = businessBuyRecordService.getBusinessBuyRecordByFarmerName(businessId,farmerName);
        if(businessBuyrecords==null){
            session.setAttribute("errorMsg","无对应记录");
            return  null;
        }else{
            String json = JSON.toJSONString(businessBuyrecords);
            return json;
        }


    }

    /**
     * 通过农户id查找农户
     */
    @GetMapping("/business/buyRecord/getFarmerById")
    public String getFarmerById(@RequestParam("farmerId") String farmerId,
                                HttpSession session) throws SQLException{
        List<BusinessBuyrecord> businessBuyrecords = businessBuyRecordService.findFarmerById(farmerId);
        if(businessBuyrecords==null){
            session.setAttribute("errorMsg","无对应记录");
            return  null;
        }else{
            String json = JSON.toJSONString(businessBuyrecords);
            return json;
        }
    }
}
