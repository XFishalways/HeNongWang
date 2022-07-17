package com.bug.henong.controller;

import com.alibaba.fastjson.JSON;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.service.AdminSaleProductService;
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

public class AdminSaleProductController {

    private AdminSaleProductService saleProductService = new AdminSaleProductService();

    @RequestMapping(value = "/admin/saleProduct/findOne", method = RequestMethod.GET)

    public String findOneGoods (@RequestParam("saleProductTitle") String saleProductTitle,
                                            HttpSession session ) throws SQLException, IOException{

        SaleProduct saleProducts = saleProductService.getSaleProductDetailByTitle(saleProductTitle);

        if (saleProducts == null){
            session.setAttribute("errorMsg","数据为空");
            return JSON.toJSONString(saleProducts);
        }else {
            return JSON.toJSONString(saleProducts);
        }
    }

    @RequestMapping(value = "/admin/saleProduct/findAll", method = RequestMethod.GET)
    public String findAllProducts (@RequestParam("adminId")String adminID, HttpSession session)  throws IOException, SQLException{

        List<SaleProduct> saleProducts = saleProductService.getAllProducts(adminID);

        if (saleProducts == null){
            session.setAttribute("errorMsg","数据为空");
            return JSON.toJSONString(saleProducts);
        } else{
            return JSON.toJSONString(saleProducts);
        }

    }

    @RequestMapping(value = "/admin/saleProduct/delete", method = RequestMethod.GET)
    public String deleteOneProduct(@RequestParam("saleProductId") String saleProductId,HttpSession session) throws SQLException {

        SaleProduct saleProduct = saleProductService.getSaleProductDetailByID(saleProductId);

        saleProductService.deleteSaleProduct(saleProductId);

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);

    }

    @RequestMapping(value = "/admin/saleProduct/update", method = RequestMethod.POST)
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

        int result = saleProductService.updateInfo(saleProductId, saleProductTitle, saleProductIntro, saleProductContent, saleProductStartTime, saleProductEndTime, saleProductRange, saleProductType, saleProductStatus);

        if (result == 0 ) {
            session.setAttribute("errorMsg", "查找不到该活动");
            return null;
        }
        if (result == 1 ) {
            session.setAttribute("errorMsg", "活动相同");
            return null;
        }

        MapFactory mapFactory = new MapFactory();
        return mapFactory.getStringObjectMap(session);
    }

    @RequestMapping(value = "/admin/insertSaleProduct", method = RequestMethod.POST)
    public String insertSaleProduct (@RequestParam("saleProductTitle") String saleProductTitle,
                                   @RequestParam("saleProductIntro") String saleProductIntro,
                                   @RequestParam("saleProductContent") String saleProductContent,
                                     @RequestParam("adminId") String adminId,
                                   @RequestParam("saleProductStartTime") String saleProductstartTime,
                                   @RequestParam("saleProductEndTime") String saleProductendTime,
                                   @RequestParam("saleProductRange") String saleProductRange,
                                   @RequestParam("saleProductType") String saleProductType,
                                   @RequestParam("saleProductStatus") String saleProductStatus,
                                   HttpSession session) throws  SQLException  {

        Timestamp saleProductStartTime = Timestamp.valueOf(saleProductstartTime);
        Timestamp saleProductEndTime = Timestamp.valueOf(saleProductendTime);

        int result = saleProductService.Insert(adminId, saleProductTitle, saleProductIntro, saleProductContent,saleProductStartTime, saleProductEndTime, saleProductRange, saleProductType, saleProductStatus);

        if (result == 1){
            session.setAttribute("errorMsg","请输入管理员ID");
            return null;
        }else {
            MapFactory mapFactory = new MapFactory();
            return mapFactory.getStringObjectMap(session);
        }
    }
}
