package com.bug.henong.service;

import com.bug.henong.dao.StoreExamineDao;
import com.bug.henong.entity.ProductExamine;
import com.bug.henong.entity.StoreExamine;
import org.springframework.stereotype.Service;


import java.sql.SQLException;

@Service("StoreExamineService")
public class StoreExamineService {

    private StoreExamineDao storeExamineDao =new StoreExamineDao();

    /**
     * 得到商品活动ID信息
     */
    public StoreExamine getStoreId(String loginStoreId) throws SQLException {
        return storeExamineDao.findOneStore(loginStoreId);
    }

    /**
     * 修改店铺审批结果
     */
    public Boolean updateStoreResult(String loginStoreId, String newStoreResult) throws SQLException {
        StoreExamine storeExamine = storeExamineDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (storeExamine != null) {
                  int rw = storeExamineDao.updateStoreResult(newStoreResult,loginStoreId);
                return rw > 0;
        }

        return false;
    }

    /**
     * 修改店铺审批批注
     */
    public Boolean updateStoreNote(String loginStoreId, String newStoreNote) throws SQLException {
        StoreExamine storeExamine = storeExamineDao.findOneStore(loginStoreId);

        //当前用户非空才可以进行更改
        if (storeExamine != null) {
                 int rw = storeExamineDao.updateStoreNote(newStoreNote,loginStoreId);
                return rw > 0;
        }

        return false;
    }


}
