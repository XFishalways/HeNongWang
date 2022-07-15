package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Goods;
import com.bug.henong.service.GoodsService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/farmer/FarmerGoods/findone", method = RequestMethod.GET)
    public void FindOneGoods (@RequestParam("goodsId") String goodsId,
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

    @RequestMapping(value = "/farmer/farmerGoods", method = RequestMethod.GET)
    public void FindAllGoods (HttpServletResponse response) throws IOException, SQLException {

        PrintWriter printWriter = response.getWriter();

        String json;

        List<Goods> goods = goodsService.getAllGoods();

        if(goods != null) {
            json = JSON.toJSONString(goods);
        }
        else {
            json = "{\"log\":\"Invalid id\"}";
        }

        printWriter.print(json);

    }

    @RequestMapping(value = "/farmer/farmerGoods/delete", method = RequestMethod.GET)
    public void DeleteOneGoods(@RequestParam("goodsId") String goodsId) throws SQLException {

        Goods goods = goodsService.getGoodsId(goodsId);

        goodsService.deleteGoods(goodsId);

    }

    @RequestMapping(value = "/farmer/farmerGoods", method = RequestMethod.POST)
    public Map<String, Object> updateOneGoods(@RequestParam("goodsId") String goodsId,
                               @RequestParam("goodsName") String goodsName,
                               @RequestParam("goodsQuantity") String goodsquatity,
                               @RequestParam("goodsPrice") String goodsprice,
                               @RequestParam("goodsSale") String goodsSale,
                               @RequestParam("goodsPass") String goodsPass,
                               @RequestParam("goodsDegree") String goodsDegree,
                               @RequestParam("goodsImage") String goodsImage,
                               HttpSession session) throws SQLException {

        Double goodsQuantity = Double.parseDouble(goodsquatity);
        Double goodsPrice = Double.parseDouble(goodsprice);

        Goods goods = goodsService.getGoodsId(goodsId);

        if (!goods.getGoodsName().equals(goodsName)) {
            goodsService.updateGoodsName(goodsId, goodsName);
        }
        if (!goods.getGoodsQuantity().equals(goodsQuantity)) {
            goodsService.updateQuantity(goodsId, goodsQuantity);
        }
        if (!goods.getGoodsPrice().equals(goodsPrice)) {
            goodsService.updatePrice(goodsId, goodsPrice);
        }
        if (!goods.getGoodsSale().equals(goodsSale)) {
            goodsService.updateSale(goodsId, goodsSale);
        }
        if (!goods.getGoodsDegree().equals(goodsDegree)) {
            goodsService.updateDegree(goodsId,goodsDegree);
        }
        if (!goods.getGoodsPass().equals(goodsPass)) {
            goodsService.updatePass(goodsId, goodsPass);
        }
        if (!goods.getGoodsImage().equals(goodsImage)) {
            goodsService.updateImage(goodsId, goodsImage);
        }
        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/farmer/farmerReport", method = RequestMethod.POST)
    public Map<String, Object> Register (@RequestParam("goodsId") String goodsId,
                                         @RequestParam("goodsName") String goodsName,
                                         @RequestParam("goodsTime") String goodstime,
                                         @RequestParam("goodsPlace") String goodsPlace,
                                         HttpSession session) throws SQLException {

        Timestamp goodsTime = Timestamp.valueOf(goodstime);

        Goods goods = new Goods();

        goodsService.Insert(goods);

        if (goodsId != null) {
            goods.setGoodsId(goodsId);
        }
        if (goodsName != null) {
            goods.setGoodsName(goodsName);
        }
        if (goodsTime != null) {
            goods.setGoodsTime(goodsTime);
        }
        if (goodsPlace != null) {
            goods.setGoodsPlace(goodsPlace);
        }

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
}

