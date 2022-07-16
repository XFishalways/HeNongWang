package com.bug.henong.service;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.GoodsDao;
import com.bug.henong.entity.Goods;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service("GoodsService")
public class GoodsService {

    private GoodsDao goodsDao =new GoodsDao();

    /**
     * 添加一个商品
     */
    public int Insert( String goodsName, Timestamp goodsTime, String goodsPlace) throws SQLException {

        Goods goods = new Goods();

        Snowflake snowflake = IdUtil.getSnowflake(2, 1);
        String goodsId = snowflake.nextIdStr();

        goods.setGoodsId(goodsId);

        if (goodsName != null) {
            goods.setGoodsName(goodsName);
        }
        if (goodsTime != null) {
            goods.setGoodsTime(goodsTime);
        }
        if (goodsPlace != null) {
            goods.setGoodsPlace(goodsPlace);
        }

        return goodsDao.insert(goods);
    }

    /**
     * 得到商品活动ID信息
     */
    public Goods getGoodsId(String loginGoodsId) throws SQLException {

        return goodsDao.findOneGoods(loginGoodsId);
    }

    public void deleteGoods(String loginGoodsId) throws SQLException {

        goodsDao.delete(loginGoodsId);
    }

    public List<Goods> getAllGoods() throws SQLException {

        return goodsDao.findAll();
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
            int rw = goodsDao.updateQuantity(loginGoodsId, newQuantity);
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
            int rw = goodsDao.updatePrice(loginGoodsId, newPrice);
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
            int rw = goodsDao.updatePass(newGoodsStatus,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    /**
     * 修改商品好评度
     */
    public Boolean updateDegree(String loginGoodsId, String newPraiseDegree) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前用户非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updateDegree(newPraiseDegree,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    public Boolean updateImage(String loginGoodsId, String Image) throws SQLException {
        Goods goods = goodsDao.findOneGoods(loginGoodsId);

        //当前用户非空才可以进行更改
        if (goods != null) {
            int rw = goodsDao.updateImage(Image,loginGoodsId);
            return rw > 0;
        }

        return false;
    }

    public Boolean updateInfo(Goods goods, String goodsName, Double goodsQuantity, Double goodsPrice, String goodsSale, String goodsPass, String goodsDegree, String goodsImage) throws SQLException {

        //当前用户非空才可以进行更改
        Snowflake snowflake = IdUtil.getSnowflake(2, 1);
        String goodsId = snowflake.nextIdStr();

        if (goods != null) {
            if (!goods.getGoodsName().equals(goodsName)) {
                goodsDao.updateGoodsName(goodsId, goodsName);
            }
            if (!goods.getGoodsQuantity().equals(goodsQuantity)) {
                goodsDao.updateQuantity(goodsId, goodsQuantity);
            }
            if (!goods.getGoodsPrice().equals(goodsPrice)) {
                goodsDao.updatePrice(goodsId, goodsPrice);
            }
            if (!goods.getGoodsSale().equals(goodsSale)) {
                goodsDao.updateSale(goodsId, goodsSale);
            }
            if (!goods.getGoodsDegree().equals(goodsDegree)) {
                goodsDao.updateDegree(goodsId,goodsDegree);
            }
            if (!goods.getGoodsPass().equals(goodsPass)) {
                goodsDao.updatePass(goodsId, goodsPass);
            }
            if (!goods.getGoodsImage().equals(goodsImage)) {
                goodsDao.updateImage(goodsId, goodsImage);
            }
        }

        return false;
    }

    public List<Goods> getGoodsFromTo(int curentPage, int pageSize) throws SQLException {
        return goodsDao.findGoodsFromTo(curentPage,pageSize);
    }
}
