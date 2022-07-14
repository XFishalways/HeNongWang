package com.bug.henong.service;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.bug.henong.dao.GoodsDao;
import com.bug.henong.entity.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XFishalways
 * @version 1.0.0
 * @date 22.07.14
 */

@Service("GoodsService")
public class GoodsService {

    private GoodsDao goodsDao ;

    /**添加商品*/
    public int insert (Goods goods) throws SQLException {

        return goodsDao.insert(goods);
    }

    /**删除商品*/
    public int delete (String id) throws SQLException {

        return goodsDao.delete(id);
    }

    /**返回所有商品信息*/
    public List<Goods> findAll() throws SQLException {

        return goodsDao.findAll();
    }

    /**更新名称*/
    public int updateGoodsName(String goodsName, String id) throws SQLException {

        return goodsDao.updateGoodsName(goodsName, id);
    }

    /**更新数量*/
    public int updateQuantity(String goodsQuantity, String id) throws SQLException {

        return goodsDao.updateQuantity(goodsQuantity, id);
    }

    /**更新价格*/
    public int updatePrice(String price, String id) throws SQLException {

        return goodsDao.updatePrice(price, id);
    }

    /**更新采摘地址*/
    public int updatePlace(String place, String id) throws SQLException {

        return goodsDao.updatePlace(place, id);
    }

    /**更新好评度*/
    public int updateDegree(String degree, String id) throws SQLException {

        return goodsDao.updateDegree(degree, id);
    }

    /**更新采摘时间*/
    public int updateTime(Timestamp time, String id) throws SQLException {

        return goodsDao.updateTime(time, id);
    }

    /**更新是否售罄*/
    public int updateSale(String sale, String id) throws SQLException {

        return goodsDao.updateSale(sale, id);
    }

    /**更新审核是否通过*/
    public int updatePass(String pass, String id) throws SQLException {

        return goodsDao.updatePass(pass, id);
    }

    /**通过id查找某一行数据*/
    public Goods getOneGoods(String id) throws SQLException {

        return goodsDao.findOneGoods(id);
    }

}

