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
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
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
    @ResponseBody
    public String findOneAddress(@RequestParam("addressTitle") String addressTitle,
                                 HttpSession session) throws SQLException{

        String json;
        BusinessAddress businessAddress = businessAddressService.findOneAddressDetailByTitle(addressTitle);

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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
    public String deleteOneAddress(@RequestParam("addressId") String addressId,
                                 HttpSession session) throws SQLException{

        BusinessAddress businessAddress = businessAddressService.findOneAddress(addressId);

        businessAddressService.deleteAddress(addressId);
        MapFactory mapFactory=new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }
}
