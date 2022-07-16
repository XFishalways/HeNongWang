package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 卖家账单;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "卖家账单",description = "")
@Table(name="BUSINESS_ORDER")
public class BusinessOrder implements Serializable,Cloneable{
    /** 账单ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "账单ID",notes = "")
    private String orderId ;
    /** 商品ID */
    @ApiModelProperty(name = "商品ID",notes = "")
    private String skuId ;
    /** 地址ID */
    @ApiModelProperty(name = "地址ID",notes = "")
    private String addressId ;
    /** 总金额 */
    @ApiModelProperty(name = "总金额",notes = "")
    private Double totalPrice ;
    /** 优惠金额 */
    @ApiModelProperty(name = "优惠金额",notes = "")
    private Double couponPrice ;
    /** 应付金额 */
    @ApiModelProperty(name = "应付金额",notes = "")
    private Double payablePrice ;
    /** 支付方式 */
    @ApiModelProperty(name = "支付方式",notes = "")
    private String payMethod ;
    /** 开票设置ID */
    @ApiModelProperty(name = "开票设置ID",notes = "")
    private String invoiceTplId ;
    /** 买家留言 */
    @ApiModelProperty(name = "买家留言",notes = "")
    private String leaveComment ;
    /** 订单状态 */
    @ApiModelProperty(name = "订单状态",notes = "")
    private String orderStatus ;

     @ApiModelProperty(name = "商品数量",notes = "")
     private String skuAmount ;

    /** 返回账单ID */
    public String getOrderId(){
        return this.orderId;
    }
    /** 设置账单ID */
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    /** 返回商品ID */
    public String getSkuId(){
        return this.skuId;
    }
    /** 设置商品ID */
    public void setSkuId(String skuId){
        this.skuId=skuId;
    }
    /** 返回地址ID */
    public String getAddressId(){
        return this.addressId;
    }
    /** 设置地址ID */
    public void setAddressId(String addressId){
        this.addressId=addressId;
    }
    /** 总金额 */
    public Double getTotalPrice(){
        return this.totalPrice;
    }
    /** 设置总金额 */
    public void setTotalPrice(Double totalPrice){
        this.totalPrice=totalPrice;
    }
    /** 返回优惠金额 */
    public Double getCouponPrice(){
        return this.couponPrice;
    }
    /** 设置优惠金额 */
    public void setCouponPrice(Double couponPrice){
        this.couponPrice=couponPrice;
    }
    /** 返回应付金额 */
    public Double getPayablePrice(){
        return this.payablePrice;
    }
    /** 设置应付金额 */
    public void setPayablePrice(Double payablePrice){
        this.payablePrice=payablePrice;
    }
    /** 返回支付方式 */
    public String getPayMethod(){
        return this.payMethod;
    }
    /** 设置支付方式 */
    public void setPayMethod(String payMethod){
        this.payMethod=payMethod;
    }
    /** 返回开票设置ID */
    public String getInvoiceTplId(){
        return this.invoiceTplId;
    }
    /** 设置开票设置ID */
    public void setInvoiceTplId(String invoiceTplId){
        this.invoiceTplId=invoiceTplId;
    }
    /** 返回买家留言 */
    public String getLeaveComment(){
        return this.leaveComment;
    }
    /** 设置买家留言 */
    public void setLeaveComment(String leaveComment){
        this.leaveComment=leaveComment;
    }
    /** 返回订单状态 */
    public String getOrderStatus(){
        return this.orderStatus;
    }
    /** 设置订单状态 */
    public void setOrderStatus(String orderStatus){
        this.orderStatus=orderStatus;
    }

     /**
      *返回商品数量
      */
     public String getSkuAmount() {
         return skuAmount;
     }

     /**
      *设置商品数量
      */
     public void setSkuAmount(String skuAmount) {
         this.skuAmount = skuAmount;
     }

 }