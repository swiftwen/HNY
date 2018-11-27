package com.wp.hny.account.provider.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.wp.hny.account.api.dto.req.UserInfoReqDto;
import com.wp.hny.account.api.dto.resp.UserInfoRespDto;
import com.wp.hny.account.api.service.AccountService;
import com.wp.hny.account.provider.dao.UserInfoMapper;
import com.wp.hny.account.provider.model.UserInfo;
import com.wp.hny.repo.provider.AbstractService;

/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 下午12:44:19
 */
@Service
public class AccountServiceImpl extends AbstractService<UserInfo> implements AccountService {

	@Resource
    private UserInfoMapper userInfoMapper;
	
	@Override
	public Long createAccount(UserInfoReqDto req) {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(req, userInfo);
		userInfoMapper.insert(userInfo);
		return userInfo.getId();
	}

	@Override
	public UserInfoRespDto getUserInfoDetail(long id) {
		UserInfo userInfo =  userInfoMapper.selectByPrimaryKey(id);
		UserInfoRespDto resp = new UserInfoRespDto();
		if(null != userInfo) {
			BeanUtils.copyProperties(userInfo, resp);
		}
		return resp;
	}

}
