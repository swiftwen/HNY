package com.wp.hny.account.api.dto.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 上午11:50:57
 */
public class UserInfoRespDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String account;

	private String cardNo;

	private String realName;

	private Byte gender;

	private String mobile;

	private String email;

	private String pwd;

	private Date createTime;

	private Date updateTime;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UserInfoRespDto [account=" + account + ", cardNo=" + cardNo + ", realName=" + realName + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", pwd=" + pwd + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
