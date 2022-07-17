package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Goods;
import com.bug.henong.service.GoodsService;
import com.bug.henong.utils.MapFactory;
import io.swagger.annotations.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author XFishalways
 * @version 1.0.0
 * @date 22.07.15
 */

@Controller

public class FarmerGoodsController {

    private GoodsService goodsService = new GoodsService();

    @RequestMapping(value = "/farmer/farmerGoods/findOne", method = RequestMethod.GET)
    @ResponseBody
    public void findOneGoods(@RequestParam("goodsId") String goodsId,
                             HttpServletResponse response) throws SQLException, IOException {

        PrintWriter printWriter = response.getWriter();

        String json;

        Goods goods = goodsService.getGoodsId(goodsId);
        if (goodsId != null) {
            json = JSON.toJSONString(goods);
            json = "[" + json + "]";
        } else {
            json = "{\"log\":\"Please input goods id!\"}";
        }

        printWriter.print(json);
        printWriter.flush();
        printWriter.close();
    }

    @RequestMapping(value = "/farmer/farmerGoods/getFarmerGoods", method = RequestMethod.GET)
    @ResponseBody
    public String findAllGoods(@RequestParam String farmerId,HttpSession session) throws IOException, SQLException {



        String json;

        List<Goods> goods = goodsService.getFarmerGoods(farmerId);

        if (goods == null) {
           session.setAttribute("errorMsg","查找失败");
            return JSON.toJSONString(goods);
        } else {
           json=JSON.toJSONString(goods);
           return json;
        }



    }

    @RequestMapping(value = "/farmer/farmerGoods/delete/{goodsId}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteOneGoods(@RequestParam("goodsId") String goodsId) throws SQLException {

        Goods goods = goodsService.getGoodsId(goodsId);

        goodsService.deleteGoods(goodsId);

    }

    @RequestMapping(value = "/farmer/farmerGoods/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateOneGoods(@RequestParam("goodsId") String goodsId,
                                 @RequestParam("goodsName") String goodsName,
                                 @RequestParam("goodsQuantity") String goodsquantity,
                                 @RequestParam("goodsPrice") String goodsprice,
                                 @RequestParam("goodsSale") String goodsSale,
                                 @RequestParam("goodsPass") String goodsPass,
                                 @RequestParam("goodsDegree") String goodsDegree,
                                 @RequestParam("goodsImage") String goodsImage,
                                 HttpSession session) throws SQLException {

        Double goodsQuantity = Double.parseDouble(goodsquantity);
        Double goodsPrice = Double.parseDouble(goodsprice);

        Goods goods = goodsService.getGoodsId(goodsId);

        goodsService.updateInfo(goods, goodsName, goodsQuantity, goodsPrice, goodsSale, goodsPass, goodsDegree, goodsImage);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/farmer/farmerGoods/farmerGoodsReport", method = RequestMethod.POST)
    @ResponseBody
    public String registerGoods(@RequestParam("goodsName") String goodsName,
                                @RequestParam("goodsPrice") String goodsprice,
                                @RequestParam("goodsTime") String goodstime,
                                @RequestParam("goodsPlace") String goodsPlace,
                                @RequestParam("goodsQuantity") String goodsquantity,
                                @RequestParam("farmerId") String farmerId,
                                HttpSession session) throws SQLException {

        Double goodsPrice = Double.parseDouble(goodsprice);
        Double goodsQuantity = Double.parseDouble(goodsquantity);
        Timestamp goodsTime = Timestamp.valueOf(goodstime);
        System.out.println(goodsTime);
        int result =goodsService.insert(goodsName, goodsPrice, goodsTime, goodsPlace, goodsQuantity, farmerId);
        if(result==0){
            return null;
        }
        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/farmer/farmerGoods/getFarmerGoods?page={page}&limit={limit}")
    @ResponseBody
    public String getGoodsFromTo(@PathVariable String page, @PathVariable String limit, HttpSession session) throws SQLException {
        int currentPage = Integer.getInteger(page);
        int pageSize = Integer.getInteger(limit);
        List<Goods> goods = goodsService.getGoodsFromTo(currentPage, pageSize);
        if (goods != null) {
            String json = JSON.toJSONString(goods);
            session.getAttribute("");
            return json;
        }
        return null;
    }
    @RequestMapping(value ="farmer/farmerGoods/getFarmerGoodsByName")
    @ResponseBody
    public String getFarmerGoodsByName(@RequestParam String farmerId,@RequestParam String goodsName, HttpSession session) throws SQLException {
        List<Goods> goods = goodsService.getFarmerGoodsByName(farmerId, goodsName);
        if (goods != null) {
            String json = JSON.toJSONString(goods);
            session.getAttribute("");
            return json;
        }
        return null;
    }
}
