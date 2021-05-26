package com.tydic.mqutils.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCustomerBatchSyncEntity implements Serializable {
    private static final long serialVersionUID = -15031792391096380L;
    //手厅用户ID
    private String appUserId;
    //【必填】用户姓名
    private String userName;

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId!=null?appUserId:"";
    }

    public void setUserName(String userName) {
        this.userName = userName!=null?userName:"";
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber!=null?serialNumber:"";
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl!=null?profileImageUrl:"";
    }

    public void setNetTypeCode(String netTypeCode) {
        this.netTypeCode = netTypeCode!=null?netTypeCode:"";
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode!=null?provinceCode:"";
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode!=null?cityCode:"";
    }

    public void setNickName(String nickName) {
        this.nickName = nickName!=null?nickName:"";
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName!=null?levelName:"";
    }

    public void setGrowthLevel(String growthLevel) {
        this.growthLevel = growthLevel!=null?growthLevel:"";
    }

    public void setGrowthIcon(String growthIcon) {
        this.growthIcon = growthIcon!=null?growthIcon:"";
    }

    public void setSex(String sex) {
        this.sex = sex!=null?sex:"";
    }

    public void setTel(String tel) {
        this.tel = tel!=null?tel:"";
    }

    public void setCertAddr(String certAddr) {
        this.certAddr = certAddr!=null?certAddr:"";
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber!=null?certNumber:"";
    }

    public void setProductId(String productId) {
        this.productId = productId!=null?productId:"";
    }

    public void setProductName(String productName) {
        this.productName = productName!=null?productName:"";
    }

    public void setInstallAddr(String installAddr) {
        this.installAddr = installAddr!=null?installAddr:"";
    }

    //【必填】用户业务号码
    private String serialNumber;
    //【必填】头像
    private String profileImageUrl;
    //【必填】网别（30:固话 40:宽带 50:移网）
    private String netTypeCode;
    // 省份编码
    private String provinceCode;
    //城市编码
    private String cityCode;
    //用户昵称
    private String nickName;
    //等级名称
    private String levelName;
    //会员等级
    private String growthLevel;
    //等级图标
    private String growthIcon;
    //性别（0：女 1：男）
    private String sex;
    //联系电话
    private String tel;
    // 证件地址
    private String certAddr;
    // 证件号码
    private String certNumber;
    // 当前套餐ID
    private String productId;
    // 当前套餐名称
    private String productName;
    // 装机地址
    private String installAddr;
}
