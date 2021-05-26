package com.tydic.mqutils.entity;

import com.tydic.mqutils.utils.DateFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljc11007
 *
 */

    @Data
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class SalemenBatchSyncEntity implements Serializable {
        private static final long serialVersionUID = -15031792391096380L;

    public void setBusiManUserId(String busiManUserId) {
        this.busiManUserId = busiManUserId!=null?busiManUserId:"";
    }

    public void setUserName(String userName) {
        this.userName = userName!=null?userName:"";
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode!=null?provinceCode:"";
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode!=null?cityCode:"";
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode!=null?districtCode:"";
    }

    public void setDepartment(String department) {
        this.department = department!=null?department:"";
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode!=null?channelCode:"";
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName!=null?channelName:"";
    }

    public void setMobile(String mobile) {
        this.mobile = mobile!=null?mobile:"";
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl!=null?profileImageUrl:"";
    }

    /**
     * 性别为2表示无法传送性别信息
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex!=null?sex:2;
    }

    public void setLevel(String level) {
        this.level = level!=null?level:"";
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName!=null?levelName:"";
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode!=null?devCode:"";
    }

    public void setDevName(String devName) {
        this.devName = devName!=null?devName:"";
    }

    public void setDevChnlCode(String devChnlCode) {
        this.devChnlCode = devChnlCode!=null?devChnlCode:"";
    }

    public void setDevDepartName(String devDepartName) {
        this.devDepartName = devDepartName!=null?devDepartName:"";
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 党员默认信息
     * @param isPartyMan
     */
    public void setIsPartyMan(Integer isPartyMan) {
        this.isPartyMan = isPartyMan!=null?isPartyMan:0;
    }



    public void setBusiStar(String busiStar) {
        this.busiStar = busiStar!=null?busiStar:"";
    }

    /**
     * 默认3为智家工程师
     * @param busiRole
     */
    public void setBusiRole(Integer busiRole) {
        this.busiRole = busiRole!=null?busiRole:3;
    }

    /**
     * 0为无效,1为有效
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status!=null?status:0;
    }

    public void setNote(String note) {
        this.note = note!=null?note:"";
    }

    /**
     * 业务员ID
     */
    private String busiManUserId;
    /**
     * 业务员姓名
     */
    private String userName;
    /**
     * 省份编码
     */
    private String provinceCode;
    /**
     * 地市编码
     */
    private String cityCode;
    /**
     * 区县编码
     */
    private String districtCode;
    /**
     * 所属部门
     */
    private String department;
    /**
     * 渠道编码
     */
    private String channelCode;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 头像
     */
    private String profileImageUrl;
    /**
     * 性别 0：女 1：男
     */
    private Integer sex;
    /**
     * 等级
     */
    private String level;
    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 发展人编码
     */
    private String devCode;
    /**
     * 发展人名称
     */
    private String devName;
    /**
     * 发展人渠道编码
     */
    private String devChnlCode;
    /**
     * 发展人渠道名称
     */
    private String devDepartName;
    /**
     * 客服系统用户ID映射
     */
    private Long sysUserId;
    /**
     * 党员标识 1是，2不是
     */
    private Integer isPartyMan;
    /**
     * 从业时间
     */
    private String workYears;
    /**
     * 业务员星级 1-5
     */
    private String busiStar;
    /**
     * 业务员角色类型 1:一线营业员 2:中台营业员 3:智家工程师 4:客服经理
     */
    private Integer busiRole;
    /**
     * 状态 0:无效 1:有效
     */
    private Integer status;

    public void setWorkYears(Date workYears) {
        this.workYears = DateFormat.dateFormat(workYears);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = DateFormat.dateFormat(createTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = DateFormat.dateFormat(updateTime);
    }

    /**
     * 备注
     */
    private String note;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;

    }


