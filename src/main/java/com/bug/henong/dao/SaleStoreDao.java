package com.bug.henong.dao;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng
 * @version 1.0.0
 * @date 22.07.13
 * ddd
 */

public class SaleStoreDao {

    /**添加*/
    public int insert(SaleStore store) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(store);

        int  rw= Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("SALE_STORE").set("STORE_ID",id)
        );
        return rw;

    }
    /**返回所有信息*/
    public List<SaleStore> findAll() throws SQLException {

        String sql = "SELECT * FROM SALE_STORE";

        List<SaleStore> saleStores = new ArrayList<SaleStore>();
        List<Entity> entities = Db.use().findAll("SALE_STORE");

        for(Entity e : entities){
            String storeStr = JSONUtil.toJsonStr(e);
            SaleStore saleStore = JSONUtil.toBean(storeStr,SaleStore.class);
            saleStores.add(saleStore);
        }

        return saleStores;
    }

    /**通过id查找某一行数据*/
    public SaleStore findOneStore(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("SALE_STORE").set("STORE_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }

        Entity e = entities.get(0);
        String storeStr = JSONUtil.toJsonStr(e);
        SaleStore saleStore = JSONUtil.toBean(storeStr,SaleStore.class);

        return  saleStore;
    }

    /**
     * 通过标题查找
     */
    public List<SaleStore> findSaleStoreByTitle(String saleStoreTitle) throws SQLException {
        List<SaleStore> saleStore = new ArrayList<SaleStore>();
        List<Entity> entities = Db.use().query("SELECT * FROM SALE_STORE Where SALE_STORE_TITLE LIKE /'%?%/'", saleStoreTitle);

        for (Entity e : entities) {
            String storeStr = JSONUtil.toJsonStr(e);
            SaleStore saleStore1 = JSONUtil.toBean(storeStr, SaleStore.class);
            saleStore.add(saleStore1);
        }
        return saleStore;
    }

    /**更新标题*/
    public int updateActivityTitle(String activityTitle, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_TITLE",activityTitle),
                Entity.create("SALE_STORE").set("STORE_ID",id)
        );

        return rw;
    }
    /**更新说明*/
    public int updateActivityIntro(String activityIntro, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_INTRO",activityIntro),
                Entity.create("SALE_STORE").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新内容*/
    public int updateActivityContent(String activityContent, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_CONTENT",activityContent),
                Entity.create("SALE_STORE").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新开始时间*/
    public int updateActivityStart_Time(Timestamp activityStartTime, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITYSTART_TIME",activityStartTime),
                Entity.create("SALE_STORE").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新结束时间*/
    public int updateActivityEnd_time(Timestamp activityEndTime, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_END_TIME",activityEndTime),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新范围*/
    public int updateActivityRange(String activityRange, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_RANGE",activityRange),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新类型*/
    public int updateActivityType(String activityType, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_TYPE",activityType),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新状态*/
    public int updateActivity_Status(String activityStatus, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_STATUS",activityStatus),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }

}
