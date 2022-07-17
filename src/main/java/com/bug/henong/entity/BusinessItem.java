package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 卖家商品;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "卖家商品",description = "")
@Table(name="BUSINESS_ITEM")
public class BusinessItem implements Serializable,Cloneable{
    /** 商品ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "商品ID",notes = "")
    private String skuId ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 农户ID */
    @ApiModelProperty(name = "农户ID",notes = "")
    private String farmerId ;
    /** 商品种类 */
    @ApiModelProperty(name = "商品种类",notes = "")
    private String skuCatagory ;
    /** 商品标题 */
    @ApiModelProperty(name = "商品标题",notes = "")
    private String skuTitle ;
    /** 商品介绍 */
    @ApiModelProperty(name = "商品介绍",notes = "")
    private String skuIntro ;
    /** 原价 */
    @ApiModelProperty(name = "原价",notes = "")
    private Double price ;
    /** 售价 */
    @ApiModelProperty(name = "售价",notes = "")
    private Double salePrice ;
    /** 商品数量 */
    @ApiModelProperty(name = "商品数量",notes = "")
    private Double quantity ;
    /** 活动ID */
    @ApiModelProperty(name = "活动ID",notes = "")
    private String eventId ;
     /** 卖家商品图片 */
     @ApiModelProperty(name = "卖家商品图片",notes = "")
     private String businessImage ;
     /** 商品状态 */
     @ApiModelProperty(name = "商品状态",notes = "")
     private String skuStatus ;

    /** 返回商品ID */
    public String getSkuId(){
        return this.skuId;
    }
    /** 设置商品ID */
    public void setSkuId(String skuId){
        this.skuId=skuId;
    }
    /** 返回用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 设置用户ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 返回农户ID */
    public String getFarmerId(){
        return this.farmerId;
    }
    /** 设置农户ID */
    public void setFarmerId(String farmerId){
        this.farmerId=farmerId;
    }
    /** 返回商品种类 */
    public String getSkuCatagory(){
        return this.skuCatagory;
    }
    /** 设置商品种类 */
    public void setSkuCatagory(String skuCatagory){
        this.skuCatagory=skuCatagory;
    }
    /** 返回商品标题 */
    public String getSkuTitle(){
        return this.skuTitle;
    }
    /** 设置商品标题 */
    public void setSkuTitle(String skuTitle){
        this.skuTitle=skuTitle;
    }
    /** 返回商品介绍 */
    public String getSkuIntro(){
        return this.skuIntro;
    }
    /** 设置商品介绍 */
    public void setSkuIntro(String skuIntro){
        this.skuIntro=skuIntro;
    }
    /** 返回原价 */
    public Double getPrice(){
        return this.price;
    }
    /** 设置原价 */
    public void setPrice(Double price){
        this.price=price;
    }
    /** 返回售价 */
    public Double getSalePrice(){
        return this.salePrice;
    }
    /** 设置售价 */
    public void setSalePrice(Double salePrice){
        this.salePrice=salePrice;
    }
    /** 返回商品数量 */
    public Double getQuantity(){
        return this.quantity;
    }
    /** 设置商品数量 */
    public void setQuantity(Double quantity){
        this.quantity=quantity;
    }
    /** 返回活动ID */
    public String getEventId(){
        return this.eventId;
    }
    /** 设置活动ID */
    public void setEventId(String eventId){
        this.eventId=eventId;
    }
     /** 返回卖家商品图片 */
     public String getBusinessImage(){
         return this.businessImage;
     }
     /** 设置卖家商品图片 */
     public void setBusinessImage(String businessImage){
         this.businessImage=businessImage;
     }
     /** 商品状态 */
     public String getSkuStatus(){
         return this.skuStatus;
     }
     /** 商品状态 */
     public void setSkuStatus(String skuStatus){
         this.skuStatus=skuStatus;
     }
}