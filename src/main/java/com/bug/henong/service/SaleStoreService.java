package com.bug.henong.service;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.SaleStoreDao;
import com.bug.henong.entity.Goods;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service("SaleStoreService")
public class SaleStoreService {

    private SaleStoreDao saleStoreDao = new SaleStoreDao();
    /**
     * 得到商品活动ID信息
     */
    public SaleStore getSaleStoreId(String loginStoreId) throws SQLException {
        return saleStoreDao.findOneStore(loginStoreId);
    }

    public void deleteSale(String saleId) throws SQLException {

        saleStoreDao.delete(saleId);
    }

    /**
     *查找所有商店活动
     */
    public List<SaleStore> getAllSalesById(String adminId) throws SQLException {

        return saleStoreDao.findAll(adminId);
    }

    /**
     * 通过标题查找商店活动
     */
    public List<SaleStore> getOneSaleByTitle(String title) throws SQLException{
        return saleStoreDao.findSaleStoreByTitle(title);
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
                 int rw = saleStoreDao.updateActivityStart_Time(loginStoreId,newActivityStartTime);
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
               int rw = saleStoreDao.updateActivityEnd_time(loginStoreId,newActivityEndTime);
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

    public int Insert(String saleStoreTitle, String saleStoreIntro, String saleStoreContent,
                      Timestamp saleStoreStartTime, Timestamp saleStoreEndTime, String saleStoreRange,
                      String saleStoreType, String saleStoreStatus) throws SQLException{

        SaleStore saleStore = new SaleStore();

        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        String saleStoreId = snowflake.nextIdStr();

        saleStore.setSaleStoreid(saleStoreId);

        saleStore.setSaleStoreTitle(saleStoreTitle);
        saleStore.setSaleStoreIntro(saleStoreIntro);
        saleStore.setSaleStoreContent(saleStoreContent);
        saleStore.setSaleStoreStartTime(saleStoreStartTime);
        saleStore.setSaleStoreEndTime(saleStoreEndTime);
        saleStore.setSaleStoreRange(saleStoreRange);
        saleStore.setSaleStoreType(saleStoreType);
        saleStore.setSaleStoreStatus(saleStoreStatus);

        return saleStoreDao.insert(saleStore);

    }

    public Boolean update(String saleStoreId, String saleStoreTitle, String saleStoreIntro,
                          String saleStoreContent, Timestamp saleStoreStartTime,
                          Timestamp saleStoreEndTime, String saleStoreRange, String saleStoreType,
                          String saleStoreStatus) throws SQLException{

        SaleStore saleStore = saleStoreDao.findOneStore(saleStoreId);

        if(saleStore != null){
            if (!saleStore.getSaleStoreTitle().equals(saleStoreTitle)) {
                saleStoreDao.updateActivityTitle(saleStoreTitle, saleStoreId);
            }
            if (!saleStore.getSaleStoreIntro().equals(saleStoreIntro)) {
                saleStoreDao.updateActivityIntro(saleStoreIntro, saleStoreId);
            }
            if (!saleStore.getSaleStoreContent().equals(saleStoreContent)) {
                saleStoreDao.updateActivityContent(saleStoreContent, saleStoreId);
            }
            if (!saleStore.getSaleStoreStartTime().equals(saleStoreStartTime)) {
                saleStoreDao.updateActivityStart_Time(saleStoreId, saleStoreStartTime);
            }
            if (!saleStore.getSaleStoreEndTime().equals(saleStoreEndTime)) {
                saleStoreDao.updateActivityEnd_time( saleStoreId, saleStoreEndTime);
            }
            if (!saleStore.getSaleStoreRange().equals(saleStoreRange)) {
                saleStoreDao.updateActivityRange(saleStoreRange, saleStoreId);
            }
            if (!saleStore.getSaleStoreType().equals(saleStoreType)) {
                saleStoreDao.updateActivityType(saleStoreType, saleStoreId);
            }
            if (!saleStore.getSaleStoreStatus().equals(saleStoreStatus)) {
                saleStoreDao.updateActivity_Status(saleStoreStatus, saleStoreId);
            }
        }
        return false;
    }

}
