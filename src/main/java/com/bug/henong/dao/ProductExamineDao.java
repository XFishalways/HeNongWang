package com.bug.henong.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.bug.henong.entity.ProductExamine;
import com.bug.henong.entity.SaleProduct;
import com.bug.henong.entity.SaleStore;
import com.bug.henong.entity.StoreExamine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Cheng
 * @version 1.0.0
 * @date 22.07.13
 * ddd
 */
public class ProductExamineDao {
    /**添加*/
    public int insert(ProductExamine productExamine) throws SQLException {

        Entity entity = Entity.parseWithUnderlineCase(productExamine);

        int  rw= Db.use().insert(entity);

        return rw;

    }

    /**删除*/
    public int delete(String id) throws SQLException {

        int rw=Db.use().del(
                Entity.create("PRODUCT_EXAMINE").set("PRODUCT_ID",id)
        );
        return rw;

    }
    /**返回所有信息*/
    public List<ProductExamine> findAll() throws SQLException {

        String sql = "SELECT * FROM PRODUCT_EXAMINE";

        List<ProductExamine> productExamines = new ArrayList<ProductExamine>();
        List<Entity> entities = Db.use().findAll("PRODUCT_EXAMINE");

        for(Entity e : entities){
            String productStr = JSONUtil.toJsonStr(e);
            ProductExamine productExamine = JSONUtil.toBean(productStr,ProductExamine.class);
            productExamines.add(productExamine);
        }

        return productExamines;
    }
    /**通过id查找某一行数据*/
    public ProductExamine findOneProduct(String id) throws SQLException {

        List<Entity> entities= Db.use().findAll(
                Entity.create("PRODUCT_EXAMINE").set("PRODUCT_ID",id)
        );

        if(entities.isEmpty()){
            return null;
        }

        Entity e = entities.get(0);
        String productStr = JSONUtil.toJsonStr(e);
        ProductExamine productExamine = JSONUtil.toBean(productStr,ProductExamine.class);

        return  productExamine;
    }

    /**更新审批结果*/
    public int updateProductResult(String id, String productResult) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PRODUCT_RESULT",productResult),
                Entity.create("PRODUCT_EXAMINE").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新审批批注*/
    public int updateProductNote(String id, String productNote) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("PRODUCT_NOTES",productNote),
                Entity.create("PRODUCT_EXAMINE").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**更新审批的管理员Id*/
    public int updateAdminId(String id, String adminId) throws SQLException {

        int rw = Db.use().update(
                Entity.create().set("ADMIN_ID",adminId),
                Entity.create("PRODUCT_EXAMINE").set("PRODUCT_ID",id)
        );

        return rw;
    }
    /**通过商品名查找*/
    public List<ProductExamine> findProductsByProductName(String productName) throws SQLException {

        String sql = "SELECT * FROM PRODUCT_EXAMINE JOIN GOODS ON GOODS_ID = PRODUCT_ID WHERE GOODS.GOODS_NAME = ?";

        List<ProductExamine> productExamines = new ArrayList<ProductExamine>();
        List<Entity> entities = Db.use().query("SELECT * FROM PRODUCT_EXAMINE JOIN GOODS ON GOODS_ID = PRODUCT_ID WHERE GOODS.GOODS_NAME = ?", "%"+productName+"%");

        for(Entity e : entities){
            String productStr = JSONUtil.toJsonStr(e);
            ProductExamine productExamine = JSONUtil.toBean(productStr,ProductExamine.class);
            productExamines.add(productExamine);
        }

        return productExamines;
    }

}
