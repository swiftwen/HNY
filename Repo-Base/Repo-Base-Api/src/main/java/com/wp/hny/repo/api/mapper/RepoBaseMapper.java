package com.wp.hny.repo.api.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 下午3:01:42
 */
public interface RepoBaseMapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
	
}
