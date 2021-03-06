package com.bug.henong.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.BusinessAddressDao;
import com.bug.henong.entity.BusinessAddress;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service("BusinessAddressService")
public class BusinessAddressService {

    private BusinessAddressDao businessAddressDao =new BusinessAddressDao();

    /**
     * 得到所有商品地址信息
     */
    public List<BusinessAddress> getBusinessAddressDetailById(String userId) throws SQLException {
        return businessAddressDao.findAll(userId);
    }

    /**
     * 得到一个商品信息title
     */
    public BusinessAddress findOneAddressDetailByTitle(String addressTitle) throws SQLException{
        return businessAddressDao.findOneAddress(addressTitle);
    }

    /**
     * 得到一个商品信息id
     */
    public BusinessAddress findOneAddress(String addressId) throws SQLException{
        return businessAddressDao.findOneAddress(addressId);
    }

    /**修改地址名称*/
    public Boolean updateAddress(String addressId, String newAddress) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
                int rw = businessAddressDao.updateAddressName(addressId, newAddress);
                return rw > 0;


        }

        return false;
    }


    /**修改省*/
    public Boolean updateProvince(String addressId, String newProvince) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
                int rw = businessAddressDao.updateProvince(addressId, newProvince);
                return rw > 0;


        }

        return false;
    }

    /**修改市*/
    public Boolean updateCity(String addressId, String newCity) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {

                int rw = businessAddressDao.updateCity(addressId, newCity);
                return rw > 0;

        }

        return false;
    }

    /**修改区*/
    public Boolean updateCounty(String addressId,String newCounty) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {

                int rw = businessAddressDao.updateCounty(addressId, newCounty);
                return rw > 0;


        }

        return false;
    }

    /**修改街道*/
    public Boolean updateStreet(String addressId,  String newStreet) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {

                int rw = businessAddressDao.updateStreet(addressId, newStreet);
                return rw > 0;


        }

        return false;
    }

    /**修改门牌号*/
    public Boolean updateLastDetail(String addressId, String newLastDetail) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {

                int rw = businessAddressDao.updateLastDetail(addressId, newLastDetail);
                return rw > 0;


        }

        return false;
    }

    public int update(String addressId, String addressName, String province, String city,
                      String county, String street, String lastDetail, String isDefault, String userId) throws SQLException{

        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        if(businessAddress == null){
            return 0;
        }
        if(!businessAddress.getAddressName().equals(addressId)){
            businessAddressDao.updateAddressName(addressId, addressName);
        }
        if(!businessAddress.getProvince().equals(province)){
            businessAddressDao.updateProvince(addressId, province);
        }
        if(!businessAddress.getCity().equals(city)){
            businessAddressDao.updateCity(addressId, city);
        }
        if(!businessAddress.getCounty().equals(county)){
            businessAddressDao.updateCounty(addressId, county);
        }
        if(!businessAddress.getStreet().equals(street)){
            businessAddressDao.updateStreet(addressId, street);
        }
        if(!businessAddress.getLastDetail().equals(lastDetail)){
            businessAddressDao.updateLastDetail(addressId, lastDetail);
        }
        if(!businessAddress.getIsDefault().equals(isDefault)){
            businessAddressDao.updateIsDefault(addressId, isDefault);
        }
        if(!businessAddress.getUserId().equals(userId)){
            businessAddressDao.updateIsDefault(addressId, userId);
        }
        return 1;

    }

    public int Insert(String addressName, String province, String city, String county, String street,
                      String lastDetail, String isDefault, String userId) throws SQLException{

        BusinessAddress businessAddress = new BusinessAddress();

        Snowflake snowflake = IdUtil.getSnowflake(3, 1);
        String businessAddressId = snowflake.nextIdStr();

        businessAddress.setAddressId(businessAddressId);

        businessAddress.setAddressName(addressName);
        businessAddress.setProvince(province);
        businessAddress.setCity(city);
        businessAddress.setCounty(county);
        businessAddress.setStreet(street);
        businessAddress.setLastDetail(lastDetail);
        businessAddress.setIsDefault(isDefault);
        businessAddress.setUserId(userId);

        return businessAddressDao.insert(businessAddress);

    }
    public void deleteAddress(String addressId) throws SQLException {

        businessAddressDao.delete(addressId);

    }
}
