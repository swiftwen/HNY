package com.wp.hny.account.api.dto.req;

import java.io.Serializable;

/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 上午11:50:57
 */
public class UserInfoReqDto implements Serializable {

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

	private String passwd;

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
