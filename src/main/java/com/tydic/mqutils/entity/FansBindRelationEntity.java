package com.tydic.mqutils.entity;

import com.tydic.mqutils.utils.DateFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljc11007
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FansBindRelationEntity implements Serializable {
    private static final long serialVersionUID = -15031792391096380L;
    /**
     * 客户ID 对应客户表的CUST_ID
     */
    private String custId;

    public void setCustId(String custId) {
        this.custId = custId!=null?custId:"";
    }

    public void setBusiManUserId(String busiManUserId) {
        this.busiManUserId = busiManUserId!=null?busiManUserId:"";
    }

    public void setCbAccount(String cbAccount) {
        this.cbAccount = cbAccount!=null?cbAccount:"";
    }

    public void setBusiRole(Integer busiRole) {
        this.busiRole = busiRole!=null?busiRole:3;
    }

    public void setBusiManMobile(String busiManMobile) {
        this.busiManMobile = busiManMobile!=null?busiManMobile:"";
    }

    public void setUserId(String userId) {
        this.userId = userId!=null?userId:"";
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber!=null?serialNumber:"";
    }

    public void setNetTypeCode(String netTypeCode) {
        this.netTypeCode = netTypeCode!=null?netTypeCode:"";
    }

    /**
     * 为空的时候，值设为100
     * @param relSource
     */
    public void setRelSource(Integer relSource) {
        this.relSource = relSource!=null?relSource:100;
    }

    public void setRelType(Integer relType) {
        this.relType = relType!=null?relType:100;
    }

    public void setBusiManProvince(String busiManProvince) {
        this.busiManProvince = busiManProvince!=null?busiManProvince:"";
    }

    public void setBusiManCity(String busiManCity) {
        this.busiManCity = busiManCity!=null?busiManCity:"";
    }

    public void setBusiManChannelCode(String busiManChannelCode) {
        this.busiManChannelCode = busiManChannelCode!=null?busiManChannelCode:"";
    }

    /**
     * status状态为0，无效
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status!=null?status:0;
    }

    public void setNote(String note) {
        this.note = note!=null?note:"";
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustId() {
        return custId;
    }

    public String getBusiManUserId() {
        return busiManUserId;
    }

    public String getCbAccount() {
        return cbAccount;
    }

    public Integer getBusiRole() {
        return busiRole;
    }

    public String getBusiManMobile() {
        return busiManMobile;
    }

    public String getUserId() {
        return userId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getNetTypeCode() {
        return netTypeCode;
    }

    public Integer getRelSource() {
        return relSource;
    }

    public Integer getRelType() {
        return relType;
    }

    public String getBusiManProvince() {
        return busiManProvince;
    }

    public String getBusiManCity() {
        return busiManCity;
    }

    public String getBusiManChannelCode() {
        return busiManChannelCode;
    }

    public String getBindTime() {
        return bindTime;
    }

    public void setBindTime(String bindTime) {
        this.bindTime = bindTime;
    }

    public Integer getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpeType() {
        return opeType;
    }

    public void setOpeType(String opeType) {
        this.opeType = opeType;
    }

    /**
     * 业务员ID 对应业务员表的USER_ID
     */
    private String busiManUserId;
    /**
     * 业务员CB工号 对应用户表的APP_USER_ID
     */
    private String cbAccount;
    /**
     * 业务员角色类型 1:营业员 2:中台 3:智家工程师 4:客服经理
     */
    private Integer busiRole;
    /**
     * 营业员手机号
     */
    private String busiManMobile;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户业务号码
     */
    private String serialNumber;
    /**
     * 网别 30 固话 40 宽带 50 移网
     */
    private String netTypeCode;
    /**
     * 关系来源 大数据-0，自系统-1，其他-9
     */
    private Integer relSource;
    /**
     * 关系类型 直播-1、超级办-2、cBSS办理-3、分享-4、企微-5 、lbs-6 、存量换机-7、附近营业厅-8
     */
    private Integer relType;
    /**
     * 业务员的省份
     */
    private String busiManProvince;
    /**
     * 业务员地市
     */
    private String busiManCity;
    /**
     * 业务员渠道编码
     */
    private String busiManChannelCode;
    /**
     * 绑定时间
     */
    private String bindTime;
    /**
     * 状态 1：有效  0：无效
     */
    private Integer status;
    /**
     * 备注
     */
    private String note;

    public void setBindTime(Date bindTime) {
        this.bindTime = DateFormat.dateFormat(bindTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = DateFormat.dateFormat(createTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = DateFormat.dateFormat(updateTime);
    }

    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 绑定关系 C新增 U更新 D删除
     */
    private String opeType;


}
