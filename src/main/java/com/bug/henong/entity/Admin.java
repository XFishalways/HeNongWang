package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

 /**
 * 管理员;
 * @author : 刘睿杰
 * @date : 2022-7-13
 */
@ApiModel(value = "管理员",description = "")
@Table(name="ADMIN")
public class Admin implements Serializable,Cloneable{
    /** 管理员ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "管理员ID",notes = "")
    private String adminId ;
    /** 管理员用户名 */
    @ApiModelProperty(name = "管理员用户名",notes = "")
    private String adminName ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String adminPasswd ;
    /** 手机号 */
    @ApiModelProperty(name = "手机号",notes = "")
    private String adminPhone ;
    /** 密码盐 */
    @ApiModelProperty(name = "密码盐",notes = "")
    private String passSalt ;

    /** 返回管理员ID */
    public String getAdminId(){
        return this.adminId;
    }
    /** 设置管理员ID */
    public void setAdminId(String adminId){
        this.adminId=adminId;
    }
    /** 返回管理员用户名 */
    public String getAdminName(){
        return this.adminName;
    }
    /** 设置管理员用户名 */
    public void setAdminName(String adminName){
        this.adminName=adminName;
    }
    /** 返回密码 */
    public String getAdminPasswd(){
        return this.adminPasswd;
    }
    /** 设置密码 */
    public void setAdminPasswd(String adminPasswd){
        this.adminPasswd=adminPasswd;
    }
    /** 返回手机号 */
    public String getAdminPhone(){
        return this.adminPhone;
    }
    /** 设置手机号 */
    public void setAdminPhone(String adminPhone){
        this.adminPhone=adminPhone;
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