package com.wp.hny.repo.api.service;

import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;

import tk.mybatis.mapper.entity.Condition;
/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 下午3:03:05
 */
public interface Service<T> {

	void save(T model);// 持久化

	void save(List<T> models);// 批量持久化

	void deleteById(Integer id);// 通过主鍵刪除

	void deleteByIds(String ids);// 批量刪除 eg：ids -> “1,2,3,4”

	void update(T model);// 更新

	T findById(Long id);// 通过ID查找

	T findBy(String fieldName, Object value) throws TooManyResultsException; // 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束

	List<T> findByIds(String ids);// 通过多个ID查找//eg：ids -> “1,2,3,4”

	List<T> findByCondition(Condition condition);// 根据条件查找

	List<T> findAll();// 获取所有
}
