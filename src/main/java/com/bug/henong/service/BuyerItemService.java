package com.bug.henong.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.*;
import com.bug.henong.dao.BuyerItemDao;
import com.bug.henong.entity.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("BuyerItemService")
public class BuyerItemService {

    private BuyerItemDao buyerItemDao =new BuyerItemDao();

    /**得到商品信息*/
    public List<BuyerItem> getBuyerItemDetailById(String itemId) throws SQLException {
        return buyerItemDao.findAllItem(itemId);
    }


//    public Boolean updateItem(BuyerItem buyerItem, String goodsName, Double goodsQuantity, Double goodsPrice, String goodsSale, String goodsPass, String goodsDegree, String goodsImage) throws SQLException {
//
//        //当前用户非空才可以进行更改
//        Snowflake snowflake = IdUtil.getSnowflake(3, 1);
//        String goodsId = snowflake.nextIdStr();

//        if (goods != null) {
//            if (!goods.getGoodsName().equals(goodsName)) {
//                goodsDao.updateGoodsName(goodsId, goodsName);
//            }
//            if (!goods.getGoodsQuantity().equals(goodsQuantity)) {
//                goodsDao.updateQuantity(goodsId, goodsQuantity);
//            }
//            if (!goods.getGoodsPrice().equals(goodsPrice)) {
//                goodsDao.updatePrice(goodsId, goodsPrice);
//            }
//            if (!goods.getGoodsSale().equals(goodsSale)) {
//                goodsDao.updateSale(goodsId, goodsSale);
//            }
//            if (!goods.getGoodsDegree().equals(goodsDegree)) {
//                goodsDao.updateDegree(goodsId,goodsDegree);
//            }
//            if (!goods.getGoodsPass().equals(goodsPass)) {
//                goodsDao.updatePass(goodsId, goodsPass);
//            }
//            if (!goods.getGoodsImage().equals(goodsImage)) {
//                goodsDao.updateImage(goodsId, goodsImage);
//            }
//        }
//
//        return false;
//    }
    public Boolean cartInsert (String userId, String skuId, Double quantity, Double price) throws SQLException {

        BuyerCartDao buyerCartDao = new BuyerCartDao();
        BuyerCart buyerCart = buyerCartDao.findOneCart(userId);

        if (buyerCart == null) return false;

        buyerCart.setUserId(userId);
        buyerCart.setTotalPrice(quantity*price);
        buyerCart.setPayablePrice(quantity*price);
        buyerCart.setCartStatus("Y");

        return buyerCartDao.insert(buyerCart) > 0;
    }

    public Boolean orderInsert (String userId, String skuId, Double quantity, Double price) throws SQLException {

        BuyerOrderDao buyerOrderDao = new BuyerOrderDao();

        BuyerOrder buyerOrder = buyerOrderDao.findOneOrder(userId);
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        if(buyerOrder == null) return false;

        Snowflake snowflake = IdUtil.getSnowflake(4, 1);
        String invoiceTplId = snowflake.nextIdStr();
        String orderId = snowflake.nextIdStr();

        buyerOrder.setOrderId(orderId);
        buyerOrder.setTotalPrice(price * quantity);
        buyerOrder.setCouponPrice(0.0);
        buyerOrder.setPayablePrice(price * quantity);
        buyerOrder.setInvoiceTplId(invoiceTplId);
        buyerOrder.setPayMethod("direct");
        buyerOrder.setOrderStatus("unconfirmed");

        return buyerOrderDao.insert(buyerOrder) > 0;
    }

    public Boolean itemInsert (String skuId) throws SQLException {

        Snowflake snowflake = IdUtil.getSnowflake(4, 1);
        String orderId = snowflake.nextIdStr();

        BusinessItemDao businessItemDao = new BusinessItemDao();
        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);
        BusinessItem businessItem = businessItemDao.findOneItem(skuId);

        if (buyerItem != null) {
            buyerItem.setSkuId(businessItem.getSkuId());
            buyerItem.setUserId(businessItem.getUserId());
            buyerItem.setSkuTitle(businessItem.getSkuTitle());
            buyerItem.setSkuIntro(businessItem.getSkuIntro());
            buyerItem.setPrice(businessItem.getPrice());
            buyerItem.setSalePrice(businessItem.getSalePrice());
            buyerItem.setQuantity(businessItem.getQuantity());
            return true;
        }
        else {
            return false;
        }
    }

    public int updateBuyerItemInfo(String skuId, String leaveComment, String skuImage) throws SQLException {

        BuyerItem buyerItem = buyerItemDao.findOneItem(skuId);

        if (buyerItem == null) {
            return 0;
        }

        if(!buyerItem.getLeaveComment().equals(leaveComment)) {
            buyerItemDao.updateLeaveComment(skuId, leaveComment);
        }
        if(!buyerItem.getSkuImage().equals(skuImage)) {
            buyerItemDao.updateSkuImage(skuId, skuImage);
        }

        return 1;
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
