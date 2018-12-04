package com.wp.hny.task.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "task_info")
public class TaskInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 任务类型
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 次数
     */
    private Integer cnt;

    /**
     * url链接
     */
    private String url;

    /**
     * 备注
     */
    private String remark;

    /**
     * 任务状态：0-禁用/删除，1-启用/正常
     */
    private Byte state;

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
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取任务类型
     *
     * @return type - 任务类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置任务类型
     *
     * @param type 任务类型
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取次数
     *
     * @return cnt - 次数
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     * 设置次数
     *
     * @param cnt 次数
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     * 获取url链接
     *
     * @return url - url链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url链接
     *
     * @param url url链接
     */
    public void setUrl(String url) {
        this.url = url;
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
     * 获取任务状态：0-禁用/删除，1-启用/正常
     *
     * @return state - 任务状态：0-禁用/删除，1-启用/正常
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置任务状态：0-禁用/删除，1-启用/正常
     *
     * @param state 任务状态：0-禁用/删除，1-启用/正常
     */
    public void setState(Byte state) {
        this.state = state;
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