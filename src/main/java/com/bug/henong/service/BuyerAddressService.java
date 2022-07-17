package com.bug.henong.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.bug.henong.dao.BuyerAddressDao;
import com.bug.henong.entity.BusinessAddress;
import com.bug.henong.entity.BuyerAddress;
import com.bug.henong.entity.Farmer;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("BuyerAddressService")
public class BuyerAddressService {
    private BuyerAddressDao buyerAddressDao =new BuyerAddressDao();

    /**得到所有地址信息*/
    public List<BuyerAddress> getBuyerAddressDetailById(String userId) throws SQLException {
        return buyerAddressDao.findAll(userId);
    }

    /**
     *得到一个地址信息title
     */
    public BuyerAddress findOneBuyerAddressByTitle(String addressTitle) throws SQLException {
        return buyerAddressDao.findOneAddress(addressTitle);
    }

    /**
     *得到一个地址信息id
     */
    public BuyerAddress findOneBuyerAddress(String addressId) throws SQLException {
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
    public int update(String addressId, String addressName, String receiverName, String receiverPhone, String province, String city,
                      String county, String street, String lastDetail, String isDefault, String userId) throws SQLException{

        BuyerAddress buyerAddress = buyerAddressDao.findOneAddress(addressId);

        if(buyerAddress == null){
            return 0;
        }
        if(!buyerAddress.getAddressName().equals(addressId)){
            buyerAddressDao.updateAddressName(addressId, addressName);
        }
        if(!buyerAddress.getReceiverName().equals(addressId)){
            buyerAddressDao.updateReceiverName(addressId, receiverName);
        }
        if(!buyerAddress.getReceiverPhone().equals(addressId)){
            buyerAddressDao.updateReceiverPhone(addressId, receiverPhone);
        }
        if(!buyerAddress.getProvince().equals(province)){
            buyerAddressDao.updateProvince(addressId, province);
        }
        if(!buyerAddress.getCity().equals(city)){
            buyerAddressDao.updateCity(addressId, city);
        }
        if(!buyerAddress.getCounty().equals(county)){
            buyerAddressDao.updateCounty(addressId, county);
        }
        if(!buyerAddress.getStreet().equals(street)){
            buyerAddressDao.updateStreet(addressId, street);
        }
        if(!buyerAddress.getLastDetail().equals(lastDetail)){
            buyerAddressDao.updateLastDetail(addressId, lastDetail);
        }
        if(!buyerAddress.getIsDefault().equals(isDefault)){
            buyerAddressDao.updateIsDefault(addressId, isDefault);
        }
        if(!buyerAddress.getUserId().equals(userId)){
            buyerAddressDao.updateIsDefault(addressId, userId);
        }
        return 1;

    }

    public int Insert(String addressName, String receiverName, String receiverPhone, String province, String city, String county, String street,
                      String lastDetail, String isDefault, String userId) throws SQLException{

        BuyerAddress buyerAddress = new BuyerAddress();

        Snowflake snowflake = IdUtil.getSnowflake(4, 1);
        String buyerAddressId = snowflake.nextIdStr();

        buyerAddress.setAddressId(buyerAddressId);

        buyerAddress.setAddressName(addressName);
        buyerAddress.setReceiverName(receiverName);
        buyerAddress.setReceiverPhone(receiverPhone);
        buyerAddress.setProvince(province);
        buyerAddress.setCity(city);
        buyerAddress.setCounty(county);
        buyerAddress.setStreet(street);
        buyerAddress.setLastDetail(lastDetail);
        buyerAddress.setIsDefault(isDefault);
        buyerAddress.setUserId(userId);

        return buyerAddressDao.insert(buyerAddress);
    }
    public void deleteAddress(String addressId) throws SQLException {

        buyerAddressDao.delete(addressId);

    }

}
