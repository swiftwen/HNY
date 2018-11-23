package com.wp.hny.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.hny.common.api.service.CommonService;
import com.wp.hny.web.service.TestService;
/**
 * @desc test
 * @author swiftwen
 * @date 2018年11月23日 下午4:22:43
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private CommonService commonService;
	
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return commonService.add(a, b);
	}
}
