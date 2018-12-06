package com.wp.hny.account.api.dto.resp;

import java.io.Serializable;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:32:51
 */
public class RoleRespDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleRespDto [id=" + id + ", role=" + role + "]";
	}
	
}
