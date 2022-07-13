package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 店铺审批;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "",description = "")
@Table(name="STORE_EXAMINE")
public class StoreExamine implements Serializable,Cloneable{
    /** 店铺ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "店铺ID",notes = "")
    private String storeId ;
    /** 店铺审批管理员ID */
    @ApiModelProperty(name = "店铺审批管理员ID",notes = "")
    private String adminId ;
    /** 店铺审批结果 */
    @ApiModelProperty(name = "店铺审批结果",notes = "")
    private String storeResult ;
    /** 店铺审批批注 */
    @ApiModelProperty(name = "店铺审批批注",notes = "")
    private String storeNotes ;

    /** 返回店铺ID */
    public String getStoreId(){
        return this.storeId;
    }
    /** 设置店铺ID */
    public void setStoreId(String storeId){
        this.storeId=storeId;
    }
    /** 返回店铺审批管理员ID */
    public String getAdminId(){
        return this.adminId;
    }
    /** 设置店铺审批管理员ID */
    public void setAdminId(String adminId){
        this.adminId=adminId;
    }
    /** 返回店铺审批结果 */
    public String getStoreResult(){
        return this.storeResult;
    }
    /** 设置店铺审批结果 */
    public void setStoreResult(String storeResult){
        this.storeResult=storeResult;
    }
    /** 返回店铺审批批注 */
    public String getStoreNotes(){
        return this.storeNotes;
    }
    /** 设置店铺审批批注 */
    public void setStoreNotes(String storeNotes){
        this.storeNotes=storeNotes;
    }
}