package com.bug.henong.service;

import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BuyerItemService {

    private BuyerItemDao buyerItemDao =new BuyerItemDao();

    /**得到商品信息*/
    public BuyerItem getBuyerItemDetailById(String itemId) throws SQLException {
        return buyerItemDao.findOneItem(itemId);
    }

    /**修改商品标题*/
    public Boolean updateSkuTitle(String skuId,String newSkuTitle) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateSkuTitle(skuId, newSkuTitle);
                return rw > 0;


        }

        return false;
    }

    /**修改商品介绍*/
    public Boolean updateSkuIntro(String skuId,  String newSkuIntro) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateSkuIntro(skuId, newSkuIntro);
                return rw > 0;


        }

        return false;
    }

    /**修改订单留言备注*/
    public Boolean updateLeaveComment(String skuId,  String newLeaveComment) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateLeaveComment(skuId, newLeaveComment);
                return rw > 0;


        }

        return false;
    }

    /**修改售价*/
    public Boolean updateSalePrice(String skuId,Double newSalePrice) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {

                int rw = buyerItemDao.updateSalePrice(skuId, newSalePrice);
                return rw > 0;


        }

        return false;
    }

}
