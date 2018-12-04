package com.wp.hny.task.api.service;

import java.util.List;

import com.wp.hny.task.api.dto.resp.TaskInfoRespDto;

/**
 * 
 * @author swiftwen
 * @date 2018年12月3日 下午6:05:58
 */
public interface TaskService {
	
	List<TaskInfoRespDto> taskInfoList(int type);
	
}
