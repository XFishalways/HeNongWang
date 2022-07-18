package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessItem;
import com.bug.henong.service.BusinessItemService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BusinessItemController {
    BusinessItemService businessItemService =new BusinessItemService();

    @GetMapping("/business/businessItem/getBusinessItemsByName")
    @ResponseBody
    public String getItemsFromTo(@RequestParam("skuName")String skuName ,@RequestParam("page")String page, HttpSession session) throws SQLException {
        int currentPage =Integer.getInteger(page);
        //前端规定为一页10个
        int size = 10;
        List<BusinessItem> businessItems = businessItemService.getBusinessItemsByName(skuName,currentPage,size);
        if(businessItems==null){
            session.setAttribute("errorMsg","未找到");
            return JSON.toJSONString(businessItems);
        }else{
            return JSON.toJSONString(businessItems);
        }
    }
    @GetMapping("/business/businessItem/getBusinessItems")
    @ResponseBody
    public String getBusinessItems(@RequestParam("businessId")String businessId, HttpSession session) throws SQLException {
        List<BusinessItem> businessItems = businessItemService.getBusinessItemsByBusinessId(businessId);
        if(businessItems==null){
            session.setAttribute("errorMsg","未找到");
            return JSON.toJSONString(businessItems);
        }else{
            return JSON.toJSONString(businessItems);
        }
    }

    @GetMapping("/business/businessItem/getBusinessItemByName")
    @ResponseBody
    public String getBusinessItemsByName(@RequestParam("businessId")String businessId,@RequestParam("itemName")String itemName,HttpSession session) throws SQLException {
        List<BusinessItem> businessItems= businessItemService.getBusinessItemsByNameAndBusinessId(businessId,itemName);
        if(businessItems==null){
            session.setAttribute("errprMsg","未找到");
            return JSON.toJSONString(businessItems);
        }else{
            return JSON.toJSONString(businessItems);
        }
    }

    @GetMapping("/business/businessItem/getBusinessOnsaleItems")
    @ResponseBody
    public String getBusinessOnsaleItems(@RequestParam("businessId")String businessId,HttpSession session) throws SQLException {
        List<BusinessItem> businessItems = businessItemService.getBusinessItemsOnsale(businessId);
        if(businessItems==null){
            session.setAttribute("errprMsg","未找到");
            return JSON.toJSONString(businessItems);
        }else{
            return JSON.toJSONString(businessItems);
        }
    }
    @GetMapping("/business/businessItem/getBusinessOffsaleItems")
    @ResponseBody
    public String getBusinessOffsaleItems(@RequestParam("businessId")String businessId,HttpSession session) throws SQLException {
        List<BusinessItem> businessItems = businessItemService.getBusinessItemsOffsale(businessId);
        if(businessItems==null){
            session.setAttribute("errprMsg","未找到");
            return JSON.toJSONString(businessItems);
        }else{
            return JSON.toJSONString(businessItems);
        }
    }
    @GetMapping("/business/businessItem/putItemOnsale")
    @ResponseBody
    public String putItemOnSale(@RequestParam("skuId")String skuId,HttpSession session) throws SQLException {
        Boolean rs = businessItemService.putItemOnSale(skuId);
        if(rs==false){
            return null;
        }else {
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
    @GetMapping("/business/businessItem/putItemOffsale")
    @ResponseBody
    public String putItemOffSale(@RequestParam("skuId")String skuId,HttpSession session) throws SQLException {
        Boolean rs = businessItemService.putItemOffSale(skuId);
        if(rs==false){
            return null;
        }else {
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
    @GetMapping("/goods/randomView")
    @ResponseBody
    public String randomView(HttpSession session) throws SQLException {
        List<BusinessItem> businessItems = businessItemService.getBusinessItemsRandom();
        if(businessItems==null){
            BusinessItem businessItem = new BusinessItem();
            return JSON.toJSONString(businessItem);
        }else{
            return JSON.toJSONString(businessItems);
        }
    }

}
