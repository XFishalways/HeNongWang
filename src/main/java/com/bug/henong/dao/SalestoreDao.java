package com.bug.henong.dao;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng
 * @version 1.0.0
 * @date 22.07.13
 * ddd
 */

public class SalestoreDao {

    /**添加*/
    public int insert(SaleStore store) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(store);

        int  rw= Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

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

    /**更新标题*/
    public int updateActivityTitle(String activity_title, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_TITLE",activity_title),
                Entity.create("SALE_STORE").set("STORE_ID",id)
        );

        return rw;
    }
    /**更新说明*/
    public int updateActivityIntro(String activity_intro, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_INTRO",activity_intro),
                Entity.create("SALE_STORE").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新内容*/
    public int updateActivityContent(String activity_content, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_CONTENT",activity_content),
                Entity.create("SALE_STORE").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新开始时间*/
    public int updateActivityStart_Time(String activity_start_time, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITYSTART_TIME",activity_start_time),
                Entity.create("SALE_STORE").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新结束时间*/
    public int updateActivityEnd_time(String activity_end_time, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_END_TIME",activity_end_time),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新范围*/
    public int updateActivityRange(String activity_range, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_RANGE",activity_range),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新类型*/
    public int updateActivityType(String activity_type, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_TYPE",activity_type),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新状态*/
    public int updateActivity_Status(String activity_status, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ACTIVITY_STATUS",activity_status),
                Entity.create("SALE_PRODUCT").set("PRODUCT_ID",id)
        );

        return rw;
    }

}
