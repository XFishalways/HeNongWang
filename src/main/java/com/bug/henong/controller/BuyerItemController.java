package com.bug.henong.controller;

import cn.hutool.core.text.finder.StrFinder;
import cn.hutool.json.JSONUtil;
import com.alibaba.druid.sql.ast.SQLAdhocTableSource;
import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.service.BuyerItemService;
import com.bug.henong.utils.MapFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BuyerItemController {

    private BuyerItemService buyerItemService = new BuyerItemService();

    @RequestMapping(value = "/goods/goodsInformation/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public String addToCart(@RequestParam("userId") String userId,
                            @RequestParam("skuId") String skuId,
                            @RequestParam("quantity") String Quantity,
                            @RequestParam("price") String Price,
                            HttpSession session) throws SQLException {

        Double quantity = Double.parseDouble(Quantity);
        Double price = Double.parseDouble(Price);

        Boolean result = buyerItemService.cartInsert(userId, skuId, quantity, price);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/goods/goodsInformation/addToOrder", method = RequestMethod.POST)
    @ResponseBody
    public String addToOrder(@RequestParam("userId") String userId,
                             @RequestParam("skuId") String skuId,
                             @RequestParam("quantity") String Quantity,
                             @RequestParam("price") String Price,
                             HttpSession session) throws SQLException {

        Double quantity = Double.parseDouble(Quantity);
        Double price = Double.parseDouble(Price);

        Boolean result = buyerItemService.orderInsert(userId, skuId, quantity, price);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/business/displayGoods", method = RequestMethod.GET)
    @ResponseBody
    public String insertItem (@RequestParam("skuId") String skuId,
                              HttpSession session) throws SQLException {

        Boolean result = buyerItemService.itemInsert(skuId);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/goods/goodsView", method = RequestMethod.GET)
    @ResponseBody
    public String findAllItem(@RequestParam("itemId") String itemId,
                              HttpSession session) throws SQLException {

        String json;

        List<BuyerItem> buyerItems = buyerItemService.getBuyerItemDetailById(itemId);

        if(buyerItems == null) {
            session.setAttribute("errorMsg", "查找不到商品id");
            BuyerItem buyerItem = new BuyerItem();
            return JSONUtil.toJsonStr(buyerItem);
        }
        BuyerItem buyerItem = new BuyerItem();
        json = JSONUtil.toJsonStr(buyerItem);
        return json;
    }

}
