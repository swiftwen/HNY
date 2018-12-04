package com.wp.hny.task.provider.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.wp.hny.repo.provider.AbstractService;
import com.wp.hny.task.api.dto.resp.TaskInfoRespDto;
import com.wp.hny.task.api.service.TaskService;
import com.wp.hny.task.provider.dao.TaskInfoMapper;
import com.wp.hny.task.provider.model.TaskInfo;

/**
 * 
 * @author swiftwen
 * @date 2018年12月3日 下午6:06:27
 */
@Service
public class TaskServiceImpl extends AbstractService<TaskInfo> implements TaskService{
	
	@Resource
    private TaskInfoMapper taskInfoMapper;

	@Override
	public List<TaskInfoRespDto> taskInfoList(int type) {
		List<TaskInfoRespDto> list = new ArrayList<>();
		//条件
		TaskInfo record = new TaskInfo();
		record.setType(type);
		
		List<TaskInfo> respList = taskInfoMapper.select(record);
		for(TaskInfo cur : respList) {
			TaskInfoRespDto dto = new TaskInfoRespDto();
			BeanUtils.copyProperties(cur, dto);
			list.add(dto);
		}
		return list;
	}
	
}
