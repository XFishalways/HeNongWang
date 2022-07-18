package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessOrder;
import com.bug.henong.service.BusinessItemService;
import com.bug.henong.service.BusinessOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BusinessOrderController {
    BusinessOrderService businessOrderService =new BusinessOrderService();

    @RequestMapping("/business/businessOrder/getOrders")
    @ResponseBody
    public String getOrders(@RequestParam("userId")String userId, HttpSession session) throws SQLException {
        List<BusinessOrder> businessOrders = businessOrderService.getOrdersByBusinessId(userId);

        if(businessOrders==null){
            session.setAttribute("errorMsg","数据为空");
            return JSON.toJSONString(businessOrders);
        }else{
            return JSON.toJSONString(businessOrders);
        }
    }

    @RequestMapping("/business/businessOrder/getOrdersByOrderId")
    @ResponseBody
    public String getOrdersByOrderId(@RequestParam("userId")String userId,@RequestParam("orderId")String orderId,HttpSession session) throws SQLException {
        List<BusinessOrder>businessOrders = businessOrderService.getOrdersByBusinessIdAndOrderId(userId,orderId);
        if(businessOrders==null){
            session.setAttribute("errorMsg","数据为空");
            return JSON.toJSONString(businessOrders);
        }else{
            return JSON.toJSONString(businessOrders);
        }
    }
}
