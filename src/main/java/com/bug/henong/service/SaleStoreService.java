package com.bug.henong.service;


import com.bug.henong.dao.SaleStoreDao;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;

@Service("SaleStoreService")
public class SaleStoreService {

    private SaleStoreDao saleStoreDao = new SaleStoreDao();
    /**
     * 得到商品活动ID信息
     */
    public SaleStore getSaleStoreId(String loginStoreId) throws SQLException {
        return saleStoreDao.findOneStore(loginStoreId);
    }

    /**
     * 修改店铺活动标题
     */
    public Boolean updateActivityTitle(String loginStoreId, String newActivityTitle) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                 int rw = saleStoreDao.updateActivityTitle(newActivityTitle,loginStoreId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改店铺活动说明
     */
    public Boolean updateActivityIntro(String loginStoreId, String newActivityIntro) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                int rw = saleStoreDao.updateActivityIntro(newActivityIntro,loginStoreId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改店铺内容说明
     */
    public Boolean updateActivityContent(String loginStoreId, String newActivityContent) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                int rw = saleStoreDao.updateActivityContent(newActivityContent,loginStoreId);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改店铺起始时间
     */
    public Boolean updateActivityStartTime(String loginStoreId, Timestamp newActivityStartTime) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                 int rw = saleStoreDao.updateActivityStart_Time(newActivityStartTime,loginStoreId);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改店铺截止时间
     */
    public Boolean updateActivityEndTime(String loginStoreId, Timestamp newActivityEndTime) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
               int rw = saleStoreDao.updateActivityEnd_time(newActivityEndTime,loginStoreId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改店铺活动范围
     */
    public Boolean updateActivityRange(String loginStoreId, String newActivityRange) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                 int rw = saleStoreDao.updateActivityRange(newActivityRange,loginStoreId);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改店铺活动类型
     */
    public Boolean updateActivityType(String loginStoreId, String newActivityType) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                int rw = saleStoreDao.updateActivityType(newActivityType,loginStoreId);
                return rw > 0;

        }

        return false;
    }

    /**
     * 修改店铺状态说明
     */
    public Boolean updateActivityStatus(String loginStoreId, String newActivityStatus) throws SQLException {
        SaleStore saleStore = saleStoreDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (saleStore != null) {
                int rw = saleStoreDao.updateActivity_Status(newActivityStatus,loginStoreId);
                return rw > 0;
        }

        return false;
    }

}
