package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 买家商品;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "买家商品",description = "")
@Table(name="BUYER_ITEM")
public class BuyerItem implements Serializable,Cloneable{
    /** 订单ID */
    @ApiModelProperty(name = "订单ID",notes = "")
    private String orderId ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 商品ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "商品ID",notes = "")
    private String skuId ;
    /** 商品标题 */
    @ApiModelProperty(name = "商品标题",notes = "")
    private String skuTitle ;
    /** 商品介绍 */
    @ApiModelProperty(name = "商品介绍",notes = "")
    private String skuIntro ;
    /** 原价 */
    @ApiModelProperty(name = "原价",notes = "")
    private Double price ;
    /** 订单留言备注 */
    @ApiModelProperty(name = "订单留言备注",notes = "")
    private String leaveComment ;
    /** 售价 */
    @ApiModelProperty(name = "售价",notes = "")
    private Double salePrice ;

    /** 返回订单ID */
    public String getOrderId(){
        return this.orderId;
    }
    /** 设置订单ID */
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    /** 返回用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 设置用户ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 返回商品ID */
    public String getSkuId(){
        return this.skuId;
    }
    /** 设置商品ID */
    public void setSkuId(String skuId){
        this.skuId=skuId;
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
    /** 返回订单留言备注 */
    public String getLeaveComment(){
        return this.leaveComment;
    }
    /** 设置订单留言备注 */
    public void setLeaveComment(String leaveComment){
        this.leaveComment=leaveComment;
    }
    /** 返回售价 */
    public Double getSalePrice(){
        return this.salePrice;
    }
    /** 设置售价 */
    public void setSalePrice(Double salePrice){
        this.salePrice=salePrice;
    }
}