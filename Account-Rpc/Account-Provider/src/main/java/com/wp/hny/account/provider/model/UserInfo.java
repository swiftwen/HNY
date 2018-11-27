package com.wp.hny.account.provider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 人员姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别（0：未知，1：男生，2：女生）
     */
    private Byte gender;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 身份证
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 电子邮箱
     */
    private String email;

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
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return passwd - 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置密码
     *
     * @param passwd 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取人员姓名
     *
     * @return real_name - 人员姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置人员姓名
     *
     * @param realName 人员姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取性别（0：未知，1：男生，2：女生）
     *
     * @return gender - 性别（0：未知，1：男生，2：女生）
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置性别（0：未知，1：男生，2：女生）
     *
     * @param gender 性别（0：未知，1：男生，2：女生）
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 获取联系电话
     *
     * @return mobile - 联系电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置联系电话
     *
     * @param mobile 联系电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取身份证
     *
     * @return card_no - 身份证
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置身份证
     *
     * @param cardNo 身份证
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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