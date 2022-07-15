package com.bug.henong.service;

import com.bug.henong.dao.GoodsDao;
import com.bug.henong.dao.ProductExamineDao;
import com.bug.henong.entity.Goods;
import com.bug.henong.entity.ProductExamine;


import java.sql.SQLException;
public class ProductExamineService {



    private ProductExamineDao productExamineDao = new ProductExamineDao();


    /**
     * 得到商品活动ID信息
     */
    public ProductExamine getProductId(String loginProductId) throws SQLException {
        return productExamineDao.findOneProduct(loginProductId);
    }

    /**
     * 修改商品审批结果
     */
    public Boolean updateProductResult(String loginProductId, String newProductResult) throws SQLException {
        ProductExamine productExamine = productExamineDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (productExamine != null) {
                int rw = productExamineDao.updateProductResult(newProductResult,loginProductId);
                return rw > 0;

        }

        return false;
    }


    /**
     * 修改商品审批批注
     */
    public Boolean updateProductNote(String loginProductId, String newProductNote) throws SQLException {
        ProductExamine productExamine = productExamineDao.findOneProduct(loginProductId);

        //当前用户非空才可以进行更改
        if (productExamine != null) {
                int rw = productExamineDao.updateProductNote(newProductNote,loginProductId);
                return rw > 0;
        }

        return false;
    }


}
