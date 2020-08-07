package com.wp.hny.repo.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sm_cat")
public class SmCat {
    /**
     * 自增id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
    private String description;

    /**
     * 排序（越小优先级越高）
     */
    private Integer order;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取排序（越小优先级越高）
     *
     * @return order - 排序（越小优先级越高）
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置排序（越小优先级越高）
     *
     * @param order 排序（越小优先级越高）
     */
    public void setOrder(Integer order) {
        this.order = order;
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