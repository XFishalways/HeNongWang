package com.bug.henong.controller;

import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.Goods;
import com.bug.henong.service.GoodsService;
import com.bug.henong.utils.MapFactory;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;
import com.bug.henong.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author XFishalways
 * @version 1.0.0
 * @date 22.07.15
 */

@Controller
public class FarmerGoodsController {

    private GoodsService goodsService = new GoodsService();

    @RequestMapping(value = "/farmer/findgoods", method = RequestMethod.GET)
    public void FindGoods (@RequestParam("goodsId") String goodsId,
                                          HttpServletResponse response) throws SQLException, IOException {

        PrintWriter printWriter = response.getWriter();
        GoodsService goodsService = new GoodsService();
        String json = null;

        Goods goods = goodsService.getGoodsId(goodsId);
        if (goodsId != null) {
            json = JSON.toJSONString(goods);
            json = "[" + json + "]";
        } else {
            json = "{\"log\":\"Please input goods id!\"}";
        }

        printWriter.print(json);

    }

    @RequestMapping(value = "/farmer", method = RequestMethod.GET)
    public void FindAllGoods (@RequestParam(),HttpResponse response) {

    }

}
