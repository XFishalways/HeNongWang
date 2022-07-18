package com.bug.henong.controller;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BuyerAddress;
import com.bug.henong.service.BuyerAddressService;
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
public class BuyerAddressController {
    private BuyerAddressService buyerAddressService = new BuyerAddressService();


    /**
     * 查询卖家所有地址
     */
    @GetMapping("/buyer/address/findAllAddress")
    @ResponseBody
    public String findAllAddress(@RequestParam("buyerUserId") String buyerUserId,
            HttpSession session) throws SQLException {

        String json;

        List<BuyerAddress> buyerAddresses = buyerAddressService.getBuyerAddressDetailById(buyerUserId);

        if(buyerAddresses == null){
            session.setAttribute("errorMsg", "查找不到买家地址id");
            BuyerAddress buyerAddress = new BuyerAddress();
            return JSONUtil.toJsonStr(buyerAddress);
        }

        json = JSON.toJSONString(buyerAddresses);
        return json;
    }

    /**
     * 查询一个卖家地址
     */
    @GetMapping("/buyer/address/findOneAddress")
    @ResponseBody
    public String findOneAddress(@RequestParam("addressTitle") String addressTitle,
                                 HttpSession session) throws SQLException{
        String json;
        BuyerAddress buyerAddress = buyerAddressService.findOneBuyerAddressByTitle(addressTitle);

        if(buyerAddress == null){
            session.setAttribute("errorMsg", "查找不到买家地址id");
            buyerAddress = new BuyerAddress();
            return JSONUtil.toJsonStr(buyerAddress);
        }

        json = JSON.toJSONString(buyerAddress);
        return json;

    }

    /**
     * 更新卖家地址
     */
    @PostMapping("/buyer/address/update")
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
    public String deleteOneAddress(@RequestParam("addressId") String addressId,
                                 HttpSession session) throws SQLException{

        BuyerAddress buyerAddress = buyerAddressService.findOneBuyerAddress(addressId);

        buyerAddressService.deleteAddress(addressId);
        MapFactory mapFactory=new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }



}
