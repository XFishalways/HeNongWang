package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessItem;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.Goods;

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
    public int delete(String id) throws SQLException {

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

    /**
     * 通过标题查找
     */
    public List<BusinessItem> findBusinessItemByTitle(String skuTitle,int currentPage,int pageSize) throws SQLException {
        List<BusinessItem> businessItem = new ArrayList<BusinessItem>();
        int m = (currentPage-1)*pageSize;
        int n = pageSize;
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_ITEM Where SKU_TITLE LIKE ? LIMIT ?,?", "%"+skuTitle+"%",m,n);

        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem1 = JSONUtil.toBean(itemStr, BusinessItem.class);
            businessItem.add(businessItem1);
        }
        return businessItem;
    }

    /**
     * 通过用户ID查找
     */
    public List<BusinessItem> findBusinessItemsByUserID(String userId) throws SQLException {
        List<BusinessItem> businessItem = new ArrayList<BusinessItem>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_ITEM Where USER_ID = ?", userId);

        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem1 = JSONUtil.toBean(itemStr, BusinessItem.class);
            businessItem.add(businessItem1);
        }
        return businessItem;
    }

    /**更新商品标题*/
    public int updateSkuTitle(String id, String skuTitle) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_TITLE",skuTitle),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新商品介绍*/
    public int updateSkuIntro(String id, String skuIntro) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_INTRO",skuIntro),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新售价*/
    public int updateSalePrice(String id, Double salePrice) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRICE",salePrice),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新商品数量*/
    public int updateQuantity(String id, Double quantity) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("QUANTITY",quantity),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    /**更新活动ID*/
    public int updateEventID(String id, String eventID) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("EVENT_ID",eventID),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;

    }
    /**更新商品状态*/
    public int updateSkuStatus(String id, String status) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_STATUS",status),
                Entity.create("BUSINESS_ITEM").set("SKU_ID",id)
        );

        return rw;

    }
    /**
     通过id和名字来共同寻找信息
     */

    public List<BusinessItem> findBusinessItemsByTitleAndBusinessId(String userId, String skuTitle) throws SQLException {
        List<BusinessItem> businessItem = new ArrayList<BusinessItem>();

        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_ITEM Where USER_ID = ? AND SKU_TITLE LIKE ?",userId, "%"+skuTitle+"%");
        if (entities.isEmpty()) {
            return null;
        }

        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem1 = JSONUtil.toBean(itemStr, BusinessItem.class);
            businessItem.add(businessItem1);
        }

        return businessItem;
    }
    /**得到商家所有在售商品*/
    public List<BusinessItem> getBusinessItemsOnsale(String userId) throws SQLException {
        List<BusinessItem> businessItem = new ArrayList<BusinessItem>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_ITEM Where USER_ID = ? AND SKU_STATUS", userId,"onsale");
        if (entities.isEmpty()) {
            return null;
        }
        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem1 = JSONUtil.toBean(itemStr, BusinessItem.class);
            businessItem.add(businessItem1);
        }
        return businessItem;
    }
    /**得到商家所有未售商品*/
    public List<BusinessItem> getBusinessItemsOffsale(String userId) throws SQLException {
        List<BusinessItem> businessItem = new ArrayList<BusinessItem>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_ITEM Where USER_ID = ? AND SKU_STATUS", userId,"offsale");
        if (entities.isEmpty()) {
            return null;
        }
        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem1 = JSONUtil.toBean(itemStr, BusinessItem.class);
            businessItem.add(businessItem1);
        }
        return businessItem;
    }
    /**随机得到*/
    public List<BusinessItem> getRandomItems() throws SQLException {
        List<BusinessItem> businessItems = new ArrayList<>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_ITEM ORDER BY RAND() LIMIT 12") ;
        if (entities.isEmpty()) {
            return null;
        }
        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BusinessItem businessItem = JSONUtil.toBean(itemStr, BusinessItem.class);
            businessItems.add(businessItem);
        }
        return businessItems;
    }
}