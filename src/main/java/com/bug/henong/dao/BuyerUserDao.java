package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerItem;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.entity.Farmer;

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
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_USER").set("USER_ID",id)
        );
        return rw;

    }

    /**返回所有信息*/
    public List<BuyerUser> findAll(String userId) throws SQLException {



        List<BuyerUser> buyerUsers = new ArrayList<BuyerUser>();
        List<Entity> entities = Db.use().findAll(Entity.create("BUYER_USER").set("USER_ID", userId));

        if (entities.isEmpty()) {
            return null;
        }

        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerUser buyerUser = JSONUtil.toBean(buyerStr,BuyerUser.class);
            buyerUsers.add(buyerUser);
        }

        return buyerUsers;
    }

    /**
     * 通过当前页数获取buyer信息
     * @param currentPage 当前页数
     * @param pageSize 每页容量
     * @return
     * @throws SQLException
     */
    public List<BuyerUser> findUsersFromTo(int currentPage, int pageSize) throws SQLException {

        List<BuyerUser> buyerUsers = new ArrayList<BuyerUser>();
        //offset:跳offset数值行  limit: 取limit数值行
        int offset = (currentPage - 1)*pageSize;
        int limit = pageSize;
        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_USER ORDER BY USER_ID+0 LIMIT ?,?",offset,limit);

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

        if(entities.isEmpty()){
            return null;
        }
        Entity e =entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerUser buyerUser = JSONUtil.toBean(buyerStr,BuyerUser.class);

        return  buyerUser;
    }

    /**更新姓名*/
    public int updateUserName(String id, String userName) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_NAME",userName),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新昵称*/
    public int updateNickName(String id, String nickName) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("NICK_NAME",nickName),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新签名*/
    public int updateUserIntro(String id, String userIntro) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_INTRO",userIntro),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新头像*/
    public int updateAvatar(String id, String avatar) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("AVATAR",avatar),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新手机号*/
    public int updatePhone(String id, String phone) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PHONE",phone),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新密码*/
    public int updateUserPass(String id, String userPass) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_PASS",userPass),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;

    }
    /**更新密码盐*/
    public int updatePassSalt(String id, String passSalt) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PASS_SALT",passSalt),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;

    }

    /**更新状态*/
    public int updateUserStatus(String id, String userStatus) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("USER_STATUS",userStatus),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;

    }

    /**更新累计消费金额*/
    public int updateTotalCostAmt(String id, Double totalCostAmt) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("TOTAL_COST_AMT",totalCostAmt),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }

    /**更新最后登录时间*/
    public int updateLastLoginTime(String id, Timestamp timestamp) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("LAST_LOGIN_TIME",timestamp),
                Entity.create("BUYER_USER").set("USER_ID",id)
        );

        return rw;
    }
    /**登录*/
    public BuyerUser login(String id, String pass) throws SQLException {
        BuyerUser buyerUser= findOneBuyer(id);
        if(buyerUser!=null){
            String passWord = buyerUser.getUserPass();
            if(passWord.equals(pass)){
                return buyerUser;
            }
        }
        return null;
    }
    /**
     *通过用户ID查找
     */
    public List<BuyerUser> findBuyerUserByUserId(String userId) throws SQLException {
        List<BuyerUser> buyerUsers = new ArrayList<BuyerUser>();
        List<Entity> entities = Db.use().query("SELECT * FROM BUYER_USER Where USER_ID = ?", userId);

        for (Entity e : entities) {
            String buyerUserStr = JSONUtil.toJsonStr(e);
            BuyerUser buyerUser = JSONUtil.toBean(buyerUserStr, BuyerUser.class);
            buyerUsers.add(buyerUser);
        }
        return buyerUsers;
    }
}