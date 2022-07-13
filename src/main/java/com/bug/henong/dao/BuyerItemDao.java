package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerItem;

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
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );
        return rw;

    }

    //返回所有信息
    public List<BuyerItem> findAll() throws SQLException {

        String sql = "SELECT * FROM BUYER_ITEM";

        List<BuyerItem> buyerItems = new ArrayList<BuyerItem>();
        List<Entity> entities = Db.use().findAll("BUYER_ITEM");

        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerItem buyerItem = JSONUtil.toBean(buyerStr,BuyerItem.class);
            buyerItems.add(buyerItem);
        }

        return buyerItems;
    }

    //通过id查找某一行的数据
    public BuyerItem findOneItem(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        Entity e = entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerItem buyerItem = JSONUtil.toBean(buyerStr,BuyerItem.class);

        return  buyerItem;
    }

    //更新商品标题
    public int updateSkuTitle(String skuTitle, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_TITLE",skuTitle),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    //更新商品介绍
    public int updateSkuIntro(String skuIntro, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_INTRO",skuIntro),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    //更新订单留言备注
    public int updateLeaveComment(String leaveComment, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("LEAVE_COMMENT",leaveComment),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

    //更新售价
    public int updateSalePrice(String salePrice, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRICE",salePrice),
                Entity.create("BUYER_ITEM").set("SKU_ID",id)
        );

        return rw;
    }

}
