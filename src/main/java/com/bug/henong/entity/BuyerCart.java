package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 购物车;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "购物车",description = "")
@Table(name="BUYER_CART")
public class BuyerCart implements Serializable,Cloneable{
    /** 用户ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 总金额 */
    @ApiModelProperty(name = "总金额",notes = "")
    private Double totalPrice ;
    /** 应付金额 */
    @ApiModelProperty(name = "应付金额",notes = "")
    private Double payablePrice ;
    /** 购物车状态 */
    @ApiModelProperty(name = "购物车状态",notes = "")
    private String cartStatus ;

    /** 返回用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 设置用户ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 返回总金额 */
    public Double getTotalPrice(){
        return this.totalPrice;
    }
    /** 设置总金额 */
    public void setTotalPrice(Double totalPrice){
        this.totalPrice=totalPrice;
    }
    /** 返回应付金额 */
    public Double getPayablePrice(){
        return this.payablePrice;
    }
    /** 设置应付金额 */
    public void setPayablePrice(Double payablePrice){
        this.payablePrice=payablePrice;
    }
    /** 返回购物车状态 */
    public String getCartStatus(){
        return this.cartStatus;
    }
    /** 设置购物车状态 */
    public void setCartStatus(String cartStatus){
        this.cartStatus=cartStatus;
    }
}