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

	@Override
	public UserInfoRespDto getUserInfoByAccount(String account) {
		UserInfoRespDto userInfoRespDto = new UserInfoRespDto();
		UserInfo record = new UserInfo();
	    record.setAccount(account);
		try {
			UserInfo userInfo = userInfoMapper.selectOne(record);
			BeanUtils.copyProperties(userInfo, userInfoRespDto);
		}catch(Exception e) {
			return null;
		}
		return userInfoRespDto;
	}

	@Override
	public String getPwdByAccount(String account) {
		UserInfo record = new UserInfo();
	    record.setAccount(account);
		try {
			UserInfo userInfo = userInfoMapper.selectOne(record);
			return userInfo.getPasswd();
		}catch(Exception e) {
			return null;
		}
	}

}
