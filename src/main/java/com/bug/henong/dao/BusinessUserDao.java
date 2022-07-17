package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessUser;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rui
 * @version 1.0.0
 * @date 22.07.13
 */
public class BusinessUserDao {

    /**添加*/
    public int insert(BusinessUser user) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(user);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );
        return rw;

    }

    /**登录*/
    public BusinessUser login(String id, String pass) throws SQLException {
        BusinessUser businessUser= findOneBusiness(id);
        if(businessUser!=null){
            String passWord = businessUser.getUserPass();
            if(passWord.equals(pass)){
                return businessUser;
            }
        }
        return null;
    }
    /**返回所有信息*/
    public List<BusinessUser> findAll(String userId) throws SQLException {



        List<BusinessUser> businessUsers = new ArrayList<BusinessUser>();
        List<Entity> entities = Db.use().findAll(Entity.create("BUSINESS_USER").set("USER_ID", userId));

        if (entities.isEmpty()) {
            return null;
        }

        for(Entity e : entities){
            String businessStr = JSONUtil.toJsonStr(e);
            BusinessUser businessUser = JSONUtil.toBean(businessStr,BusinessUser.class);
            businessUsers.add(businessUser);
        }

        return businessUsers;
    }

    /**通过id查找某一行数据*/
    public BusinessUser findOneBusiness(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String businessStr = JSONUtil.toJsonStr(e);
        BusinessUser businessUser = JSONUtil.toBean(businessStr,BusinessUser.class);

        return  businessUser;
    }

    /**
     * 通过名字查找
     */
    public List<BusinessUser> findBusinessUserByName(String userName) throws SQLException {
        List<BusinessUser> businessUser = new ArrayList<BusinessUser>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUSINESS_USER Where USER_NAME LIKE ?", "%"+userName+"%");

        for (Entity e : entities) {
            String userStr = JSONUtil.toJsonStr(e);
            BusinessUser businessUser1 = JSONUtil.toBean(userStr, BusinessUser.class);
            businessUser.add(businessUser1);
        }
        return businessUser;
    }

    /**更新昵称*/
    public int updateNickName(String id, String nickName) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("NICK_NAME",nickName),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新签名*/
    public int updateUserIntro(String id, String userIntro) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_INTRO",userIntro),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新头像*/
    public int updateAvatar(String id, String avatar) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("AVATAR",avatar),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新手机号*/
    public int updatePhone(String id, String phone) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PHONE",phone),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新密码*/
    public int updateUserPass(String id, String userPass) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_PASS",userPass),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;

    }
    /**更新密码盐*/
    public int updatePassSalt(String id, String passSalt) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PASS_SALT",passSalt),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;

    }

    /**更新状态*/
    public int updateUserStatus(String id, String userStatus) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_STATUS",userStatus),
                Entity.create("BUSINESS_USER").set("USER_ID",id)
        );

        return rw;

    }

}