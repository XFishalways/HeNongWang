package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.SaleStore;
import com.bug.henong.service.BusinessAddressService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class BusinessAddressController {
    private BusinessAddressService businessAddressService = new BusinessAddressService();

    /**
     * 查询卖家地址
     */
    @GetMapping("/business/address/findAddressInfo")
    public String findAddressInfo(HttpSession session) throws SQLException{
        Object businessAddressId = session.getAttribute("businessAddressId");
        String id = (String) businessAddressId;
        BusinessAddress businessAddress = businessAddressService.getBusinessAddressDetailById(id);

        if(businessAddress == null){
            session.setAttribute("errorMsg", "查找不到卖家地址id");
            return null;
        }

        String json = JSON.toJSONString(businessAddress);
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
                         HttpSession session) throws SQLException{

        int result = businessAddressService.update(addressId, addressName, province, city,
               county, street, lastDetail, isDefault);
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
                           HttpSession session) throws SQLException{

        businessAddressService.Insert(addressName, province,city, county, street, lastDetail, isDefault);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    /**
     * 删除卖家地址
     */
    @GetMapping("/business/address/delete")
    public void deleteOneAddress(@RequestParam("addressId") String addressId) throws SQLException{

        BusinessAddress businessAddress = businessAddressService.getBusinessAddressDetailById(addressId);

        businessAddressService.deleteAddress(addressId);

    }


}
