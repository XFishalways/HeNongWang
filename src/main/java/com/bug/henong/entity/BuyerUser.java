package com.bug.henong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ���;
 * @author : http://www.chiner.pro
 * @date : 2022-7-13
 */
@ApiModel(value = "���",description = "")
@Table(name="BUYER_USER")
public class BuyerUser implements Serializable,Cloneable{
    /** �û�ID */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "�û�ID",notes = "")
    private String userId ;
    /** �û����� */
    @ApiModelProperty(name = "�û�����",notes = "")
    private String userName ;
    /** �û��ǳ� */
    @ApiModelProperty(name = "�û��ǳ�",notes = "")
    private String nickName ;
    /** ����ǩ�� */
    @ApiModelProperty(name = "����ǩ��",notes = "")
    private String userIntro ;
    /** ͷ��ͼƬ */
    @ApiModelProperty(name = "ͷ��ͼƬ",notes = "")
    private String avatar ;
    /** �ֻ��� */
    @ApiModelProperty(name = "�ֻ���",notes = "")
    private String phone ;
    /** ���� */
    @ApiModelProperty(name = "����",notes = "")
    private String userPass ;
    /** ������ */
    @ApiModelProperty(name = "������",notes = "")
    private String passSalt ;
    /** �û�״̬ */
    @ApiModelProperty(name = "�û�״̬",notes = "")
    private String userStatus ;
    /** �ۼ����ѽ�� */
    @ApiModelProperty(name = "�ۼ����ѽ��",notes = "")
    private Double totalCostAmt ;
    /** ����¼ʱ�� */
    @ApiModelProperty(name = "����¼ʱ��",notes = "")
    private Date lastLoginTime ;

    /** �����û�ID */
    public String getUserId(){
        return this.userId;
    }
    /** �����û�ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** �����û����� */
    public String getUserName(){
        return this.userName;
    }
    /** �����û����� */
    public void setUserName(String userName){
        this.userName=userName;
    }
    /** �����û��ǳ� */
    public String getNickName(){
        return this.nickName;
    }
    /** �����û��ǳ� */
    public void setNickName(String nickName){
        this.nickName=nickName;
    }
    /** ���ظ���ǩ�� */
    public String getUserIntro(){
        return this.userIntro;
    }
    /** ���ø���ǩ�� */
    public void setUserIntro(String userIntro){
        this.userIntro=userIntro;
    }
    /** ����ͷ��ͼƬ */
    public String getAvatar(){
        return this.avatar;
    }
    /** ����ͷ��ͼƬ */
    public void setAvatar(String avatar){
        this.avatar=avatar;
    }
    /** �����ֻ��� */
    public String getPhone(){
        return this.phone;
    }
    /** �����ֻ��� */
    public void setPhone(String phone){
        this.phone=phone;
    }
    /** �������� */
    public String getUserPass(){
        return this.userPass;
    }
    /** �������� */
    public void setUserPass(String userPass){
        this.userPass=userPass;
    }
    /** ���������� */
    public String getPassSalt(){
        return this.passSalt;
    }
    /** ���������� */
    public void setPassSalt(String passSalt){
        this.passSalt=passSalt;
    }
    /** �����û�״̬ */
    public String getUserStatus(){
        return this.userStatus;
    }
    /** �����û�״̬ */
    public void setUserStatus(String userStatus){
        this.userStatus=userStatus;
    }
    /** �����ۼ����ѽ�� */
    public Double getTotalCostAmt(){
        return this.totalCostAmt;
    }
    /** �����ۼ����ѽ�� */
    public void setTotalCostAmt(Double totalCostAmt){
        this.totalCostAmt=totalCostAmt;
    }
    /** ��������¼ʱ�� */
    public Date getLastLoginTime(){
        return this.lastLoginTime;
    }
    /** ��������¼ʱ�� */
    public void setLastLoginTime(Date lastLoginTime){
        this.lastLoginTime=lastLoginTime;
    }
}