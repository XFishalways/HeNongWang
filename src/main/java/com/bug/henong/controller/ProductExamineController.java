package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.ProductExamine;
import com.bug.henong.service.ProductExamineService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tan
 */
@Controller
public class ProductExamineController {
    ProductExamineService productExamineService = new ProductExamineService();
    @RequestMapping("/admin/productExamine/getAll")
    @ResponseBody
    public String getAllProductExamines(HttpSession session) throws SQLException {
        List<ProductExamine> productExamines = productExamineService.getAll();
        if(productExamines==null){
            session.setAttribute("errorMsg","请求失败");
            return null;
        }else{
            ProductExamine productExamine = new ProductExamine();
            String json = JSON.toJSONString(productExamine);
            return json;
        }
    }

    @RequestMapping("/admin/productExamine/getProductExaminesByProductName")
    @ResponseBody
    public String getProductExaminesByProductName(@RequestParam("productName")String productName,HttpSession session) throws SQLException {
        List<ProductExamine> productExamines = productExamineService.getProductExaminesByProductName(productName);
        if(productExamines==null){
            session.setAttribute("errorMsg","没有该商品");
            return null;
        }else{
            ProductExamine productExamine = new ProductExamine();
            String json = JSON.toJSONString(productExamine);
            return json;
        }
    }
    @PostMapping("/admin/prodectExamine/confirmProduct")
    @ResponseBody
    public String confirmProduct(@RequestParam("productId")String productId,@RequestParam("adminId")String adminId,HttpSession session) throws SQLException {
        Boolean rs = productExamineService.confirmProduct(productId,adminId);
        if(rs==false){
            session.setAttribute("errorMsg","确认失败");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }

    @PostMapping("/admin/prodectExamine/denyProduct")
    @ResponseBody
    public String denyProduct(@RequestParam("productId")String productId,@RequestParam("adminId")String adminId,HttpSession session) throws SQLException {
        Boolean rs = productExamineService.denyProduct(productId,adminId);
        if(rs==false){
            session.setAttribute("errorMsg","确认失败");
            return null;
        }else{
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
}
