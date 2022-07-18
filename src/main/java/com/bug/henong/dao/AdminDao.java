package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Admin;
import com.bug.henong.entity.Farmer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author xiahaolin
 * @version 1.0.0
 * @date 22.07.13
 */
public class AdminDao {

    /**
     * 添加
     */
    public int insert(Admin user) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(user);

        int rw = Db.use().insert(entity);

        return rw;

    }

    /**
     * 删除
     */
    public int delete(String id) throws SQLException {

        int rw = Db.use().del(
                Entity.create("ADMIN").set("Admin_ID", id)
        );
        return rw;

    }

    /**
     * 返回所有信息
     */
    public List<Admin> findAll() throws SQLException {

        String sql = "SELECT * FROM ADMIN";

        List<Admin> admins = new ArrayList<Admin>();
        List<Entity> entities = Db.use().findAll("ADMIN");

        for (Entity e : entities) {
            String adminStr = JSONUtil.toJsonStr(e);
            Admin admin = JSONUtil.toBean(adminStr, Admin.class);
            //admins.add(admin);
        }

        return admins;
    }

    /**
     * 通过id查找某一行数据
     */
    public Admin findOneAdmin(String id) throws SQLException {

        List<Entity> entities = Db.use().findAll(
                Entity.create("ADMIN").set("ADMIN_ID", id)
        );
        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String adminStr = JSONUtil.toJsonStr(e);
        Admin adminUser = JSONUtil.toBean(adminStr, Admin.class);

        return adminUser;
    }

    /**通过id查找农户密码盐*/
    public String getAdminPassSalt(String adminID) throws SQLException {
        return findOneAdmin(adminID).getPassSalt();
    }
    /**登录*/
    public Admin login(String id, String pass) throws SQLException {
        Admin admin = findOneAdmin(id);
        if(admin!=null){
            String passWord = admin.getAdminPasswd();
            if(passWord.equals(pass)){
                return admin;
            }
        }
        return null;
    }

    /**
     * 更新用户名
     */
    public int updateName( String id,String name) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_NAME", name),
                Entity.create("ADMIN").set("ADMIN_ID", id)
        );

        return rw;
    }


    /**
     * 更新密码
     */
    public int updatePass(String id ,String passwd) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_PASSWD", passwd),
                Entity.create("ADMIN").set("ADMIN_ID", id)
        );

        return rw;
    }

    /**
     * 更新手机号
     */
    public int updatePhone(String id, String phone) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_PASSWORD", phone),
                Entity.create("ADMIN").set("ADMIN_ID", id)
        );

        return rw;

    }

    /**
     * 更新密码盐
     */
    public int updatePassSalt(String id, String passSalt) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PASS_SALT", passSalt),
                Entity.create("ADMIN").set("ADMIN_ID", id)
        );

        return rw;

    }
}