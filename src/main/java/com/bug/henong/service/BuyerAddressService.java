package com.bug.henong.service;

import com.bug.henong.dao.BuyerAddressDao;
import com.bug.henong.entity.BuyerAddress;
import com.bug.henong.entity.Farmer;

import java.sql.SQLException;

public class BuyerAddressService {
    private BuyerAddressDao buyerAddressDao =new BuyerAddressDao();

    /**得到地址信息*/
    public BuyerAddress getBuyerAddressDetailById(String addressId) throws SQLException {
        return buyerAddressDao.findOneAddress(addressId);
    }

    /**修改地址名称*/
    public Boolean updateAddress(String addressId, String newAddress) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateAddressName(addressId, newAddress);
                return rw > 0;


        }

        return false;
    }

    /**修改收件人姓名*/
    public Boolean updateReceiverName(String addressId, String newReceiverName) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateReceiverName(addressId, newReceiverName);
                return rw > 0;


        }

        return false;
    }

    /**修改收件人电话号码*/
    public Boolean updateReceiverPhone(String addressId, String newReceiverPhone) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateReceiverPhone(addressId, newReceiverPhone);
                return rw > 0;


        }

        return false;
    }

    /**修改省*/
    public Boolean updateProvince(String addressId,  String newProvince) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateProvince(addressId, newProvince);
                return rw > 0;


        }

        return false;
    }

    /**修改市*/
    public Boolean updateCity(String addressId, String newCity) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateCity(addressId, newCity);
                return rw > 0;


        }

        return false;
    }

    /**修改区*/
    public Boolean updateCounty(String addressId, String newCounty) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateCounty(addressId, newCounty);
                return rw > 0;


        }

        return false;
    }

    /**修改街道*/
    public Boolean updateStreet(String addressId,  String newStreet) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateStreet(addressId, newStreet);
                return rw > 0;


        }

        return false;
    }

    /**修改门牌号*/
    public Boolean updateLastDetail(String addressId,  String newLastDetail) throws SQLException {
        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        //当前地址非空才可以进行更改
        if (buyerAddress != null) {

                int rw = buyerAddressDao.updateLastDetail(addressId, newLastDetail);
                return rw > 0;


        }

        return false;
    }

}
