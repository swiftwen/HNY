package com.wp.hny.repo.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sm_pay_info")
public class SmPayInfo {
    /**
     * 自增id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 支付宝收款账号（手机号）
     */
    @Column(name = "alipay_no")
    private String alipayNo;

    /**
     * 支付宝收款账号二维码
     */
    @Column(name = "alipay_url")
    private String alipayUrl;

    /**
     * 1：正常，0：删除
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取支付宝收款账号（手机号）
     *
     * @return alipay_no - 支付宝收款账号（手机号）
     */
    public String getAlipayNo() {
        return alipayNo;
    }

    /**
     * 设置支付宝收款账号（手机号）
     *
     * @param alipayNo 支付宝收款账号（手机号）
     */
    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    /**
     * 获取支付宝收款账号二维码
     *
     * @return alipay_url - 支付宝收款账号二维码
     */
    public String getAlipayUrl() {
        return alipayUrl;
    }

    /**
     * 设置支付宝收款账号二维码
     *
     * @param alipayUrl 支付宝收款账号二维码
     */
    public void setAlipayUrl(String alipayUrl) {
        this.alipayUrl = alipayUrl;
    }

    /**
     * 获取1：正常，0：删除
     *
     * @return status - 1：正常，0：删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置1：正常，0：删除
     *
     * @param status 1：正常，0：删除
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