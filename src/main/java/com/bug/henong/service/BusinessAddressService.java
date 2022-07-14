package com.bug.henong.service;

import com.bug.henong.dao.BusinessAddressDao;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.Farmer;


import java.sql.SQLException;

public class BusinessAddressService {

    private BusinessAddressDao businessAddressDao;

    /**得到商品地址信息*/
    public BusinessAddress getBusinessAddressDetailById(String addressId) throws SQLException {
        return businessAddressDao.findOneAddress(addressId);
    }

    /**修改地址名称*/
    public Boolean updateAddress(String addressId, String originalAddress, String newAddress) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
            if (originalAddress.equals(businessAddress.getAddressName())) {
                int rw = businessAddressDao.updateAddressName(addressId, newAddress);
                return rw > 0;
            }

        }

        return false;
    }


    /**修改省*/
    public Boolean updateProvince(String addressId, String originalProvince, String newProvince) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
            if (originalProvince.equals(businessAddress.getProvince())) {
                int rw = businessAddressDao.updateProvince(addressId, newProvince);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改市*/
    public Boolean updateCity(String addressId, String originalCity, String newCity) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
            if (originalCity.equals(businessAddress.getCity())) {
                int rw = businessAddressDao.updateCity(addressId, newCity);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改区*/
    public Boolean updateCounty(String addressId, String originalCounty, String newCounty) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
            if (originalCounty.equals(businessAddress.getCounty())) {
                int rw = businessAddressDao.updateCounty(addressId, newCounty);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改街道*/
    public Boolean updateStreet(String addressId, String originalStreet, String newStreet) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
            if (originalStreet.equals(businessAddress.getStreet())) {
                int rw = businessAddressDao.updateStreet(addressId, newStreet);
                return rw > 0;
            }

        }

        return false;
    }

    /**修改门牌号*/
    public Boolean updateLastDetail(String addressId, String originalLastDeatail, String newLastDetail) throws SQLException {
        BusinessAddress businessAddress = businessAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (businessAddress != null) {
            if (originalLastDeatail.equals(businessAddress.getLastDetail())) {
                int rw = businessAddressDao.updateLastDetail(addressId, newLastDetail);
                return rw > 0;
            }

        }

        return false;
    }

}
