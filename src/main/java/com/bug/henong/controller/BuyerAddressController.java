package com.bug.henong.controller;


import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BuyerAddress;
import com.bug.henong.service.BuyerAddressService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class BuyerAddressController {
    private BuyerAddressService buyerAddressService = new BuyerAddressService();


    /**
     * 查询卖家地址
     */
    @GetMapping("/buyer/address/findAddressInfo")
    public String findAddressInfo(HttpSession session) throws SQLException {
        Object buyerAddressId = session.getAttribute("buyerAddressId");
        String id = (String) buyerAddressId;
        BuyerAddress buyerAddress = buyerAddressService.getBuyerAddressDetailById(id);

        if(buyerAddress == null){
            session.setAttribute("errorMsg", "查找不到买家地址id");
            return null;
        }

        String json = JSON.toJSONString(buyerAddress);
        return json;
    }

    /**
     * 更新卖家地址
     */
    @PostMapping("/buyer/address/update")
    public String update(@RequestParam("addressId") String addressId,
                         @RequestParam("addressName") String addressName,
                         @RequestParam("receiverName") String receiverName,
                         @RequestParam("receiverPhone") String receiverPhone,
                         @RequestParam("province") String province,
                         @RequestParam("city") String city,
                         @RequestParam("county") String county,
                         @RequestParam("street") String street,
                         @RequestParam("lastDetail") String lastDetail,
                         @RequestParam("isDefault") String isDefault,
                         @RequestParam("userId") String userId,
                         HttpSession session) throws SQLException{

        int result = buyerAddressService.update(addressId, addressName, receiverName, receiverPhone, province, city,
                county, street, lastDetail, isDefault, userId);
        if (result==0) {
            session.setAttribute("errorMsg", "查找不到地址id");
            return null;
        }

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }

    /**
     * 注册买家地址
     */
    @PostMapping("/buyer/address/register")
    public String register(@RequestParam("addressName") String addressName,
                           @RequestParam("receiverName") String receiverName,
                           @RequestParam("receiverPhone") String receiverPhone,
                           @RequestParam("province") String province,
                           @RequestParam("city") String city,
                           @RequestParam("county") String county,
                           @RequestParam("street") String street,
                           @RequestParam("lastDetail") String lastDetail,
                           @RequestParam("isDefault") String isDefault,
                           @RequestParam("userId") String userId,
                           HttpSession session) throws SQLException{

        buyerAddressService.Insert(addressName, receiverName, receiverPhone,province,city, county, street, lastDetail, isDefault, userId);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
    /**
     * 删除卖家地址
     */
    @GetMapping("/buyer/address/delete")
    public void deleteOneAddress(@RequestParam("addressId") String addressId) throws SQLException{

        BuyerAddress buyerAddress = buyerAddressService.getBuyerAddressDetailById(addressId);

        buyerAddressService.deleteAddress(addressId);

    }



}
