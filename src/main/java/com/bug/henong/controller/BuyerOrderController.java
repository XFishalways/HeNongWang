package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BuyerOrder;
import com.bug.henong.service.BuyerOrderService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class BuyerOrderController {
    BuyerOrderService buyerOrderService = new BuyerOrderService();

    @RequestMapping("/buyer/buyerOrder/getOrders")
    @ResponseBody
    public String getOrders(@RequestParam("userId")String userId, HttpSession session) throws SQLException {
        List<BuyerOrder> buyerOrders = buyerOrderService.getBuyerOrderByBuyerId(userId);
          if(buyerOrders==null){
            session.setAttribute("errorMsg","数据为空");
            return JSON.toJSONString(buyerOrders);
        }else {
            return JSON.toJSONString(buyerOrders);
        }
    }
    @RequestMapping("/buyer/buyerOrder/getOrder")
    @ResponseBody
    public String getOrder(@RequestParam("orderId")String orderId,HttpSession session) throws SQLException {
        BuyerOrder order = buyerOrderService.getBuyerOrderById(orderId);
        if(order==null){
            session.setAttribute("errorMsg","请求失败");
            return JSON.toJSONString(order);
        }else{
            return JSON.toJSONString(order);
        }
    }
    @RequestMapping("/buyer/buyerOrder/getAddressById")
    @ResponseBody
    public String getAddressById(@RequestParam("userId")String userId,HttpSession session) throws SQLException {
        Map<String ,String> map = buyerOrderService.getAddress(userId);
        if(map==null){
            session.setAttribute("errorMsg","数据为空");
            return null;
        }else{
            return JSON.toJSONString(map);
        }
    }

    @RequestMapping("/buyer/buyerOrder/confirmOrder")
    @ResponseBody
    public String confirmOrder(@RequestParam("orderId")String orderId,@RequestParam("addressId")String addressId,
                               @RequestParam("payMethod")String payMethod, HttpSession session) throws SQLException {
        if(addressId==null||payMethod==null){
            session.setAttribute("errorMsg","地址为空");
            return null;
        }else{
            Boolean rs =buyerOrderService.confirmOrder(orderId, addressId, payMethod);
            if(rs==null){
                session.setAttribute("errorMsg","请求失败");
                return null;
            }else {
                MapFactory mapFactory = new MapFactory();
                return mapFactory.getStringObjectMap(session);
            }
        }
    }
    @RequestMapping("/buyer/buyerOrder/denyOrder")
    @ResponseBody
    public String denyOrder(@RequestParam("userId")String orderId,HttpSession session) throws SQLException {
        Boolean rs = buyerOrderService.denyOrder(orderId);
        if(rs==null){
            session.setAttribute("errorMsg","请求失败");
            return null;
        }else {
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
}
