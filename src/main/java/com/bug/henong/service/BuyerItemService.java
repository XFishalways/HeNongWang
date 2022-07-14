package com.bug.henong.service;

import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BuyerItemService {

    private BuyerItemDao buyerItemDao;

    /**得到商品信息*/
    public BuyerItem getBuyerItemDetailById(String itemId) throws SQLException {
        return buyerItemDao.findOneItem(itemId);
    }

    /**修改商品标题*/
    public Boolean updateSkuTitle(String skuId, String originalSkuTitle, String newSkuTitle) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {
            if (originalSkuTitle.equals(buyerItem.getSkuTitle())) {
                int rw = buyerItemDao.updateSkuTitle(skuId, newSkuTitle);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改商品介绍*/
    public Boolean updateSkuIntro(String skuId, String originalSkuIntro, String newSkuIntro) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {
            if (originalSkuIntro.equals(buyerItem.getSkuIntro())) {
                int rw = buyerItemDao.updateSkuIntro(skuId, newSkuIntro);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改订单留言备注*/
    public Boolean updateLeaveComment(String skuId, String originalLeaveComment, String newLeaveComment) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {
            if (originalLeaveComment.equals(buyerItem.getLeaveComment())) {
                int rw = buyerItemDao.updateLeaveComment(skuId, newLeaveComment);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改售价*/
    public Boolean updateSalePrice(String skuId, Double originalSalePrice, Double newSalePrice) throws SQLException {
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        //当前商品非空才可以进行更改
        if (buyerItem != null) {
            if (originalSalePrice == buyerItem.getSalePrice()) {
                int rw = buyerItemDao.updateSalePrice(skuId, newSalePrice);
                return rw > 0;
            }

        }

        return false;
    }

}
