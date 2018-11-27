package com.wp.hny.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.hny.account.api.dto.resp.UserInfoRespDto;
import com.wp.hny.account.api.service.AccountService;
import com.wp.hny.web.service.UserInfoService;

/**
 * 
 * @author swiftwen
 * @date 2018年11月27日 下午3:28:33
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private AccountService accountService;
	
	@Override
	public UserInfoRespDto getUserInfoDetail(Long id) {
		// TODO Auto-generated method stub
		UserInfoRespDto userInfo = accountService.getUserInfoDetail(id);
		return userInfo;
	}
}
