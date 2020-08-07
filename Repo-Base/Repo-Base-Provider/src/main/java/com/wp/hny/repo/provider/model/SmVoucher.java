package com.wp.hny.repo.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sm_voucher")
public class SmVoucher {
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
     * url链接地址
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 分类id
     */
    @Column(name = "catId")
    private Long catid;

    /**
     * 排序（越小优先级越高）
     */
    private Integer order;

    /**
     * 票据回收量
     */
    private Integer limit;

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
     * 获取url链接地址
     *
     * @return link_url - url链接地址
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 设置url链接地址
     *
     * @param linkUrl url链接地址
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 获取分类id
     *
     * @return catId - 分类id
     */
    public Long getCatid() {
        return catid;
    }

    /**
     * 设置分类id
     *
     * @param catid 分类id
     */
    public void setCatid(Long catid) {
        this.catid = catid;
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
     * 获取票据回收量
     *
     * @return limit - 票据回收量
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 设置票据回收量
     *
     * @param limit 票据回收量
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
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