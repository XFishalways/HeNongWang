package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

 /**
 * 商品活动;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "",description = "")
@Table(name="SALE_PRODUCT")
public class SaleProduct implements Serializable,Cloneable{
    /** 商品活动ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "商品活动ID",notes = "")
    private String saleProductId ;
    /** 商品活动负责管理员ID */
    @ApiModelProperty(name = "商品活动负责管理员ID",notes = "")
    private String adminId ;
    /** 商品活动标题 */
    @ApiModelProperty(name = "商品活动标题",notes = "")
    private String saleProductTitle ;
    /** 商品活动说明 */
    @ApiModelProperty(name = "商品活动说明",notes = "")
    private String saleProductIntro ;
    /** 商品活动内容 */
    @ApiModelProperty(name = "商品活动内容",notes = "")
    private String saleProductContent ;
    /** 商品活动起始时间 */
    @ApiModelProperty(name = "商品活动起始时间",notes = "")
    private Timestamp saleProductStartTime ;
    /** 商品活动截止时间 */
    @ApiModelProperty(name = "商品活动截止时间",notes = "")
    private Timestamp saleProductEndTime ;
    /** 商品活动范围 */
    @ApiModelProperty(name = "商品活动范围",notes = "")
    private String saleProductRange ;
    /** 商品活动类型 */
    @ApiModelProperty(name = "商品活动类型",notes = "")
    private String saleProductType ;
    /** 商品活动状态 */
    @ApiModelProperty(name = "商品活动状态",notes = "")
    private String saleProductStatus ;

    /** 返回商品活动ID */
    public String getSaleProductId(){
        return this.saleProductId;
    }
    /** 设置商品活动ID */
    public void setSaleProductId(String saleProductId){
        this.saleProductId=saleProductId;
    }
    /** 返回商品活动负责管理员ID */
    public String getAdminId(){
        return this.adminId;
    }
    /** 设置商品活动负责管理员ID */
    public void setAdminId(String adminId){
        this.adminId=adminId;
    }
    /** 返回商品活动标题 */
    public String getSaleProductTitle(){
        return this.saleProductTitle;
    }
    /** 设置商品活动标题 */
    public void setSaleProductTitle(String saleProductTitle){
        this.saleProductTitle=saleProductTitle;
    }
    /** 返回商品活动说明 */
    public String getSaleProductIntro(){
        return this.saleProductIntro;
    }
    /** 设置商品活动说明 */
    public void setSaleProductIntro(String saleProductIntro){
        this.saleProductIntro=saleProductIntro;
    }
    /** 返回商品活动内容 */
    public String getSaleProductContent(){
        return this.saleProductContent;
    }
    /** 设置商品活动内容 */
    public void setSaleProductContent(String saleProductContent){
        this.saleProductContent=saleProductContent;
    }
    /** 返回商品活动起始时间 */
    public Timestamp getSaleProductStartTime(){
        return this.saleProductStartTime;
    }
    /** 设置商品活动起始时间 */
    public void setSaleProductStartTime(Timestamp saleProductStartTime){
        this.saleProductStartTime=saleProductStartTime;
    }
    /** 返回商品活动截止时间 */
    public Timestamp getSaleProductEndTime(){
        return this.saleProductEndTime;
    }
    /** 设置商品活动截止时间 */
    public void setSaleProductEndTime(Timestamp saleProductEndTime){
        this.saleProductEndTime=saleProductEndTime;
    }
    /** 返回商品活动范围 */
    public String getSaleProductRange(){
        return this.saleProductRange;
    }
    /** 设置商品活动范围 */
    public void setSaleProductRange(String saleProductRange){
        this.saleProductRange=saleProductRange;
    }
    /** 返回商品活动类型 */
    public String getSaleProductType(){
        return this.saleProductType;
    }
    /** 设置商品活动类型 */
    public void setSaleProductType(String saleProductType){
        this.saleProductType=saleProductType;
    }
    /** 返回商品活动状态 */
    public String getSaleProductStatus(){
        return this.saleProductStatus;
    }
    /** 设置商品活动状态 */
    public void setSaleProductStatus(String saleProductStatus){
        this.saleProductStatus=saleProductStatus;
    }
}