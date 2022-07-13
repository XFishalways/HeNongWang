package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 农民;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "",description = "")
@Table(name="FARMER")
public class Farmer implements Serializable,Cloneable{
    /** 姓名 */
    @ApiModelProperty(name = "姓名",notes = "")
    private String farmerName ;
    /** 年龄 */
    @ApiModelProperty(name = "年龄",notes = "")
    private Integer farmerAge ;
    /** ID号 */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "ID号",notes = "")
    private String farmerId ;
    /** 所在地 */
    @ApiModelProperty(name = "所在地",notes = "")
    private String farmerPlace ;
    /** 资产 */
    @ApiModelProperty(name = "资产",notes = "")
    private Double farmerValue ;
    /** 信誉度 */
    @ApiModelProperty(name = "信誉度",notes = "")
    private String farmerCredibility ;
    /** 所属卖家ID号 */
    @ApiModelProperty(name = "所属卖家ID号",notes = "")
    private String businessId ;
    /** 用户密码 */
    @ApiModelProperty(name = "用户密码",notes = "")
    private String userPass ;
    /** 密码盐 */
    @ApiModelProperty(name = "密码盐",notes = "")
    private String passSalt ;

    /** 返回姓名 */
    public String getFarmerName(){
        return this.farmerName;
    }
    /** 设置姓名 */
    public void setFarmerName(String farmerName){
        this.farmerName=farmerName;
    }
    /** 返回年龄 */
    public Integer getFarmerAge(){
        return this.farmerAge;
    }
    /** 设置年龄 */
    public void setFarmerAge(Integer farmerAge){
        this.farmerAge=farmerAge;
    }
    /** 返回ID号 */
    public String getFarmerId(){
        return this.farmerId;
    }
    /** 设置ID号 */
    public void setFarmerId(String farmerId){
        this.farmerId=farmerId;
    }
    /** 返回所在地 */
    public String getFarmerPlace(){
        return this.farmerPlace;
    }
    /** 设置所在地 */
    public void setFarmerPlace(String farmerPlace){
        this.farmerPlace=farmerPlace;
    }
    /** 返回资产 */
    public Double getFarmerValue(){
        return this.farmerValue;
    }
    /** 设置资产 */
    public void setFarmerValue(Double farmerValue){
        this.farmerValue=farmerValue;
    }
    /** 返回信誉度 */
    public String getFarmerCredibility(){
        return this.farmerCredibility;
    }
    /** 设置信誉度 */
    public void setFarmerCredibility(String farmerCredibility){
        this.farmerCredibility=farmerCredibility;
    }
    /** 返回所属卖家ID号 */
    public String getBusinessId(){
        return this.businessId;
    }
    /** 设置所属卖家ID号 */
    public void setBusinessId(String businessId){
        this.businessId=businessId;
    }
    /** 返回用户密码 */
    public String getUserPass(){
        return this.userPass;
    }
    /** 设置用户密码 */
    public void setUserPass(String userPass){
        this.userPass=userPass;
    }
    /** 返回密码盐 */
    public String getPassSalt(){
        return this.passSalt;
    }
    /** 设置密码盐 */
    public void setPassSalt(String passSalt){
        this.passSalt=passSalt;
    }
}