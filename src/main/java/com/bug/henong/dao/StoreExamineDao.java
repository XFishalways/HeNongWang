package com.bug.henong.dao;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;
import com.bug.henong.entity.StoreExamine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Cheng
 * @version 1.0.0
 * @date 22.07.13
 * ddd
 */
public class StoreExamineDao {
    /**添加*/
    public int insert(SaleStore store) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(store);

        int  rw= Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("STORE_EXAMINE").set("STORE_ID",id)
        );
        return rw;

    }
    /**返回所有信息*/
    public List<StoreExamine> findAll() throws SQLException {

        String sql = "SELECT * FROM STORE_EXAMINE";

        List<StoreExamine> storeExamines = new ArrayList<StoreExamine>();
        List<Entity> entities = Db.use().findAll("STORE_EXAMINE");

        for(Entity e : entities){
            String storeStr = JSONUtil.toJsonStr(e);
            StoreExamine storeExamine = JSONUtil.toBean(storeStr,StoreExamine.class);
            storeExamines.add(storeExamine);
        }

        return storeExamines;
    }
    /**通过id查找某一行数据*/
    public StoreExamine findOneStore(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("STORE_EXAMINE").set("STORE_ID",id)
        );

        Entity e = entities.get(0);
        String storeStr = JSONUtil.toJsonStr(e);
        StoreExamine storeExamine = JSONUtil.toBean(storeStr,StoreExamine.class);

        return  storeExamine;
    }

    /**更新审批结果*/
    public int updateStoreResult(String store_result, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("STORE_RESULT",store_result),
                Entity.create("STORE_EXAMINE").set("STORE_ID",id)
        );

        return rw;
    }
    /**更新审批批注*/
    public int updateStoreNote(String store_note, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("STORE_Note",store_note),
                Entity.create("STORE_EXAMINE").set("STORE_ID",id)
        );

        return rw;
    }


}
