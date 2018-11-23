package com.wp.hny.common.provider.impl;

import org.springframework.stereotype.Service;

import com.wp.hny.common.api.service.CommonService;

/**
 * 
 * @author swiftwen
 * @date 2018年11月23日 下午3:56:48
 */
@Service
public class CommonServiceImpl implements CommonService {

	public int add(int a, int b) {
		return a + b;
	}
}
