package com.bug.henong.service;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.SaleProductDao;
import com.bug.henong.entity.Goods;
import com.bug.henong.entity.SaleProduct;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Cheng
 * @version 1.0.0
 */

@Service("SaleProductService")
public class SaleProductService {

    private SaleProductDao saleProductDao = new SaleProductDao();


    /**
     * 添加一个活动
     */

    public int Insert(String saleProductTitle, String saleProductIntro, String saleProductContent, Timestamp saleProductStartTime, Timestamp saleProductEndTime, String saleProductRange, String saleProductType, String saleProductStatus) throws SQLException {

        SaleProduct saleProduct = new SaleProduct();

        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        String productId = snowflake.nextIdStr();

        saleProduct.setSaleProductId(productId);

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
     * 得到商品活动ID信息
     */
    public SaleProduct getSaleProductId(String loginProductId) throws SQLException {
        return saleProductDao.findOneProduct(loginProductId);
    }


    public void deleteSaleProduct(String loginProductId) throws SQLException {

        saleProductDao.delete(loginProductId);
    }

    public List<SaleProduct> getAllProducts() throws SQLException {

        return saleProductDao.findAll();
    }


    /**
     * 修改活动标题
     */
    public Boolean updateTitle(String loginProductId, String newTitle) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateTitle(newTitle,loginProductId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动说明
     */
    public Boolean updateIntro(String loginProductId, String newIntro) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateIntro(newIntro,loginProductId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动内容
     */
    public Boolean updateContent(String loginProductId, String newContent) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateContent(newContent,loginProductId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动起始时间
     */
    public Boolean updateStart_time(String loginProductId, Timestamp newStartTime) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateStart_time(loginProductId,newStartTime);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改活动截止时间
     */
    public Boolean updateEndTime(String loginProductId, Timestamp newEndTime) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {

                int rw = saleProductDao.updateEnd_time(loginProductId,newEndTime);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动范围
     */
    public Boolean updateRange(String loginProductId, String newRange) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {
                     int rw = saleProductDao.updateRange(newRange,loginProductId);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改活动类型
     */
    public Boolean updateType(String loginProductId, String newType) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {
                int rw = saleProductDao.updateType(newType,loginProductId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改活动状态
     */
    public Boolean updateStatus(String loginProductId, String newStatus) throws SQLException {
        SaleProduct saleProduct = saleProductDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (saleProduct != null) {
                  int rw = saleProductDao.updateStatus(newStatus,loginProductId);
                return rw > 0;

        }

        return false;
    }
    public Boolean updateInfo(String productId, String saleProductTitle, String saleProductIntro, String saleProductContent, Timestamp saleProductStartTime, Timestamp saleProductEndTime, String saleProductRange, String saleProductType, String saleProductStatus) throws SQLException{

        SaleProduct saleProduct = saleProductDao.findOneProduct(productId);
        //当前用户非空才可以进行更改

        if (saleProduct != null) {
            if (!saleProduct.getSaleProductTitle().equals(saleProductTitle)) {
                saleProductDao.updateTitle(saleProductTitle,productId);
            }
            if (!saleProduct.getSaleProductIntro().equals(saleProductIntro)) {
                saleProductDao.updateIntro(saleProductIntro,productId);
            }
            if (!saleProduct.getSaleProductContent().equals(saleProductContent)) {
                saleProductDao.updateContent(saleProductContent,productId);
            }
            if (!saleProduct.getSaleProductStartTime().equals(saleProductStartTime)) {
                saleProductDao.updateStart_time(productId,saleProductStartTime);
            }
            if (!saleProduct.getSaleProductEndTime().equals(saleProductEndTime)) {
                saleProductDao.updateEnd_time(productId,saleProductEndTime);
            }
            if (!saleProduct.getSaleProductRange().equals(saleProductRange)) {
                saleProductDao.updateRange(saleProductRange,productId);
            }
            if (!saleProduct.getSaleProductType().equals(saleProductType)) {
                saleProductDao.updateType(saleProductType,productId);
            }
            if (!saleProduct.getSaleProductStatus().equals(saleProductStatus)) {
                saleProductDao.updateStatus(saleProductStatus,productId);
            }
        }

        return false;
    }

}
