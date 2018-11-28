package com.wp.hny.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wp.hny.account.api.dto.resp.UserInfoRespDto;
import com.wp.hny.hnyCommon.dto.BaseResponse;
import com.wp.hny.web.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户相关controller
 * @author swiftwen
 * @date 2018年11月27日 下午3:30:55
 */
@Api(tags= {"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@ApiOperation(value = "查询用户" ,  notes="查询用户")
	@RequestMapping(value = "/getUserInfoDetail",method = RequestMethod.POST)
    public BaseResponse<UserInfoRespDto> getUserInfoDetail(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(required = true) long id) {
		
		UserInfoRespDto userInfo = userInfoService.getUserInfoDetail(id);
        return new BaseResponse<>(userInfo);
    }
}
