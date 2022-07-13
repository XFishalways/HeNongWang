package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 地址;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "地址",description = "")
@Table(name="BUSINESS_ADDRESS")
public class BusinessAddress implements Serializable,Cloneable{
    /** 地址ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "地址ID",notes = "")
    private String addressId ;
    /** 地址名称 */
    @ApiModelProperty(name = "地址名称",notes = "")
    private String addressName ;
    /** 顺序号 */
    @ApiModelProperty(name = "顺序号",notes = "")
    private int seqNumber ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 省 */
    @ApiModelProperty(name = "省",notes = "")
    private String province ;
    /** 市 */
    @ApiModelProperty(name = "市",notes = "")
    private String city ;
    /** 区 */
    @ApiModelProperty(name = "区",notes = "")
    private String county ;
    /** 街道 */
    @ApiModelProperty(name = "街道",notes = "")
    private String street ;
    /** 门牌号 */
    @ApiModelProperty(name = "门牌号",notes = "")
    private String lastDetail ;
    /** 是否默认 */
    @ApiModelProperty(name = "是否默认",notes = "")
    private String isDefault ;

    /** 返回地址ID */
    public String getAddressId(){
        return this.addressId;
    }
    /** 设置地址ID */
    public void setAddressId(String addressId){
        this.addressId=addressId;
    }
    /** 返回地址名称 */
    public String getAddressName(){
        return this.addressName;
    }
    /** 设置地址名称 */
    public void setAddressName(String addressName){
        this.addressName=addressName;
    }
    /** 返回顺序号 */
    public int getSeqNumber(){
        return this.seqNumber;
    }
    /** 设置顺序号 */
    public void setSeqNumber(int seqNumber){
        this.seqNumber=seqNumber;
    }
    /** 返回用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 设置用户ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 返回省 */
    public String getProvince(){
        return this.province;
    }
    /** 设置省 */
    public void setProvince(String province){
        this.province=province;
    }
    /** 返回市 */
    public String getCity(){
        return this.city;
    }
    /** 设置市 */
    public void setCity(String city){
        this.city=city;
    }
    /** 返回区 */
    public String getCounty(){
        return this.county;
    }
    /** 设置区 */
    public void setCounty(String county){
        this.county=county;
    }
    /** 返回街道 */
    public String getStreet(){
        return this.street;
    }
    /** 设置街道 */
    public void setStreet(String street){
        this.street=street;
    }
    /** 返回门牌号 */
    public String getLastDetail(){
        return this.lastDetail;
    }
    /** 设置门牌号 */
    public void setLastDetail(String lastDetail){
        this.lastDetail=lastDetail;
    }
    /** 返回是否默认 */
    public String getIsDefault(){
        return this.isDefault;
    }
    /** 设置是否默认 */
    public void setIsDefault(String isDefault){
        this.isDefault=isDefault;
    }
}