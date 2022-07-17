package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.BuyerUser;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminUserDao {
    /**添加*/
    public int insert(Admin user) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(user);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("ADMIN").set("ADMIN_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<Admin> findAll(String userId) throws SQLException {



        List<Admin> admins = new ArrayList<Admin>();
        List<Entity> entities = Db.use().findAll(Entity.create("ADMIN").set("ADMIN_ID", userId));

        if (entities.isEmpty()) {
            return null;
        }

        for(Entity e : entities){
            String adminStr = JSONUtil.toJsonStr(e);
            Admin admin = JSONUtil.toBean(adminStr,Admin.class);
            admins.add(admin);
        }

        return admins;
    }

    /**通过id查找某一行数据*/
    public Admin findOneAdmin(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("ADMIN").set("ADMIN_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e =entities.get(0);
        String adminStr = JSONUtil.toJsonStr(e);
        Admin admin = JSONUtil.toBean(adminStr,Admin.class);

        return  admin;
    }

    /**更新用户名*/
    public int updateAdminName(String id, String adminName) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_NAME",adminName),
                Entity.create("ADMIN").set("ADMIN_ID",id)
        );

        return rw;
    }

    /**更新密码*/
    public int updatePass(String id, String pass) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_PASSWD",pass),
                Entity.create("ADMIN").set("ADMIN_ID",id)
        );

        return rw;
    }

    /**更新手机号*/
    public int updatePhone(String id, String phone) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_PHONE",phone),
                Entity.create("ADMIN").set("ADMIN_ID",id)
        );

        return rw;
    }
    /**更新密码盐*/
    public int updatePassSalt(String id, String passSalt) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PASS_SALT",passSalt),
                Entity.create("ADMIN").set("ADMIN_ID",id)
        );

        return rw;
    }
}
