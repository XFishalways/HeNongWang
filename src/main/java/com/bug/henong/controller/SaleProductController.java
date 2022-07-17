package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.service.SaleProductService;
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

@Controller

public class SaleProductController {

    private SaleProductService saleProductService = new SaleProductService();

    @RequestMapping(value = "/admin/saleProduct/{saleProductId}", method = RequestMethod.GET)

    public void findOneGoods (@RequestParam("saleProductId") String saleProductId,
                                            HttpServletResponse response ) throws SQLException, IOException{

        PrintWriter printWriter = response.getWriter();
        String json;

        SaleProduct saleProduct = saleProductService.getSaleProductId(saleProductId);
        if (saleProductId != null) {
            json = JSON.toJSONString(saleProduct);
            json = "[" + json + "]";
        }else {
            json = "{\"log\":\"Please input saleProduct id!\"}";
        }

        printWriter.print(json);
        printWriter.flush();
        printWriter.close();
    }

    @RequestMapping(value = "/admin/saleProduct", method = RequestMethod.GET)
    public void findAllProducts (HttpServletResponse response)  throws IOException, SQLException{

        PrintWriter printWriter = response.getWriter();

        String json;

        List<SaleProduct> saleProducts = saleProductService.getAllProducts();
        if (saleProducts != null) {
            json = JSON.toJSONString(saleProducts);
            System.out.println(json);
        }
        else {
            json = "{\"log\":\"Invalid id\"}";
        }

        printWriter.print(json);
        printWriter.flush();
        printWriter.close();

    }

    @RequestMapping(value = "/admin/saleProduct/delete", method = RequestMethod.GET)
    public void deleteOneProduct(@RequestParam("saleProductId") String saleProductId) throws SQLException {

        SaleProduct saleProduct = saleProductService.getSaleProductId(saleProductId);

        saleProductService.deleteSaleProduct(saleProductId);

    }

    @RequestMapping(value = "/admin/saleProduct", method = RequestMethod.POST)
    public String updateOneProduct(@RequestParam("saleProductId") String saleProductId,
                                   @RequestParam("saleProductTitle") String saleProductTitle,
                                   @RequestParam("saleProductIntro") String saleProductIntro,
                                   @RequestParam("saleProductContent") String saleProductContent,
                                   @RequestParam("saleProductStartTime") String saleProductstartTime,
                                   @RequestParam("saleProductEndTime") String saleProductendTime,
                                   @RequestParam("saleProductRange") String saleProductRange,
                                   @RequestParam("saleProductType") String saleProductType,
                                   @RequestParam("saleProductStatus") String saleProductStatus,
                                   HttpSession session) throws  SQLException  {

        Timestamp saleProductStartTime = Timestamp.valueOf(saleProductstartTime);
        Timestamp saleProductEndTime = Timestamp.valueOf(saleProductendTime);

        saleProductService.updateInfo(saleProductId, saleProductTitle, saleProductIntro, saleProductContent, saleProductStartTime, saleProductEndTime, saleProductRange, saleProductType, saleProductStatus);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/admin/saleProductReport", method = RequestMethod.POST)
    public String registerProduct (@RequestParam("saleProductTitle") String saleProductTitle,
                                   @RequestParam("saleProductIntro") String saleProductIntro,
                                   @RequestParam("saleProductContent") String saleProductContent,
                                   @RequestParam("saleProductStartTime") String saleProductstartTime,
                                   @RequestParam("saleProductEndTime") String saleProductendTime,
                                   @RequestParam("saleProductRange") String saleProductRange,
                                   @RequestParam("saleProductType") String saleProductType,
                                   @RequestParam("saleProductStatus") String saleProductStatus,
                                   HttpSession session) throws  SQLException  {

        Timestamp saleProductStartTime = Timestamp.valueOf(saleProductstartTime);
        Timestamp saleProductEndTime = Timestamp.valueOf(saleProductendTime);

        saleProductService.Insert(saleProductTitle, saleProductIntro, saleProductContent,saleProductStartTime, saleProductEndTime, saleProductRange, saleProductType, saleProductStatus);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }
}
