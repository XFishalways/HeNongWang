package com.bug.henong.service;

import com.bug.henong.dao.BusinessItemDao;
import com.bug.henong.entity.BusinessItem;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("BusinessItemService")
public class BusinessItemService {

    private BusinessItemDao businessItemDao =new BusinessItemDao();

    /**得到商家所有商品*/
    public List<BusinessItem> getBusinessItemsByBusinessId(String businessId) throws SQLException {
        return businessItemDao.findBusinessItemsByUserID(businessId);
    }
    /**得到商品信息*/
    public BusinessItem getItemDetailById(String itemId) throws SQLException {
        return businessItemDao.findOneItem(itemId);
    }
    /**通过名字得到商品*/
    public List<BusinessItem> getBusinessItemsByName(String itemName) throws SQLException {
        return businessItemDao.findBusinessItemByTitle(itemName);
    }
    /**通过名字*/
    public List<BusinessItem> getBusinessItemsByNameAndBusinessId(String businessId,String itemName) throws SQLException {
        return businessItemDao.findBusinessItemsByTitleAndBusinessId(businessId,itemName);
    }
    /**得到商家所有在售商品*/
    public List<BusinessItem> getBusinessItemsOnsale(String businessId) throws SQLException {
        return businessItemDao.getBusinessItemsOnsale(businessId);
    }
    /**得到商家所有未售商品*/
    public List<BusinessItem> getBusinessItemsOffsale(String businessId) throws SQLException {
        return businessItemDao.getBusinessItemsOffsale(businessId);
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
    /**上架商品*/
    public Boolean putItemOnSale(String skuId) throws SQLException {
        int rs = businessItemDao.updateSkuStatus(skuId,"onsale");
        return rs>0;
    }
    /**下架商品*/
    public Boolean putItemOffSale(String skuId) throws SQLException {
        int rs = businessItemDao.updateSkuStatus(skuId,"offsale");
        return rs>0;
    }
}
