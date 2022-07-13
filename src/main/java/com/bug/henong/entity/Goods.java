package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

 /**
 * 商品;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "",description = "")
@Table(name="GOODS")
public class Goods implements Serializable,Cloneable{
    /** 商品ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "商品ID",notes = "")
    private String goodsId ;
    /** 名称 */
    @ApiModelProperty(name = "名称",notes = "")
    private String goodsName ;
    /** 数量 */
    @ApiModelProperty(name = "数量",notes = "")
    private Double goodsQuantity ;
    /** 所属农户的ID */
    @ApiModelProperty(name = "所属农户的ID",notes = "")
    private String farmerId ;
    /** 价格 */
    @ApiModelProperty(name = "价格",notes = "")
    private Double goodsPrice ;
    /** 采摘时间 */
    @ApiModelProperty(name = "采摘时间",notes = "")
    private Timestamp goodsTime ;
    /** 采摘地址 */
    @ApiModelProperty(name = "采摘地址",notes = "")
    private String goodsPlace ;
    /** 是否售罄 */
    @ApiModelProperty(name = "是否售罄",notes = "")
    private String goodsSale ;
    /** 审核是否通过 */
    @ApiModelProperty(name = "审核是否通过",notes = "")
    private String goodsPass ;
    /** 好评度 */
    @ApiModelProperty(name = "好评度",notes = "")
    private String goodsDegree ;

    /** 返回商品ID */
    public String getGoodsId(){
        return this.goodsId;
    }
    /** 设置商品ID */
    public void setGoodsId(String goodsId){
        this.goodsId=goodsId;
    }
    /** 返回名称 */
    public String getGoodsName(){
        return this.goodsName;
    }
    /** 设置名称 */
    public void setGoodsName(String goodsName){
        this.goodsName=goodsName;
    }
    /** 返回数量 */
    public Double getGoodsQuantity(){
        return this.goodsQuantity;
    }
    /** 设置数量 */
    public void setGoodsQuantity(Double goodsQuantity){
        this.goodsQuantity=goodsQuantity;
    }
    /** 返回所属农户的ID */
    public String getFarmerId(){
        return this.farmerId;
    }
    /** 设置所属农户的ID */
    public void setFarmerId(String farmerId){
        this.farmerId=farmerId;
    }
    /** 返回价格 */
    public Double getGoodsPrice(){
        return this.goodsPrice;
    }
    /** 设置价格 */
    public void setGoodsPrice(Double goodsPrice){
        this.goodsPrice=goodsPrice;
    }
    /** 返回采摘时间 */
    public Timestamp getGoodsTime(){
        return this.goodsTime;
    }
    /** 设置采摘时间 */
    public void setGoodsTime(Timestamp goodsTime){
        this.goodsTime=goodsTime;
    }
    /** 返回采摘地址 */
    public String getGoodsPlace(){
        return this.goodsPlace;
    }
    /** 设置采摘地址 */
    public void setGoodsPlace(String goodsPlace){
        this.goodsPlace=goodsPlace;
    }
    /** 返回是否售罄 */
    public String getGoodsSale(){
        return this.goodsSale;
    }
    /** 设置是否售罄 */
    public void setGoodsSale(String goodsSale){
        this.goodsSale=goodsSale;
    }
    /** 返回审核是否通过 */
    public String getGoodsPass(){
        return this.goodsPass;
    }
    /** 设置审核是否通过 */
    public void setGoodsPass(String goodsPass){
        this.goodsPass=goodsPass;
    }
    /** 返回好评度 */
    public String getGoodsDegree(){
        return this.goodsDegree;
    }
    /** 设置好评度 */
    public void setGoodsDegree(String goodsDegree){
        this.goodsDegree=goodsDegree;
    }
}