package com.bug.henong.service;

import com.bug.henong.dao.BusinessBuyrecordDao;
import com.bug.henong.dao.BusinessItemDao;
import com.bug.henong.dao.GoodsDao;
import com.bug.henong.dao.ProductExamineDao;
import com.bug.henong.entity.BusinessBuyrecord;
import com.bug.henong.entity.BusinessItem;
import com.bug.henong.entity.Goods;
import com.bug.henong.entity.ProductExamine;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service("ProductExamineService")
public class ProductExamineService {

    private ProductExamineDao productExamineDao = new ProductExamineDao();


    /**得到所有商品审核信息*/
    public List<ProductExamine> getAll() throws SQLException {
        return  productExamineDao.findAll();

    }
    /**通过名字查找审核*/
    public List<ProductExamine> getProductExaminesByProductName(String productName) throws SQLException {
        return productExamineDao.findProductsByProductName(productName);
    }
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
                int rw = productExamineDao.updateProductResult(loginProductId,newProductResult);
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

    /**确认通过审核*/
    public Boolean confirmProduct(String loginProductId,String adminId,String productNotes) throws SQLException {
        productExamineDao.updateAdminId(loginProductId, adminId);
        productExamineDao.updateProductNote(loginProductId,productNotes);
        Boolean rs= updateProductResult(loginProductId,"pass");
        if(rs==false){
            return false;
        }else{
            BusinessBuyrecordDao businessBuyrecordDao =new BusinessBuyrecordDao();
            BusinessBuyrecord businessBuyrecord = businessBuyrecordDao.findRecordsBySkuId(loginProductId);

            if(businessBuyrecord==null){
                return false;
            }else {
                String id =businessBuyrecord.getRecordId();

                businessBuyrecordDao.updateSkuStatus(id,"pass");

                GoodsDao goodsDao= new GoodsDao();
                String goodsId= businessBuyrecord.getSkuId();
                int result =goodsDao.updatePass(goodsId,"pass");

                if(result<=0){
                    return false;
                }
                Goods goods = goodsDao.findOneGoods(goodsId);

                BusinessItem businessItem = new BusinessItem();
                businessItem.setSkuId(goodsId);
                businessItem.setFarmerId(goods.getFarmerId());
                businessItem.setUserId(businessBuyrecord.getUserId());
                businessItem.setQuantity(goods.getGoodsQuantity());
                businessItem.setSkuStatus("offsale");
                businessItem.setSalePrice(goods.getGoodsPrice());
                businessItem.setQuantity(goods.getGoodsQuantity());

                BusinessItemDao businessItemDao = new BusinessItemDao();
                businessItemDao.insert(businessItem);
                return true;
            }

        }
    }

    /**拒绝通过审核*/
    public Boolean denyProduct(String loginProductId,String adminId,String productNotes) throws SQLException {
        productExamineDao.updateAdminId(loginProductId, adminId);
        productExamineDao.updateProductNote(loginProductId,productNotes);
        Boolean rs= updateProductResult(loginProductId,"refused");
        if(rs==false){
            return false;
        }else{

            BusinessBuyrecordDao businessBuyrecordDao =new BusinessBuyrecordDao();
            BusinessBuyrecord businessBuyrecord = businessBuyrecordDao.findRecordsBySkuId(loginProductId);

            if(businessBuyrecord==null){
                return false;
            }else {
                String id =businessBuyrecord.getRecordId();

                businessBuyrecordDao.updateSkuStatus(id,"refused");

                GoodsDao goodsDao= new GoodsDao();
                int result =goodsDao.updatePass(id,"refused");
                if(result<=0){
                    return false;
                }
                return true;
            }
        }
    }

}
