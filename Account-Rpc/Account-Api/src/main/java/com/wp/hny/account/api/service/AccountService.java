package com.wp.hny.account.api.service;

import com.wp.hny.account.api.dto.req.UserInfoReqDto;
import com.wp.hny.account.api.dto.resp.UserInfoRespDto;

/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 上午11:49:20
 */
public interface AccountService {

	/**
	 * 创建用户
	 * 
	 * @param req
	 * @return
	 */
	Long createAccount(UserInfoReqDto req);

	/**
	 * 用户详细信息
	 * 
	 * @param id
	 * @return
	 */
	UserInfoRespDto getUserInfoDetail(long id);
	
	/**
	 * 用户名查找用户
	 * @param account
	 * @return
	 */
	UserInfoRespDto getUserInfoByAccount(String account);
	/**
	 * 用户名查询密码
	 * @param account
	 * @return
	 */
	String getPwdByAccount(String account);
	
}
