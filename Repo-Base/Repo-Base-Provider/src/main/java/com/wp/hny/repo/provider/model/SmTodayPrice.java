package com.wp.hny.repo.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sm_today_price")
public class SmTodayPrice {
    /**
     * 自增id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 票据id
     */
    @Column(name = "voucher_id")
    private Long voucherId;

    /**
     * 详情
     */
    private String description;

    /**
     * 价格
     */
    private Double price;

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
     * 获取票据id
     *
     * @return voucher_id - 票据id
     */
    public Long getVoucherId() {
        return voucherId;
    }

    /**
     * 设置票据id
     *
     * @param voucherId 票据id
     */
    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
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