package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Tan
 * @version 1.0.0
 * @date 22.07.13
 */
public class BuyerUserDao {

    /**添加*/
    public int insert(BuyerUser user) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(user);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_USER").set("USER_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<BuyerUser> findAll() throws SQLException {

        String sql = "SELECT * FROM BUYER_USER";

        List<BuyerUser> buyerUsers = new ArrayList<BuyerUser>();
        List<Entity> entities = Db.use().findAll("BUYER_USER");

        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerUser buyerUser = JSONUtil.toBean(buyerStr,BuyerUser.class);
            buyerUsers.add(buyerUser);
        }

        return buyerUsers;
    }

    /**通过id查找某一行数据*/
    public BuyerUser findOneBuyer(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        Entity e = entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerUser buyerUser = JSONUtil.toBean(buyerStr,BuyerUser.class);

        return  buyerUser;
    }

    /**更新昵称*/
    public int updateNickName(String nickName, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("NICK_NAME",nickName),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新签名*/
    public int updateUserIntro(String userIntro, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_INTRO",userIntro),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新头像*/
    public int updateAvatar(String avatar, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("AVATAR",avatar),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新手机号*/
    public int updatePhone(String phone, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PHONE",phone),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新密码*/
    public int updateUserPass(String userPass, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_PASS",userPass),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;

    }
    /**更新密码盐*/
    public int updatePassSalt(String passSalt, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PASS_SALT",passSalt),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;

    }

    /**更新状态*/
    public int updateUserStatus(String userStatus, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_STATUS",userStatus),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;

    }
}