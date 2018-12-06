package com.wp.hny.account.api.dto.resp;

import java.io.Serializable;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:32:51
 */
public class PermissionRespDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String permissionName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
}
