package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BuyerCart;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.service.BuyerCartService;
import com.bug.henong.service.BuyerOrderService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BuyerCartController {
    private BuyerCartService buyerCartService = new BuyerCartService();

    @RequestMapping("/buyer/buyerCart/getBuyerCart")
    @ResponseBody
    public String getBuyerCart(@RequestParam("userId")String userId, HttpSession session) throws SQLException {
        List<BuyerItem> buyerItems = buyerCartService.getItemsInCart(userId);
        if(buyerItems==null){
            session.setAttribute("errorMsg","数据为空");
            BuyerItem buyerItem = new BuyerItem();
            return JSON.toJSONString(buyerItem);
        }else {
            BuyerItem buyerItem = new BuyerItem();
            return JSON.toJSONString(buyerItem);
        }
    }

    @RequestMapping("/buyer/buyerCart/cleanCart")
    @ResponseBody
    public String cleanCart(@RequestParam("userId")String userId,HttpSession session) throws SQLException {
        Boolean rs= buyerCartService.cleanCart(userId);
        if(rs==null){
            session.setAttribute("errorMsg","请求失败");
            return null;
        }else {
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
    @RequestMapping("/buyer/buyerCart/deleteItems")
    @ResponseBody
    public String deleteItemsInCart(@RequestParam("skuIds")String skuIds,@RequestParam("userId")String userId,HttpSession session) throws SQLException {
        List<String>itemsId =JSON.parseArray(skuIds,String.class);

        for(String id:itemsId){
            Boolean rs = buyerCartService.delete(id,userId);
            if(rs==false){
                session.setAttribute("errorMsg","请求失败");
                return null;
            }
        }
        MapFactory mapFactory=new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
    @RequestMapping("/buyer/buyerCart/confirmItems")
    @ResponseBody
    public String confirmItemsInCart(@RequestParam("skuIds")String skuIds,@RequestParam("userId")String userId,HttpSession session) throws SQLException {
        List<String>itemsId =JSON.parseArray(skuIds,String.class);
        Boolean rs= buyerCartService.confirm(itemsId,userId);
        if(rs==false){
            session.setAttribute("errorMsg","请求失败");
            return null;
        }
        MapFactory mapFactory=new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
}
