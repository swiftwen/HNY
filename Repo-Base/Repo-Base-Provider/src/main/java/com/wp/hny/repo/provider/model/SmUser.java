package com.wp.hny.repo.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sm_user")
public class SmUser {
    /**
     * 自增id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 微信用户的唯一标识
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户的性别，1男性，2女性，0未知
     */
    private Byte sex;

    /**
     * 用户个人资料填写的省份
     */
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 国家，如中国为CN
     */
    private String country;

    /**
     * 微信用户头像url
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 1：正常，0：删除 , -1：冻结
     */
    private Byte status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取微信用户的唯一标识
     *
     * @return open_id - 微信用户的唯一标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信用户的唯一标识
     *
     * @param openId 微信用户的唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取用户的性别，1男性，2女性，0未知
     *
     * @return sex - 用户的性别，1男性，2女性，0未知
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置用户的性别，1男性，2女性，0未知
     *
     * @param sex 用户的性别，1男性，2女性，0未知
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取用户个人资料填写的省份
     *
     * @return province - 用户个人资料填写的省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置用户个人资料填写的省份
     *
     * @param province 用户个人资料填写的省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取普通用户个人资料填写的城市
     *
     * @return city - 普通用户个人资料填写的城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置普通用户个人资料填写的城市
     *
     * @param city 普通用户个人资料填写的城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取国家，如中国为CN
     *
     * @return country - 国家，如中国为CN
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家，如中国为CN
     *
     * @param country 国家，如中国为CN
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取微信用户头像url
     *
     * @return head_img_url - 微信用户头像url
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置微信用户头像url
     *
     * @param headImgUrl 微信用户头像url
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    /**
     * 获取1：正常，0：删除 , -1：冻结
     *
     * @return status - 1：正常，0：删除 , -1：冻结
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置1：正常，0：删除 , -1：冻结
     *
     * @param status 1：正常，0：删除 , -1：冻结
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}