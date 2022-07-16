package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 卖家收购;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "卖家收购",description = "")
@Table(name="BUSINESS_BUYRECORD")
public class BusinessBuyrecord implements Serializable,Cloneable{
    /** 账单ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "账单ID",notes = "")
    private String recordId ;
    /** 农户ID */
    @ApiModelProperty(name = "农户ID",notes = "")
    private String farmerId ;
    /** 卖家ID */
    @ApiModelProperty(name = "卖家ID",notes = "")
    private String userId ;
    /** 收购处发货地址ID */
    @ApiModelProperty(name = "收购处发货地址ID",notes = "")
    private String addressId ;
    /** 总金额 */
    @ApiModelProperty(name = "总金额",notes = "")
    private Double totalPrice ;
    /** 商品ID */
    @ApiModelProperty(name = "商品ID",notes = "")
    private String skuId ;
     /**
      * 账单状态
      */
     @ApiModelProperty(name = "账单状态",notes = "")
     private String skuStatus ;


     /** 返回账单ID */
    public String getRecordId(){
        return this.recordId;
    }
    /** 设置账单ID */
    public void setRecordId(String recordId){
        this.recordId=recordId;
    }
    /** 返回农户ID */
    public String getFarmerId(){
        return this.farmerId;
    }
    /** 设置农户ID */
    public void setFarmerId(String farmerId){
        this.farmerId=farmerId;
    }
    /** 返回卖家ID */
    public String getUserId(){
        return this.userId;
    }
    /** 设置卖家ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 返回收购处发货地址ID */
    public String getAddressId(){
        return this.addressId;
    }
    /** 设置收购处发货地址ID */
    public void setAddressId(String addressId){
        this.addressId=addressId;
    }
    /** 返回总金额 */
    public Double getTotalPrice(){
        return this.totalPrice;
    }
    /** 设置总金额 */
    public void setTotalPrice(Double totalPrice){
        this.totalPrice=totalPrice;
    }
    /** 返回商品ID */
    public String getSkuId(){
        return this.skuId;
    }
    /** 设置商品ID */
    public void setSkuId(String skuId){
        this.skuId=skuId;
    }

     /**
      *返回账单状态
      */
     public String getSkuStatus() {
         return skuStatus;
     }

     /**
      *设置账单状态
      */
     public void setSkuStatus(String skuStatus) {
         this.skuStatus = skuStatus;
     }
 }