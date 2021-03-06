package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.BusinessItem;
import com.bug.henong.entity.SaleProduct;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Cheng
 * @version 1.0.0
 * @date 22.07.13
 * ddd
 */
public class SaleProductDao {
    /**添加*/
    public int insert(SaleProduct product) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(product);

        int  rw= Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );
        return rw;

    }
    /**返回所有信息*/
    public List<SaleProduct> findAll(String adminId) throws SQLException {

        String sql = "SELECT * FROM SALE_PRODUCT";

        List<SaleProduct> saleProducts = new ArrayList<SaleProduct>();
        List<Entity> entities = Db.use().findAll(Entity.create("SALE_PRODUCT").set("ADMIN_ID",adminId));

        for(Entity e : entities){
            String productStr = JSONUtil.toJsonStr(e);
            SaleProduct saleProduct = JSONUtil.toBean(productStr,SaleProduct.class);
            saleProducts.add(saleProduct);
        }

        return saleProducts;
    }
    /**通过id查找某一行数据*/
    public SaleProduct findOneProductByTitle(String saleProductTitle) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_TITLE",saleProductTitle)
        );

        if(entities.isEmpty()){
            return null;
        }

        Entity e = entities.get(0);
        String productStr = JSONUtil.toJsonStr(e);
        SaleProduct saleProduct = JSONUtil.toBean(productStr,SaleProduct.class);

        return  saleProduct;
    }

    public SaleProduct findOneProductById(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }

        Entity e = entities.get(0);
        String productStr = JSONUtil.toJsonStr(e);
        SaleProduct saleProduct = JSONUtil.toBean(productStr,SaleProduct.class);

        return  saleProduct;
    }

    /**
     *通过
     */
    public List<SaleProduct> findSaleProductByTitle(String adminId) throws SQLException {
        List<SaleProduct> saleProduct = new ArrayList<SaleProduct>();
        List<Entity> entities = Db.use().query("SELECT * FROM SALE_PRODUCT Where ADMIN_ID LIKE ?", "%"+adminId+"%");

        for (Entity e : entities) {
            String productStr = JSONUtil.toJsonStr(e);
            SaleProduct saleProduct1 = JSONUtil.toBean(productStr, SaleProduct.class);
            saleProduct.add(saleProduct1);
        }
        return saleProduct;
    }

    /**更新标题*/
    public int updateTitle( String Title, String title) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_TITLE",title),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }

    /**更新说明*/
    public int updateIntro( String Title, String intro) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_INTRO",intro),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }

    /**更新内容*/
    public int updateContent(String Title, String content) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_CONTENT",content),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }
    /**更新开始时间*/
    public int updateStart_time(String Title, Timestamp startTime) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_START_TIME",startTime),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }

    /**更新结束时间*/
    public int updateEnd_time(String Title, Timestamp endTime) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_END_TIME",endTime),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }

    /**更新范围*/
    public int updateRange( String Title, String range) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_RANGE",range),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }

    /**更新类型*/
    public int updateType( String Title,String type) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_TYPE",type),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }

    /**更新状态*/
    public int updateStatus(String Title, String status) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("SALE_PRODUCT_STATUS",status),
                Entity.create("SALE_PRODUCT").set("SALE_PRODUCT_ID",Title)
        );

        return rw;
    }
}
