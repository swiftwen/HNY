package com.wp.hny.repo.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sm_order")
public class SmOrder {
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
     * 票据id
     */
    @Column(name = "voucherId")
    private Long voucherid;

    /**
     * 详情
     */
    private String description;

    /**
     * 券码
     */
    @Column(name = "voucher_no")
    private String voucherNo;

    /**
     * 券码存储地址
     */
    @Column(name = "voucher_url")
    private String voucherUrl;

    /**
     * 价格
     */
    private Double price;

    /**
     * 1：有效，-1：无效，0：核验中
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
     * 获取票据id
     *
     * @return voucherId - 票据id
     */
    public Long getVoucherid() {
        return voucherid;
    }

    /**
     * 设置票据id
     *
     * @param voucherid 票据id
     */
    public void setVoucherid(Long voucherid) {
        this.voucherid = voucherid;
    }

    /**
     * 获取详情
     *
     * @return description - 详情
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置详情
     *
     * @param description 详情
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取券码
     *
     * @return voucher_no - 券码
     */
    public String getVoucherNo() {
        return voucherNo;
    }

    /**
     * 设置券码
     *
     * @param voucherNo 券码
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    /**
     * 获取券码存储地址
     *
     * @return voucher_url - 券码存储地址
     */
    public String getVoucherUrl() {
        return voucherUrl;
    }

    /**
     * 设置券码存储地址
     *
     * @param voucherUrl 券码存储地址
     */
    public void setVoucherUrl(String voucherUrl) {
        this.voucherUrl = voucherUrl;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取1：有效，-1：无效，0：核验中
     *
     * @return status - 1：有效，-1：无效，0：核验中
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置1：有效，-1：无效，0：核验中
     *
     * @param status 1：有效，-1：无效，0：核验中
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