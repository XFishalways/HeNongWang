package com.bug.henong.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.Goods;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;
import com.bug.henong.service.SaleStoreService;
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

@Controller
public class AdminSaleStoreController {

    private SaleStoreService saleStoreService = new SaleStoreService();

    /**
     * 查询所有商店活动
     */
    @RequestMapping(value = "/admin/saleStore/findAll", method = RequestMethod.GET)

    public String findAllSales (@RequestParam("saleId") String saleId,
                                HttpSession session ) throws SQLException{

        String json;

        List<SaleStore> saleStores = saleStoreService.getAllSalesById(saleId);
        if (saleId == null) {

            session.setAttribute("errorMsg", "查找不到商店活动id");
            return JSONUtil.toJsonStr(saleStores);
        }

        json = JSON.toJSONString(saleStores);
        return json;
    }

    /**
     * 查询一个商店活动
     */
    @GetMapping("/admin/saleStore/findOne")
    public String findOneSales(HttpSession session)throws SQLException {
        Object saleStoreId = session.getAttribute("saleStoreId");
        String id = (String) saleStoreId;
        SaleStore saleStore = saleStoreService.getSaleStoreId(id);

        if(saleStore == null){
            session.setAttribute("errorMsg", "查找不到商店活动id");
            return null;
        }

        String json = JSON.toJSONString(saleStore);
        return json;
    }

    /**
     * 删除商店活动
     */
    @GetMapping("/admin/saleStore/delete")
    public void deleteOneSale(@RequestParam("saleStoreId") String saleStoreId) throws SQLException{

        SaleStore saleStore = saleStoreService.getSaleStoreId(saleStoreId);

        saleStoreService.deleteSale(saleStoreId);
    }

    /**
     * 注册商店商品
     */
    @PostMapping("/admin/saleStore/register")
    public String registerSaleStore (@RequestParam("saleStoreTitle") String saleStoreTitle,
                                     @RequestParam("saleStoreIntro") String saleStoreIntro,
                                     @RequestParam("saleStoreContent") String saleStoreContent,
                                     @RequestParam("salestorestarttime") String salestorestarttime,
                                     @RequestParam("salestoreendtime") String salestoreendtime,
                                     @RequestParam("saleStoreRange") String saleStoreRange,
                                     @RequestParam("saleStoreType") String saleStoreType,
                                     @RequestParam("saleStoreStatus") String saleStoreStatus,
                                 HttpSession session) throws SQLException {

        Timestamp saleStoreStartTime = Timestamp.valueOf(salestorestarttime);
        Timestamp saleStoreEndTime = Timestamp.valueOf(salestoreendtime);

        saleStoreService.Insert(saleStoreTitle, saleStoreIntro, saleStoreContent, saleStoreStartTime,
                saleStoreEndTime, saleStoreRange, saleStoreType, saleStoreStatus);

         MapFactory mapFactory = new MapFactory();
         return mapFactory.getStringObjectMap(session);
    }


    /**
     * 更新商店活动信息
     */
    @PostMapping("/admin/saleStore/update")
    public String updateOneSaleStore(@RequestParam("saleStoreId") String saleStoreId,
                                     @RequestParam("saleStoreTitle") String saleStoreTitle,
                                     @RequestParam("saleStoreIntro") String saleStoreIntro,
                                     @RequestParam("saleStoreContent") String saleStoreContent,
                                     @RequestParam("saleStoreStartTime") String salestorestarttime,
                                     @RequestParam("salestoreendtime") String salestoreendtime,
                                     @RequestParam("saleStoreRange") String saleStoreRange,
                                     @RequestParam("saleStoreType") String saleStoreType,
                                     @RequestParam("saleStoreStatus") String saleStoreStatus,
                                     HttpSession session) throws SQLException{

        Timestamp saleStoreStartTime = Timestamp.valueOf(salestorestarttime);
        Timestamp saleStoreEndTime = Timestamp.valueOf(salestoreendtime);


        saleStoreService.update(saleStoreId, saleStoreTitle, saleStoreIntro, saleStoreContent,
                                saleStoreStartTime, saleStoreEndTime,  saleStoreRange,  saleStoreType,
                                saleStoreStatus);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }

}

