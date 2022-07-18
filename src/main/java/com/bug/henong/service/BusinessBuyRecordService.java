package com.bug.henong.service;

import com.bug.henong.dao.*;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BusinessBuyrecord;
import com.bug.henong.entity.Farmer;
import com.bug.henong.entity.ProductExamine;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        productExamine.setProductResult("non-examined");
        productExamine.setAdminId("0");
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
        int rw =goodsDao.updatePass(goodsId,"refused");
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
    public Map<String,String> getAddressByBusinessId(String businessId) throws SQLException {
        BusinessAddressDao businessAddressDao =new BusinessAddressDao();
        List<BusinessAddress>businessAddresses=businessAddressDao.findAddressByBusinessId(businessId);
        if(businessAddresses.isEmpty()){
            return null;
        }
        int i=1;
        Map<String ,String>map = new HashMap<>();
        List<String> businessAddressIds=new ArrayList<String>();
        for(BusinessAddress businessAddress :businessAddresses){
            String id =businessAddress.getAddressId();
            map.put("address"+i,id);
        }
        return map;
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

    /**
     * 通过农户id查找农户
     */
    public List<BusinessBuyrecord> findFarmerById(String farmerId) throws SQLException{
        List<BusinessBuyrecord> businessBuyrecords = businessBuyrecordDao.findFarmerByFarmerId(farmerId);
        if(businessBuyrecords.isEmpty()){
            return null;
        }else{
            return businessBuyrecords;
        }
    }
    /**查找商家所有所属农户*/
    public List<Farmer> findFarmers(String userId) throws SQLException {
        FarmerDao farmerDao = new FarmerDao();
        List<Farmer> farmers = farmerDao.findFarmersByBusinessId(userId);
        if(farmers.isEmpty()){
            return null;
        }else {
            return farmers;
        }
    }
    /**通过名字查找农户*/
    public List<Farmer> findFarmerByName(String userId,String name) throws SQLException {
        FarmerDao farmerDao = new FarmerDao();
        List<Farmer>farmers = farmerDao.findFarmersByNameAndBusinessId(userId,name);
        if(farmers.isEmpty()){
            return null;
        }else {
            return farmers;
        }
    }
}