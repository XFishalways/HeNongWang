package com.bug.henong.dao;

import cn.hutool.db.*;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Goods;
/**
 * @author xiahaolin
 * @version 1.0.0
 * @date 22.07.13
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GoodsDao {

    /**添加*/
    public int insert(Goods goods) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(goods);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_USER").set("USER_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<Goods> findAll() throws SQLException {

        String sql = "SELECT * FROM GOODS";

        List<Goods> goods = new ArrayList<Goods>();
        List<Entity> entities = Db.use().findAll("GOODS");

        for(Entity e : entities){
            String goodsStr = JSONUtil.toJsonStr(e);
            //Goods goods = JSONUtil.toBean(goodsStr,Goods.class);
            //goods.add(goods);
        }

        return goods;
    }

    /**通过id查找某一行数据*/
    public Goods findOneGoods(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("GOODS").set("GOODS_ID",id)
        );
        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String goodsStr = JSONUtil.toJsonStr(e);
        Goods goods = JSONUtil.toBean(goodsStr,Goods.class);

        return  goods;
    }

    /**更新名称*/
    public int updateGoodsName(String goodsName, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("GOODS_NAME",goodsName),
                Entity.create("GOODS").set("GOODS_ID",id)
        );

        return rw;
    }

    /**更新数量*/
    public int updateQuantity(String goodsQuantity, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("GOODS_QUANTITY",goodsQuantity),
                Entity.create("GOODS").set("GOODS_ID",id)
        );

        return rw;
    }

    /**更新价格*/
    public int updatePrice(String price, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PRICE",price),
                Entity.create("GOODS").set("GOODS_ID",id)
        );

        return rw;
    }

    /**更新是否售罄*/
    public int updatePhone(String sellout, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("IF_SEELOUT",sellout),
                Entity.create("GOODS").set("GOODS_ID",id)
        );

        return rw;
    }

    /**更新审核是否通过*/
    public int updateUserPass(String ifPass, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("IF_PASS",ifPass),
                Entity.create("GOODS").set("GOODS_ID",id)
        );

        return rw;

    }
    /**更新好评度*/
    public int updatePassSalt(String PraiseDegree, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PRAISE_DEGREE",PraiseDegree),
                Entity.create("GOODS").set("GOODS_ID",id)
        );

        return rw;

    }

}