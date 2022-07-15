package com.bug.henong.service;

import com.bug.henong.dao.BusinessItemDao;
import com.bug.henong.entity.BusinessItem;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BusinessItemService {

    private BusinessItemDao businessItemDao =new BusinessItemDao();

    /**得到商品信息*/
    public BusinessItem getItemDetailById(String itemId) throws SQLException {
        return businessItemDao.findOneItem(itemId);
    }

    /**修改商品标题*/
    public Boolean updateSkuTitle(String itemId, String newSkuTitle) throws SQLException {
        BusinessItem businessItem = businessItemDao.findOneItem(itemId);

        //当前用户非空才可以进行更改
        if (businessItem != null) {

                int rw = businessItemDao.updateSkuTitle(itemId, newSkuTitle);
                return rw > 0;


        }

        return false;
    }

    /**修改商品介绍*/
    public Boolean updateSkuIntro(String itemId, String newSkuIntro) throws SQLException {
        BusinessItem businessItem = businessItemDao.findOneItem(itemId);

        //当前用户非空才可以进行更改
        if (businessItem != null) {

                int rw = businessItemDao.updateSkuIntro(itemId, newSkuIntro);
                return rw > 0;


        }

        return false;
    }

    /**修改售价*/
    public Boolean updateSalePrice(String itemId,  Double newSalePrice) throws SQLException {
        BusinessItem businessItem = businessItemDao.findOneItem(itemId);

        //当前用户非空才可以进行更改
        if (businessItem != null) {

                int rw = businessItemDao.updateSalePrice(itemId, newSalePrice);
                return rw > 0;


        }

        return false;
    }

    /**修改商品数量*/
    public Boolean updateQuantity(String itemId, Double newQuantity) throws SQLException {
        BusinessItem businessItem = businessItemDao.findOneItem(itemId);

        //当前用户非空才可以进行更改
        if (businessItem != null) {

                int rw = businessItemDao.updateQuantity(itemId, newQuantity);
                return rw > 0;


        }

        return false;
    }

    /**修改活动ID*/
    public Boolean updateEventId(String itemId,  String newEventId) throws SQLException {
        BusinessItem businessItem = businessItemDao.findOneItem(itemId);

        //当前用户非空才可以进行更改
        if (businessItem != null) {

                int rw = businessItemDao.updateEventID(itemId, newEventId);
                return rw > 0;


        }

        return false;
    }

}
