package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 订单;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "订单",description = "")
@Table(name="BUYER_ORDER")
public class BuyerOrder implements Serializable,Cloneable{
    /** 订单ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "订单ID",notes = "")
    private String orderId ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
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
    /** 订单状态 */
    @ApiModelProperty(name = "订单状态",notes = "")
    private String orderStatus ;

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
    /** 返回地址ID */
    public String getAddressId(){
        return this.addressId;
    }
    /** 设置地址ID */
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
    /** 支设置付方式 */
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
    /** 返回订单状态 */
    public String getOrderStatus(){
        return this.orderStatus;
    }
    /** 设置订单状态 */
    public void setOrderStatus(String orderStatus){
        this.orderStatus=orderStatus;
    }
}