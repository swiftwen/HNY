package com.wp.hny.account.provider.model;

import java.util.Date;
import javax.persistence.*;

public class Role {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称
     */
    private String role;

    /**
     * 用户状态：0-禁用/删除，1-启用/正常
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
     * 获取角色名称
     *
     * @return role - 角色名称
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色名称
     *
     * @param role 角色名称
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取用户状态：0-禁用/删除，1-启用/正常
     *
     * @return state - 用户状态：0-禁用/删除，1-启用/正常
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置用户状态：0-禁用/删除，1-启用/正常
     *
     * @param state 用户状态：0-禁用/删除，1-启用/正常
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