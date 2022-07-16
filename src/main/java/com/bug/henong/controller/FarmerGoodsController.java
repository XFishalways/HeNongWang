package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Goods;
import com.bug.henong.service.GoodsService;
import com.bug.henong.utils.MapFactory;
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
    }

    @RequestMapping(value = "/farmer/farmerGoods/getAll", method = RequestMethod.GET)
    public void findAllGoods(HttpServletResponse response) throws IOException, SQLException {

        PrintWriter printWriter = response.getWriter();

        String json;

        List<Goods> goods = goodsService.getAllGoods();

        if (goods != null) {
            json = JSON.toJSONString(goods);
            System.out.println(json);
        } else {
            json = "{\"log\":\"Invalid id\"}";
        }

        printWriter.print(json);

    }

    @RequestMapping(value = "/farmer/farmerGoods/delete", method = RequestMethod.GET)
    public void deleteOneGoods(@RequestParam("goodsId") String goodsId) throws SQLException {

        Goods goods = goodsService.getGoodsId(goodsId);

        goodsService.deleteGoods(goodsId);

    }

    @RequestMapping(value = "/farmer/farmerGoods/update", method = RequestMethod.POST)
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
    public String registerGoods(@RequestParam("goodsName") String goodsName,
                                @RequestParam("goodsTime") String goodstime,
                                @RequestParam("goodsPlace") String goodsPlace,
                                HttpSession session) throws SQLException {

        Timestamp goodsTime = Timestamp.valueOf(goodstime);

        goodsService.Insert(goodsName, goodsTime, goodsPlace);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/farmer/farmerGoods/getFarmerGoods?page={page}&limit={limit}")
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
}
