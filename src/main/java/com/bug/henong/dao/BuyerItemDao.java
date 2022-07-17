package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.entity.Farmer;
import com.bug.henong.entity.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerItemDao {
    //添加
    public int insert(BuyerItem item) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(item);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    //删除
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );
        return rw;

    }

    //返回所有信息
    public List<BuyerItem> findAllItem(String id) throws SQLException {

        List<BuyerItem> buyerItems = new ArrayList<BuyerItem>();
        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        for(Entity e : entities) {

            String buyerItemStr = JSONUtil.toJsonStr(e);
            BuyerItem buyerItem = JSONUtil.toBean(buyerItemStr,BuyerItem.class);
            buyerItems.add(buyerItem);
        }

        return buyerItems;
    }

    //通过id查找某一行的数据
    public BuyerItem findOneItem(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }

        Entity e = entities.get(0);
        String buyerItemStr = JSONUtil.toJsonStr(e);
        BuyerItem buyerItem = JSONUtil.toBean(buyerItemStr,BuyerItem.class);

        return buyerItem;
    }

    //更新商品标题
    public int updateSkuTitle(String id, String skuTitle) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_TITLE",skuTitle),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    //更新商品介绍
    public int updateSkuIntro(String id, String skuIntro) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_INTRO",skuIntro),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    //更新订单留言备注
    public int updateLeaveComment(String id, String leaveComment) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("LEAVE_COMMENT",leaveComment),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    //更新售价
    public int updateSalePrice(String id, Double salePrice) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRICE",salePrice),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }
    //更新数量
    public int updateQuantity(String id, double quantity) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("QUANTITY",quantity),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    public List<BuyerItem> findBuyerItemByAll(String orderId, String userId, String skuTitle) throws SQLException {
        List<BuyerItem> buyerItems = new ArrayList<BuyerItem>();

        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_ITEM Where ORDER_ID = ? AND USER_ID = ? AND SKU_TITLE LIKE ?",orderId, userId, "%"+skuTitle+"%");
        if (entities.isEmpty()) {
            return null;
        }

        for (Entity e : entities) {
            String itemStr = JSONUtil.toJsonStr(e);
            BuyerItem buyerItem = JSONUtil.toBean(itemStr, BuyerItem.class);
            buyerItems.add(buyerItem);
        }

        return buyerItems;
    }

    /**
     *通过订单ID查找
     */
    public List<BuyerItem> findBuyerItemByOrderId(String orderId) throws SQLException {
        List<BuyerItem> buyerItems = new ArrayList<BuyerItem>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_ITEM Where ORDER_ID = ?", orderId);

        for (Entity e : entities) {
            String buyerItemStr = JSONUtil.toJsonStr(e);
            BuyerItem buyerItem = JSONUtil.toBean(buyerItemStr, BuyerItem.class);
            buyerItems.add(buyerItem);
        }
        return buyerItems;
    }

    /**
     *通过用户ID查找
     */
    public List<BuyerItem> findBuyerItemByUserId(String userId) throws SQLException {
        List<BuyerItem> buyerItems = new ArrayList<BuyerItem>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_ITEM Where USER_ID = ?", userId);

        for (Entity e : entities) {
            String buyerItemStr = JSONUtil.toJsonStr(e);
            BuyerItem buyerItem = JSONUtil.toBean(buyerItemStr, BuyerItem.class);
            buyerItems.add(buyerItem);
        }
        return buyerItems;
    }

    /**
     *通过商品标题查找
     */
    public List<BuyerItem> findBuyerItemBySkuTitle(String skuTitle) throws SQLException {
        List<BuyerItem> buyerItems = new ArrayList<BuyerItem>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_ITEM Where SKU_TITLE LIKE ?", "%"+skuTitle+"%");

        for (Entity e : entities) {
            String buyerItemStr = JSONUtil.toJsonStr(e);
            BuyerItem buyerItem = JSONUtil.toBean(buyerItemStr, BuyerItem.class);
            buyerItems.add(buyerItem);
        }
        return buyerItems;
    }


}
