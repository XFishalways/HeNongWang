package com.bug.henong.service;

import com.bug.henong.dao.BusinessAddressDao;
import com.bug.henong.dao.BusinessBuyrecordDao;
import com.bug.henong.dao.GoodsDao;
import com.bug.henong.dao.ProductExamineDao;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BusinessBuyrecord;
import com.bug.henong.entity.Farmer;
import com.bug.henong.entity.ProductExamine;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("BusinessBuyerRecordService")
public class BusinessBuyRecordService {
    private BusinessBuyrecordDao businessBuyrecordDao =new BusinessBuyrecordDao();

    /**得到收购记录信息*/
    public BusinessBuyrecord getBuyRecordById(String id) throws SQLException {
        return businessBuyrecordDao.findOneRecord(id);
    }

    /**通过卖家id得到记录信息*/
    public List<BusinessBuyrecord> getBuyRecordByByBusinessId(String businessId) throws SQLException {
        return businessBuyrecordDao.findRecordsByBusinessId(businessId);
    }

    /**确认收购*/
    public Boolean confirmRecord(String id,String addressId) throws SQLException {
       if(addressId==null){
           return false;
       }
        businessBuyrecordDao.updateAddressId(id,addressId);
       BusinessBuyrecord businessBuyrecord = businessBuyrecordDao.findOneRecord(id);
        ProductExamine productExamine = new ProductExamine();
        productExamine.setProductId(businessBuyrecord.getSkuId());
        ProductExamineDao productExamineDao = new ProductExamineDao();
        productExamine.setProductNotes("non-examined");

        int result =productExamineDao.insert(productExamine);

        if(result>0){
            return true;
        }else{
            return false;
        }
    }
    /**否认收购*/
    public Boolean denyRecord(String id) throws SQLException {
        BusinessBuyrecord businessBuyrecord = businessBuyrecordDao.findOneRecord(id);

        String goodsId = businessBuyrecord.getSkuId();
        GoodsDao goodsDao =new GoodsDao();
        int rw =goodsDao.updatePass(goodsId,"false");
        if(rw==0){
            return false;
        }
        int result = businessBuyrecordDao.delete(id);
        if(result==0){
            return false;
        }else{
            return true;
        }
    }

    /**得到当前用户所有地址Id*/
    public List<String> getAddressByBusinessId(String businessId) throws SQLException {
        BusinessAddressDao businessAddressDao =new BusinessAddressDao();
        List<BusinessAddress>businessAddresses=businessAddressDao.findAddressByBusinessId(businessId);
        if(businessAddresses.isEmpty()){
            return null;
        }
        List<String> businessAddressIds=new ArrayList<String>();
        for(BusinessAddress businessAddress :businessAddresses){
            String id =businessAddress.getAddressId();
            businessAddressIds.add(id);
        }
        return businessAddressIds;
    }
    /**通过农户名字查找记录*/
    public List<BusinessBuyrecord> getBusinessBuyRecordByFarmerName(String businessId,String farmerName) throws SQLException {
        List<BusinessBuyrecord> businessBuyrecords = businessBuyrecordDao.findRecordsByBusinessIdAndFarmerName(businessId,farmerName);
        if(businessBuyrecords.isEmpty()){
            return null;
        }else{
            return businessBuyrecords;
        }

    }
}