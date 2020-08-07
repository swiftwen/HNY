package com.wp.hny.account.provider.impl;

import org.springframework.stereotype.Service;

import com.wp.hny.account.api.dto.req.UserInfoReqDto;
import com.wp.hny.account.api.dto.resp.UserInfoRespDto;
import com.wp.hny.account.api.service.AccountService;

/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 下午12:44:19
 */
@Service
public class AccountServiceImpl  implements AccountService {

	@Override
	public Long createAccount(UserInfoReqDto req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoRespDto getUserInfoDetail(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoRespDto getUserInfoByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPwdByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
