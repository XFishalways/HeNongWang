package com.bug.henong.service;


import com.bug.henong.dao.SaleProductDao;
import com.bug.henong.entity.SaleProduct;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Cheng
 * @version 1.0.0
 */

@Service("SaleProductService")
public class SaleProductService {

    private SaleProductDao saleProductDao = new SaleProductDao();
    /**
     * 得到商品活动ID信息
     */
    public SaleProduct getSaleProductId(String loginProductId) throws SQLException {
        return saleProductDao.findOneProduct(loginProductId);
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

                int rw = saleProductDao.updateStart_time(newStartTime,loginProductId);
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

                int rw = saleProductDao.updateEnd_time(newEndTime,loginProductId);
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

}
