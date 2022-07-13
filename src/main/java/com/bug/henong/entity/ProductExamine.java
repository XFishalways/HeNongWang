package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 商品审批;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "",description = "")
@Table(name="PRODUCT_EXAMINE")
public class ProductExamine implements Serializable,Cloneable{
    /** 商品ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "商品ID",notes = "")
    private String productId ;
    /** 商品审批管理员ID */
    @ApiModelProperty(name = "商品审批管理员ID",notes = "")
    private String adminId ;
    /** 商品审批结果 */
    @ApiModelProperty(name = "商品审批结果",notes = "")
    private String productResult ;
    /** 商品审批批注 */
    @ApiModelProperty(name = "商品审批批注",notes = "")
    private String productNotes ;

    /** 返回商品ID */
    public String getProductId(){
        return this.productId;
    }
    /** 设置商品ID */
    public void setProductId(String productId){
        this.productId=productId;
    }
    /** 返回商品审批管理员ID */
    public String getAdminId(){
        return this.adminId;
    }
    /** 设置商品审批管理员ID */
    public void setAdminId(String adminId){
        this.adminId=adminId;
    }
    /** 返回商品审批结果 */
    public String getProductResult(){
        return this.productResult;
    }
    /** 设置商品审批结果 */
    public void setProductResult(String productResult){
        this.productResult=productResult;
    }
    /** 返回商品审批批注 */
    public String getProductNotes(){
        return this.productNotes;
    }
    /** 设置商品审批批注 */
    public void setProductNotes(String productNotes){
        this.productNotes=productNotes;
    }
}