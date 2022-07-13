package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.SaleProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Cheng
 * @version 1.0.0
 * @date 22.07.13
 * ddd
 */
public class SaleproductDao {
    /**添加*/
    public int insert(SaleProduct product) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(product);

        int  rw= Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(int id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );
        return rw;

    }
    /**返回所有信息*/
    public List<SaleProduct> findAll() throws SQLException {

        String sql = "SELECT * FROM SALE_PRODUCT";

        List<SaleProduct> saleProducts = new ArrayList<SaleProduct>();
        List<Entity> entities = Db.use().findAll("SALE_PRODUCT");

        for(Entity e : entities){
            String productStr = JSONUtil.toJsonStr(e);
            SaleProduct saleProduct = JSONUtil.toBean(productStr,SaleProduct.class);
            saleProducts.add(saleProduct);
        }

        return saleProducts;
    }
    /**通过id查找某一行数据*/
    public SaleProduct findOneProduct(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        Entity e = entities.get(0);
        String productStr = JSONUtil.toJsonStr(e);
        SaleProduct saleProduct = JSONUtil.toBean(productStr,SaleProduct.class);

        return  saleProduct;
    }

    /**更新标题*/
    public int updateTitle(String title, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("TITLE",title),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新说明*/
    public int updateIntro(String intro, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("INTRO",intro),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新内容*/
    public int updateContent(String content, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("CONTENT",content),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新开始时间*/
    public int updateStart_time(String starttime, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("START_TIME",starttime),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新结束时间*/
    public int updateEnd_time(String endtime, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("END_TIME",endtime),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新范围*/
    public int updateRange(String range, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("RANGE",range),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新类型*/
    public int updateType(String type, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("TYPE",type),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }

    /**更新状态*/
    public int updateStatus(String status, String id) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("STATUS",status),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        return rw;
    }
}