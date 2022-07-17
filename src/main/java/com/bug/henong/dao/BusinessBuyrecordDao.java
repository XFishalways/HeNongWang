package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessBuyrecord;
import com.bug.henong.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rui
 * @version 1.0.0
 * @date 22.07.13
 */
public class BusinessBuyrecordDao {

    /**添加*/
    public int insert(BusinessBuyrecord businessBuyrecord) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(businessBuyrecord);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUSINESS_BUYRECORD").set("RECORD_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<BusinessBuyrecord> findAll() throws SQLException {

        String sql = "SELECT * FROM BUSINESS_BUYRECORD";

        List<BusinessBuyrecord> businessBuyrecords = new ArrayList<>();
        List<Entity> entities = Db.use().findAll("BUSINESS_BUYRECORD");

        for(Entity e : entities){
            String recordStr = JSONUtil.toJsonStr(e);
            BusinessBuyrecord businessBuyrecord = JSONUtil.toBean(recordStr,BusinessBuyrecord.class);
            businessBuyrecords.add(businessBuyrecord);
        }

        return businessBuyrecords;
    }

    /**通过id查找某一行数据*/
    public BusinessBuyrecord findOneRecord(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUSINESS_BUYRECORD").set("RECORD_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String recordStr = JSONUtil.toJsonStr(e);
        BusinessBuyrecord businessBuyrecord = JSONUtil.toBean(recordStr,BusinessBuyrecord.class);

        return  businessBuyrecord;
    }

    /**通过卖家ID找数据*/
    public List<BusinessBuyrecord> findRecordsByBusinessId(String businessId) throws SQLException {
        List<BusinessBuyrecord> businessBuyrecords = new ArrayList<BusinessBuyrecord>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_BUYRECORD Where USER_ID = ?", businessId);

        for (Entity e : entities) {
            String recordStr = JSONUtil.toJsonStr(e);
            BusinessBuyrecord businessBuyrecord = JSONUtil.toBean(recordStr,BusinessBuyrecord.class);
            businessBuyrecords.add(businessBuyrecord);
        }
        return businessBuyrecords;
    }
    /**通过卖家ID和农户名字查找数据*/
    public List<BusinessBuyrecord> findRecordsByBusinessIdAndFarmerName(String businessId,String farmerName) throws SQLException {
        List<BusinessBuyrecord> businessBuyrecords = new ArrayList<BusinessBuyrecord>();
        List<Entity> entities = Db.use().query("SELECT * FROM business_buyrecord JOIN farmer ON business_buyrecord.FARMER_ID = farmer.FARMER_ID WHERE business_buyrecord.user_id = ? AND farmer.FARMER_NAME LIKE ? ",businessId,"%"+farmerName+"%");

        for (Entity e : entities) {
            String recordStr = JSONUtil.toJsonStr(e);
            BusinessBuyrecord businessBuyrecord = JSONUtil.toBean(recordStr,BusinessBuyrecord.class);
            businessBuyrecords.add(businessBuyrecord);
        }
        return businessBuyrecords;
    }
    /**通过商品Id找数据*/
    public BusinessBuyrecord findRecordsBySkuId(String skuId) throws SQLException {

        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_BUYRECORD Where SKU_ID = ?", skuId);
        if(entities.isEmpty()){
            return null;
        }

        Entity e = entities.get(0);
        String recordStr = JSONUtil.toJsonStr(e);
        BusinessBuyrecord businessBuyrecord = JSONUtil.toBean(recordStr,BusinessBuyrecord.class);

        return  businessBuyrecord;
    }
    /**
     *修改账单状态
     */
    public int updateSkuStatus(String id, String status) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SKU_STATUS",status),
                Entity.create("BUSINESS_BUYRECORD").set("RECORD_ID",id)
        );

        return rw;
    }
    /**
     * 修改地址ID
     */
    public int updateAddressId(String id, String addressId) throws SQLException {
        int rw = Db.use().update(
                Entity.create().set("SKU_STATUS",addressId),
                Entity.create("BUSINESS_BUYRECORD").set("RECORD_ID",id)
        );

        return rw;
    }

    public int updateRrcordStatus(String id, String recordStatus) throws SQLException {
        int rw = Db.use().update(
                Entity.create().set("RECORD_STATUS",recordStatus),
                Entity.create("BUSINESS_BUYRECORD").set("RECORD_ID",id)
        );

        return rw;
    }
}