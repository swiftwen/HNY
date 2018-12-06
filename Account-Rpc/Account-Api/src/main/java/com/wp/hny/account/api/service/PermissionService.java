package com.wp.hny.account.api.service;

import java.util.List;

import com.wp.hny.account.api.dto.resp.PermissionRespDto;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:38:40
 */
public interface PermissionService {

	/**
	 * 角色id查询权限
	 * @param roleIdList
	 * @return
	 */
	List<PermissionRespDto> getPermissionByRoleId(List<Long> roleIdList);
	
}
