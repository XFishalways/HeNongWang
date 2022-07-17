package com.bug.henong.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.service.BusinessAddressService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BusinessAddressController {
    private BusinessAddressService businessAddressService = new BusinessAddressService();

    /**
     * 查询所有卖家地址
     */
    @GetMapping("/business/address/findAddressInfo")
    public String findAddressInfo(@RequestParam("userId") String userId,
                                  HttpSession session) throws SQLException{

        String json;
        List<BusinessAddress> businessAddresses = businessAddressService.getBusinessAddressDetailById(userId);

        if(businessAddresses == null){
            session.setAttribute("errorMsg", "查找不到卖家地址id");
            return JSONUtil.toJsonStr(businessAddresses);
        }

        json= JSON.toJSONString(businessAddresses);
        return json;
    }

    /**
     * 查找一个卖家地址
     */
    @GetMapping("/business/address/findOneAddress")
    public String findOneAddress(@RequestParam("businessAddressId") String businessAddressId,
                                 HttpSession session) throws SQLException{

        String json;
        BusinessAddress businessAddress = businessAddressService.findOneAddress(businessAddressId);

        if(businessAddress == null){
            session.setAttribute("errorMsg", "查找不到卖家地址id");
            return JSONUtil.toJsonStr(businessAddress);
        }

        json = JSON.toJSONString(businessAddress);
        return json;

    }



    /**
     * 更新卖家地址
     */
    @PostMapping("/business/address/update")
    public String update(@RequestParam("addressId") String addressId,
                         @RequestParam("addressName") String addressName,
                         @RequestParam("province") String province,
                         @RequestParam("city") String city,
                         @RequestParam("county") String county,
                         @RequestParam("street") String street,
                         @RequestParam("lastDetail") String lastDetail,
                         @RequestParam("isDefault") String isDefault,
                         @RequestParam("userId") String userId,
                         HttpSession session) throws SQLException{

        int result = businessAddressService.update(addressId, addressName, province, city,
               county, street, lastDetail, isDefault, userId);
        if (result==0) {
            session.setAttribute("errorMsg", "查找不到地址id");
            return null;
        }

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }


    /**
     * 注册卖家地址
     */
    @PostMapping("/business/address/register")
    public String register(@RequestParam("addressName") String addressName,
                           @RequestParam("province") String province,
                           @RequestParam("city") String city,
                           @RequestParam("county") String county,
                           @RequestParam("street") String street,
                           @RequestParam("lastDetail") String lastDetail,
                           @RequestParam("isDefault") String isDefault,
                           @RequestParam("userId") String userId,
                           HttpSession session) throws SQLException{

        businessAddressService.Insert(addressName, province,city, county, street, lastDetail, isDefault, userId);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    /**
     * 删除卖家地址
     */
    @GetMapping("/business/address/delete")
    public void deleteOneAddress(@RequestParam("addressId") String addressId) throws SQLException{

        BusinessAddress businessAddress = (BusinessAddress) businessAddressService.getBusinessAddressDetailById(addressId);

        businessAddressService.deleteAddress(addressId);

    }


}