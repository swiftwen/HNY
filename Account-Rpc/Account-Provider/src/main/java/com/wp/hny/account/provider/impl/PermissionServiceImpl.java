package com.wp.hny.account.provider.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.wp.hny.account.api.dto.resp.PermissionRespDto;
import com.wp.hny.account.api.service.PermissionService;
import com.wp.hny.account.provider.dao.PermissionMapper;
import com.wp.hny.account.provider.dao.RolePermissionMapper;
import com.wp.hny.account.provider.model.Permission;
import com.wp.hny.account.provider.model.RolePermission;
import com.wp.hny.repo.provider.AbstractService;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午2:41:18
 */
@Service
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	@Resource
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public List<PermissionRespDto> getPermissionByRoleId(List<Long> roleIdList) {
		List<PermissionRespDto> list = new ArrayList<>();
		RolePermission rolePermissionCondition = new RolePermission();
		
		StringBuffer permissionIds = new StringBuffer();
		for(Long roleId : roleIdList) {
			//遍历角色id
			rolePermissionCondition.setRoleId(roleId);
			rolePermissionCondition.setState((byte)1);
			List<RolePermission> rolePermissionList = rolePermissionMapper.select(rolePermissionCondition);
			for(RolePermission rolePermission : rolePermissionList) {
				permissionIds.append(rolePermission.getPermissionId()).append(",");
			}
		}
		if(StringUtils.isBlank(permissionIds)) {
			return null;
		}
		List<Permission> permissionList = permissionMapper.selectByIds(permissionIds.substring(0,permissionIds.length()-1));
		for(Permission permission : permissionList) {
			PermissionRespDto dto =new PermissionRespDto();
			BeanUtils.copyProperties(permission, dto);
			list.add(dto);
		}
		return list;
	}
	
	
}
