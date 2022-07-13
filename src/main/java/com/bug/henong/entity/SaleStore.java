package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

 /**
 * 店铺活动;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "",description = "")
@Table(name="SALE_STORE")
public class SaleStore implements Serializable,Cloneable{
    /** 店铺活动ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "店铺活动ID",notes = "")
    private String saleStoreid ;
    /** 店铺活动负责管理员ID */
    @ApiModelProperty(name = "店铺活动负责管理员ID",notes = "")
    private String adminId ;
    /** 店铺活动标题 */
    @ApiModelProperty(name = "店铺活动标题",notes = "")
    private String saleStoreTitle ;
    /** 店铺活动说明 */
    @ApiModelProperty(name = "店铺活动说明",notes = "")
    private String saleStoreIntro ;
    /** 店铺活动内容 */
    @ApiModelProperty(name = "店铺活动内容",notes = "")
    private String saleStoreContent ;
    /** 店铺活动起始时间 */
    @ApiModelProperty(name = "店铺活动起始时间",notes = "")
    private Timestamp saleStoreStartTime ;
    /** 店铺活动截止时间 */
    @ApiModelProperty(name = "店铺活动截止时间",notes = "")
    private Timestamp saleStoreEndTime ;
    /** 店铺活动范围 */
    @ApiModelProperty(name = "店铺活动范围",notes = "")
    private String saleStoreRange ;
    /** 店铺活动类型 */
    @ApiModelProperty(name = "店铺活动类型",notes = "")
    private String saleStoreType ;
    /** 店铺活动状态 */
    @ApiModelProperty(name = "店铺活动状态",notes = "")
    private String saleStoreStatus ;

    /** 返回店铺活动ID */
    public String getSaleStoreid(){
        return this.saleStoreid;
    }
    /** 设置店铺活动ID */
    public void setSaleStoreid(String saleStoreid){
        this.saleStoreid=saleStoreid;
    }
    /** 返回店铺活动负责管理员ID */
    public String getAdminId(){
        return this.adminId;
    }
    /** 设置店铺活动负责管理员ID */
    public void setAdminId(String adminId){
        this.adminId=adminId;
    }
    /** 返回店铺活动标题 */
    public String getSaleStoreTitle(){
        return this.saleStoreTitle;
    }
    /** 设置店铺活动标题 */
    public void setSaleStoreTitle(String saleStoreTitle){
        this.saleStoreTitle=saleStoreTitle;
    }
    /** 返回店铺活动说明 */
    public String getSaleStoreIntro(){
        return this.saleStoreIntro;
    }
    /** 设置店铺活动说明 */
    public void setSaleStoreIntro(String saleStoreIntro){
        this.saleStoreIntro=saleStoreIntro;
    }
    /** 返回店铺活动内容 */
    public String getSaleStoreContent(){
        return this.saleStoreContent;
    }
    /** 设置店铺活动内容 */
    public void setSaleStoreContent(String saleStoreContent){
        this.saleStoreContent=saleStoreContent;
    }
    /** 返回店铺活动起始时间 */
    public Timestamp getSaleStoreStartTime(){
        return this.saleStoreStartTime;
    }
    /** 设置店铺活动起始时间 */
    public void setSaleStoreStartTime(Timestamp saleStoreStartTime){
        this.saleStoreStartTime=saleStoreStartTime;
    }
    /** 返回店铺活动截止时间 */
    public Timestamp getSaleStoreEndTime(){
        return this.saleStoreEndTime;
    }
    /** 设置店铺活动截止时间 */
    public void setSaleStoreEndTime(Timestamp saleStoreEndTime){
        this.saleStoreEndTime=saleStoreEndTime;
    }
    /** 返回店铺活动范围 */
    public String getSaleStoreRange(){
        return this.saleStoreRange;
    }
    /** 设置店铺活动范围 */
    public void setSaleStoreRange(String saleStoreRange){
        this.saleStoreRange=saleStoreRange;
    }
    /** 返回店铺活动类型 */
    public String getSaleStoreType(){
        return this.saleStoreType;
    }
    /** 设置店铺活动类型 */
    public void setSaleStoreType(String saleStoreType){
        this.saleStoreType=saleStoreType;
    }
    /** 返回店铺活动状态 */
    public String getSaleStoreStatus(){
        return this.saleStoreStatus;
    }
    /** 设置店铺活动状态 */
    public void setSaleStoreStatus(String saleStoreStatus){
        this.saleStoreStatus=saleStoreStatus;
    }
}