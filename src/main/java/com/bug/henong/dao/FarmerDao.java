package com.bug.henong.dao;

import cn.hutool.db.*;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;

/**
 * @author XFishalways
 * @version 1.0.0
 * @date 22.07.13
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FarmerDao {

    /**添加*/
    public int insert(Farmer farmer) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(farmer);

        int rw = Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw = Db.use().del(
                Entity.create("FARMER").set("FARMER_ID", id)
        );
        return rw;
    }

    /**返回所有信息*/
    public List<Farmer> findAll() throws SQLException {

        String sql = "SELECT * FROM FARMER";

        List<Farmer> farmers = new ArrayList<Farmer>();
        List<Entity> entities = Db.use().findAll("FARMER");

        for(Entity e : entities){
            String farmerStr = JSONUtil.toJsonStr(e);
            Farmer farmer = JSONUtil.toBean(farmerStr,Farmer.class);
            farmers.add(farmer);
        }

        return farmers;
    }

    /**通过id查找某一行数据*/
    public Farmer findOneFarmer(String id) throws SQLException {
        List<Entity> entities= Db.use().findAll(
                Entity.create("FARMER").set("id",id)
        );

        Entity e = entities.get(0);
        String farmerStr = JSONUtil.toJsonStr(e);
        Farmer farmer = JSONUtil.toBean(farmerStr,Farmer.class);

        return farmer;
    }

    /**更新所在地**/
    public int updatePlace(String place, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("FARMER_PLACE", place),
                Entity.create("FARMER").set("FARMER_ID", id)
        );

        return rw;
    }

    /**更新资产**/
    public int updateValue(int value, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("FARMER_VALUE", value),
                Entity.create("FARMER").set("FARMER_ID", id)
        );

        return rw;

    }

    /**更新信誉度**/
    public int updateCredibility(String credit, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("FARMER_CREDIBILITY", credit),
                Entity.create("FARMER").set("FARMER_ID", id)
        );

        return rw;

    }

    /**更新所属卖家ID号**/
    public int updateBusinessId(String businessId, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("BUSINESS_ID", businessId),
                Entity.create("FARMER").set("FARMER_ID", id)
        );

        return rw;

    }

    /**更新用户密码**/
    public int updateUserPass(String pass, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_PASS", pass),
                Entity.create("FARMER").set("FARMER_ID", id)
        );

        return rw;

    }

    /**更新密码盐**/
    public int updatePassSalt(String passSalt, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PASS_SALT", passSalt),
                Entity.create("FARMER").set("FARMER_ID", id)
        );

        return rw;

    }
}

