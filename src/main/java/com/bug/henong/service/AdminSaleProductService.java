package com.bug.henong.service;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.SaleProductDao;
import com.bug.henong.entity.SaleProduct;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Cheng
 * @version 1.0.0
 */

@Service("AdminSaleProductService")
public class AdminSaleProductService {

    private SaleProductDao saleProductDao = new SaleProductDao();


    /**
     * 添加一个活动
     */

    public int Insert(String adminId, String saleProductTitle, String saleProductIntro, String saleProductContent, Timestamp saleProductStartTime, Timestamp saleProductEndTime, String saleProductRange, String saleProductType, String saleProductStatus) throws SQLException {

        SaleProduct saleProduct = new SaleProduct();

        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        String productId = snowflake.nextIdStr();

        saleProduct.setSaleProductId(productId);

        if (adminId == null){
            return 1;
        }

        if (saleProductTitle != null) {
            saleProduct.setSaleProductTitle(saleProductTitle);
        }
        if (saleProductIntro != null) {
            saleProduct.setSaleProductIntro(saleProductIntro);
        }
        if (saleProductContent != null) {
            saleProduct.setSaleProductContent(saleProductContent);
        }
        if (saleProductStartTime != null) {
            saleProduct.setSaleProductStartTime(saleProductStartTime);
        }
        if (saleProductEndTime != null) {
            saleProduct.setSaleProductEndTime(saleProductEndTime);
        }
        if (saleProductRange != null) {
            saleProduct.setSaleProductRange(saleProductRange);
        }
        if (saleProductType != null) {
            saleProduct.setSaleProductType(saleProductType);
        }
        if (saleProductStatus != null) {
            saleProduct.setSaleProductStatus(saleProductStatus);
        }

        return saleProductDao.insert(saleProduct);

    }

    /**
     * 得到商品活动信息
     */
    public SaleProduct getSaleProductDetailByTitle(String loginProductTitle) throws SQLException {
        return saleProductDao.findOneProductByTitle(loginProductTitle);
    }

    public SaleProduct getSaleProductDetailByID(String loginProductId) throws SQLException {
        return saleProductDao.findOneProductById(loginProductId);
    }


    public void deleteSaleProduct(String loginProductId) throws SQLException {

        saleProductDao.delete(loginProductId);
    }

    public List<SaleProduct> getAllProducts(String adminId) throws SQLException {

        return saleProductDao.findAll(adminId);
    }


    /**
     * 修改活动标题
     */
    public Boolean updateTitle(String loginProductTitle, String newTitle) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateTitle(loginProductTitle,newTitle);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动说明
     */
    public Boolean updateIntro(String loginProductTitle, String newIntro) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateIntro(loginProductTitle,newIntro);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动内容
     */
    public Boolean updateContent(String loginProductTitle, String newContent) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateContent(loginProductTitle,newContent);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动起始时间
     */
    public Boolean updateStart_time(String loginProductTitle, Timestamp newStartTime) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateStart_time(loginProductTitle,newStartTime);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改活动截止时间
     */
    public Boolean updateEndTime(String loginProductTitle, Timestamp newEndTime) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateEnd_time(loginProductTitle,newEndTime);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动范围
     */
    public Boolean updateRange(String loginProductTitle, String newRange) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {
                     int rw = saleProductDao.updateRange(loginProductTitle,newRange);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改活动类型
     */
    public Boolean updateType(String loginProductTitle, String newType) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {
                int rw = saleProductDao.updateType(loginProductTitle,newType);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动状态
     */
    public Boolean updateStatus(String loginProductTitle, String newStatus) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(loginProductTitle);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {
                  int rw = saleProductDao.updateStatus(loginProductTitle,newStatus);
                return rw > 0;

        }

        return false;
    }
    public int updateInfo(String productTitle, String saleProductTitle, String saleProductIntro, String saleProductContent, Timestamp saleProductStartTime, Timestamp saleProductEndTime, String saleProductRange, String saleProductType, String saleProductStatus) throws SQLException{

        SaleProduct saleProduct = saleProductDao.findOneProductByTitle(productTitle);
        //当前用户非空才可以进行更改
        if (saleProduct == null) {
            return 0;
        }

        if (!saleProduct.getSaleProductTitle().equals(saleProductTitle)) {
                saleProductDao.updateTitle(productTitle,saleProductTitle);
            }
        if (!saleProduct.getSaleProductIntro().equals(saleProductIntro)) {
                saleProductDao.updateIntro(productTitle,saleProductIntro);
            }
        if (!saleProduct.getSaleProductContent().equals(saleProductContent)) {
                saleProductDao.updateContent(productTitle,saleProductContent);
            }
        if (!saleProduct.getSaleProductStartTime().equals(saleProductStartTime)) {
                saleProductDao.updateStart_time(productTitle,saleProductStartTime);
            }
        if (!saleProduct.getSaleProductEndTime().equals(saleProductEndTime)) {
                saleProductDao.updateEnd_time(productTitle,saleProductEndTime);
            }
        if (!saleProduct.getSaleProductRange().equals(saleProductRange)) {
                saleProductDao.updateRange(productTitle,saleProductRange);
            }
        if (!saleProduct.getSaleProductType().equals(saleProductType)) {
                saleProductDao.updateType(productTitle,saleProductType);
            }
        if (!saleProduct.getSaleProductStatus().equals(saleProductStatus)) {
                saleProductDao.updateStatus(productTitle,saleProductStatus);
            }


        return 1;
    }


}
