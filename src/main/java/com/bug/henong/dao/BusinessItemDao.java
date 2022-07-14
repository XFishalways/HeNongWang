package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rui
 * @version 1.0.0
 * @date 22.07.13
 */
public class BusinessItemDao {

    /**添加*/
    public int insert(BusinessItem item) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(item);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<BusinessItem> findAll() throws SQLException {

        String sql = "SELECT * FROM BUSINESS_ITEM";

        List<BusinessItem> businessItems = new ArrayList<BusinessItem>();
        List<Entity> entities = Db.use().findAll("BUSINESS_ITEM");

        for(Entity e : entities){
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem = JSONUtil.toBean(itemStr,BusinessItem.class);
            businessItems.add(businessItem);
        }

        return businessItems;
    }

    /**通过id查找某一行数据*/
    public BusinessItem findOneItem(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String itemStr = JSONUtil.toJsonStr(e);
        BusinessItem businessItem = JSONUtil.toBean(itemStr,BusinessItem.class);

        return  businessItem;
    }

    /**更新商品标题*/
    public int updateSkuTitle(String skuTitle, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_TITLE",skuTitle),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新商品介绍*/
    public int updateSkuIntro(String skuIntro, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_INTRO",skuIntro),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新售价*/
    public int updateSalePrice(String salePrice, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRICE",salePrice),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新商品数量*/
    public int updateQuantity(String quantity, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("QUANTITY",quantity),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新活动ID*/
    public int updateEventID(String eventID, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("EVENT_ID",eventID),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;

    }

}