package com.wp.hny.account.api.service;

import java.util.List;

import com.wp.hny.account.api.dto.resp.RoleRespDto;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:31:29
 */
public interface RoleService {

	List<RoleRespDto> getRoleByUserId(Long userId);
	
}
