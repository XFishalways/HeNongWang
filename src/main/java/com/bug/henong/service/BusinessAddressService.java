package com.bug.henong.service;

import com.bug.henong.dao.BusinessAddressDao;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.Farmer;
import org.springframework.stereotype.Service;


import java.sql.SQLException;

@Service("BusinessAddressService")
public class BusinessAddressService {

    private BusinessAddressDao businessAddressDao =new BusinessAddressDao();

    /**得到商品地址信息*/
    public BusinessAddress getBusinessAddressDetailById(String addressId) throws SQLException {
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
                      String county, String street, String lastDetail, String isDefault) throws SQLException{

        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        if(businessAddress == null){
            return 0;
        }
        if(!businessAddress.getAddressName().equals(addressId)){
            updateAddress((String) addressId, addressName);
        }
        if(!businessAddress.getProvince().equals(province)){
            updateProvince((String) addressId, province);
        }
        if(!businessAddress.getCity().equals(city)){
            updateCity((String) addressId, city);
        }
        if(!businessAddress.getCounty().equals(county)){
            updateCounty((String) addressId, county);
        }
        if(!businessAddress.getStreet().equals(street)){
            updateStreet((String) addressId, street);
        }
        if(!businessAddress.getLastDetail().equals(lastDetail)){
            updateLastDetail((String) addressId, lastDetail);
        }   if(!businessAddress.getIsDefault().equals(isDefault)){

        }
        return 1;

    }

}
