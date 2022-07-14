package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rui
 * @version 1.0.0
 * @date 22.07.13
 */
public class BusinessAddressDao {

    /**添加*/
    public int insert(BusinessAddress address) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(address);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<BusinessAddress> findAll() throws SQLException {

        String sql = "SELECT * FROM BUSINESS_ADDRESS";

        List<BusinessAddress> businessAddresses = new ArrayList<BusinessAddress>();
        List<Entity> entities = Db.use().findAll("BUSINESS_ADDRESS");

        for(Entity e : entities){
            String addressStr = JSONUtil.toJsonStr(e);
            BusinessAddress businessAddress = JSONUtil.toBean(addressStr,BusinessAddress.class);
            businessAddresses.add(businessAddress);
        }

        return businessAddresses;
    }

    /**通过id查找某一行数据*/
    public BusinessAddress findOneAddress(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e =entities.get(0);
        String addressStr = JSONUtil.toJsonStr(e);
        BusinessAddress businessAddress = JSONUtil.toBean(addressStr,BusinessAddress.class);

        return  businessAddress;
    }

    /**更新地址名称*/
    public int updateAddressName(String addressName, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADDRESS_NAME",addressName),
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    /**更新省*/
    public int updateProvince(String province, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PROVINCE",province),
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    /**更新市*/
    public int updateCity(String city, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("CITY",city),
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    /**更新区*/
    public int updateCounty(String county, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("COUNTY",county),
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    /**更新街道*/
    public int updateStreet(String street, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("STREET",street),
                Entity.create("BUSINESS_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;

    }

}