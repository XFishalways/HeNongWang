package com.bug.henong.service;


import com.bug.henong.dao.GoodsDao;
import com.bug.henong.entity.Goods;

import java.sql.SQLException;



public class GoodsService {

    private GoodsDao goodsDao =new GoodsDao();

    /**
     * 得到商品活动ID信息
     */
    public Goods getGoodsId(String loginGoodsId) throws SQLException {

        return goodsDao.findOneGoods(loginGoodsId);
    }

    /**
     * 修改商品名称
     */
    public Boolean updateGoodsName(String loginGoodsId, String newGoodsName) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前商品非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updateGoodsName(newGoodsName,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    /**
     * 修改商品数量
     */
    public Boolean updateQuantity(String loginGoodsId, Double newQuantity) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前商品非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updateQuantity(newQuantity,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    /**
     * 修改商品价格
     */
    public Boolean updatePrice(String loginGoodsId, Double newPrice) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前用户非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updatePrice(newPrice,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    /**
     * 修改商品是否售罄
     */
    public Boolean updateSale(String loginGoodsId, String newStatus) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前用户非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updateSale(newStatus,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    /**
     * 修改审核是否通过
     */
    public Boolean updatePass(String loginGoodsId, String newGoodsStatus) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前用户非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updateUserPass(newGoodsStatus,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    /**
     * 修改商品好评度
     */
    public Boolean updatePassSalt(String loginGoodsId, String newPraiseDegree) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前用户非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updatePassSalt(newPraiseDegree,loginGoodsId);
            return rw > 0;
        }

        return false;
    }
}
