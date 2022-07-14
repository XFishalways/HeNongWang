package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BuyerAddress;
import com.bug.henong.entity.BuyerUser;

import javax.sound.midi.Receiver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerAddressDao {
    //添加
    public int insert(BuyerAddress address) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(address);

        int rw = Db.use().insert(entity);

        return  rw;

    }

    //删除
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );
        return rw;

    }

    //返回所有信息
    public List<BuyerAddress> findAll() throws SQLException {

        String sql = "SELECT * FROM BUYER_ADDRESS";

        List<BuyerAddress> buyerAddresses = new ArrayList<BuyerAddress>();
        List<Entity> entities = Db.use().findAll("BUYER_ADDRESS");

        for(Entity e : entities){
            String buyerStr = JSONUtil.toJsonStr(e);
            BuyerAddress buyerAddress = JSONUtil.toBean(buyerStr,BuyerAddress.class);
            buyerAddresses.add(buyerAddress);
        }

        return buyerAddresses;
    }

    //通过id查找某一行数据
    public BuyerAddress findOneAddress(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }
        Entity e = entities.get(0);
        String buyerStr = JSONUtil.toJsonStr(e);
        BuyerAddress buyerAddress = JSONUtil.toBean(buyerStr,BuyerAddress.class);

        return  buyerAddress;
    }

    //更新地址名称
    public int updateAddressName(String addressName, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADDRESS_NAME",addressName),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新收件人姓名
    public int updateReceiverName(String receiverName, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("RECEIVER_NAME", receiverName),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新收件人电话号码
    public int updateReceiverPhone(String receiverPhone, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("RECEIVER_PHONE",receiverPhone),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新省
    public int updateProvince(String province, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PROVINCE",province),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新市
    public int updateCity(String city, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("CITY",city),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新区
    public int updateCounty(String county, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("COUNTY",county),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新街道
    public int updateStreet(String street, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("STREET",street),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新门牌号
    public int updateLastDetail(String lastDetail, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("LAST_DETAIL",lastDetail),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }

    //更新是否默认
    public int updateIsDefault(String isDefault, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("IS_DEFAULT",isDefault),
                Entity.create("BUYER_ADDRESS").set("ADDRESS_ID",id)
        );

        return rw;
    }
}
