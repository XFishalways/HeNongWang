package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 卖家;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "卖家",description = "")
@Table(name="BUSINESS_USER")
public class BusinessUser implements Serializable,Cloneable{
    /** 用户ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 用户名称 */
    @ApiModelProperty(name = "用户名称",notes = "")
    private String userName ;
    /** 用户昵称 */
    @ApiModelProperty(name = "用户昵称",notes = "")
    private String nickName ;
    /** 个性签名 */
    @ApiModelProperty(name = "个性签名",notes = "")
    private String userIntro ;
    /** 头像图片 */
    @ApiModelProperty(name = "头像图片",notes = "")
    private String avatar ;
    /** 手机号 */
    @ApiModelProperty(name = "手机号",notes = "")
    private String phone ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String userPass ;
    /** 密码盐 */
    @ApiModelProperty(name = "密码盐",notes = "")
    private String passSalt ;
    /** 用户状态 */
    @ApiModelProperty(name = "用户状态",notes = "")
    private String userStatus ;

    /** 返回用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 设置用户ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 返回用户名称 */
    public String getUserName(){
        return this.userName;
    }
    /** 设置用户名称 */
    public void setUserName(String userName){
        this.userName=userName;
    }
    /** 返回用户昵称 */
    public String getNickName(){
        return this.nickName;
    }
    /** 设置用户昵称 */
    public void setNickName(String nickName){
        this.nickName=nickName;
    }
    /** 返回个性签名 */
    public String getUserIntro(){
        return this.userIntro;
    }
    /** 设置个性签名 */
    public void setUserIntro(String userIntro){
        this.userIntro=userIntro;
    }
    /** 返回头像图片 */
    public String getAvatar(){
        return this.avatar;
    }
    /** 设置头像图片 */
    public void setAvatar(String avatar){
        this.avatar=avatar;
    }
    /** 返回手机号 */
    public String getPhone(){
        return this.phone;
    }
    /** 设置手机号 */
    public void setPhone(String phone){
        this.phone=phone;
    }
    /** 返回密码 */
    public String getUserPass(){
        return this.userPass;
    }
    /** 设置密码 */
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
    /** 返回用户状态 */
    public String getUserStatus(){
        return this.userStatus;
    }
    /** 设置用户状态 */
    public void setUserStatus(String userStatus){
        this.userStatus=userStatus;
    }
}