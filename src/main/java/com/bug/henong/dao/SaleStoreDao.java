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
                Entity.create("SALE_STORE").set("STOREID",id)
        );
        return rw;

    }
    /**返回所有信息*/
    public List<SaleStore> findAll(String adminId) throws SQLException {



        List<SaleStore> saleStores = new ArrayList<SaleStore>();
        List<Entity> entities = Db.use().findAll(Entity.create("SALE_STORE").set("ADMIN_ID", adminId));

        if (entities.isEmpty()) {
            return null;
        }

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
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
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
        List<Entity> entities = Db.use().query("SELECT * FROM SALE_STORE Where SALE_STORE_TITLE LIKE ?", "%"+saleStoreTitle+"%");

        for (Entity e : entities) {
            String storeStr = JSONUtil.toJsonStr(e);
            SaleStore saleStore1 = JSONUtil.toBean(storeStr, SaleStore.class);
            saleStore.add(saleStore1);
        }
        return saleStore;
    }

    /**更新标题*/
    public int updateActivityTitle(String id, String activityTitle) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_TITLE",activityTitle),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }
    /**更新说明*/
    public int updateActivityIntro(String id, String activityIntro) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_INTRO",activityIntro),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }

    /**更新内容*/
    public int updateActivityContent(String id, String activityContent) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_CONTENT",activityContent),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }

    /**更新开始时间*/
    public int updateActivityStart_Time(String id, Timestamp activityStartTime) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_START_TIME",activityStartTime),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }

    /**更新结束时间*/
    public int updateActivityEnd_time(String id, Timestamp activityEndTime) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_END_TIME",activityEndTime),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }

    /**更新范围*/
    public int updateActivityRange(String id, String activityRange) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_RANGE",activityRange),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }
    /**更新类型*/
    public int updateActivityType(String id, String activityType) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_TYPE",activityType),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }
    /**更新状态*/
    public int updateActivity_Status(String id, String activityStatus) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_STORE_STATUS",activityStatus),
                Entity.create("SALE_STORE").set("SALE_STOREID",id)
        );

        return rw;
    }

}
