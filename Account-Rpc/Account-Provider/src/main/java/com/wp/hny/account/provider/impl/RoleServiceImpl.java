package com.wp.hny.account.provider.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wp.hny.account.api.dto.resp.RoleRespDto;
import com.wp.hny.account.api.service.RoleService;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:39:45
 */
@Service
public class RoleServiceImpl  implements RoleService {

	
	
	@Override
	public List<RoleRespDto> getRoleByUserId(Long userId) {
		
		return null;
	}
}
