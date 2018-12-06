package com.wp.hny.account.provider.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.wp.hny.account.api.dto.resp.RoleRespDto;
import com.wp.hny.account.api.service.RoleService;
import com.wp.hny.account.provider.dao.RoleMapper;
import com.wp.hny.account.provider.dao.UserRoleMapper;
import com.wp.hny.account.provider.model.Role;
import com.wp.hny.account.provider.model.UserRole;
import com.wp.hny.repo.provider.AbstractService;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:39:45
 */
@Service
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

	
	@Resource
	private UserRoleMapper userRoleMapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public List<RoleRespDto> getRoleByUserId(Long userId) {
		List<RoleRespDto> list = new ArrayList<>();
		UserRole userRoleRecord = new UserRole();
		userRoleRecord.setUserId(userId);
		userRoleRecord.setState((byte)1);
		List<UserRole> userRoleList = userRoleMapper.select(userRoleRecord);
		StringBuffer ids = new StringBuffer();
		for(UserRole userRole : userRoleList) {
			ids.append(userRole.getRoleId()).append(",");
		}
		if(StringUtils.isBlank(ids)) {
			return null;
		}
		List<Role> roleList = roleMapper.selectByIds(ids.substring(0, ids.length()-1));
		for(Role role : roleList) {
			RoleRespDto dto = new RoleRespDto();
			BeanUtils.copyProperties(role, dto);
			list.add(dto);
		}
		return list;
	}
}
