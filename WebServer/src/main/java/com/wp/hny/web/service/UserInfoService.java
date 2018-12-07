package com.wp.hny.web.service;

import com.wp.hny.account.api.dto.req.UserInfoReqDto;
import com.wp.hny.account.api.dto.resp.UserInfoRespDto;

/**
 * 
 * @author swiftwen
 * @date 2018年11月27日 下午3:26:39
 */
public interface UserInfoService {
	
	UserInfoRespDto getUserInfoDetail(Long id);
	/**
	 * 创建账号
	 * @param reqDto
	 * @return
	 */
	Long createAccount(UserInfoReqDto reqDto);
}
