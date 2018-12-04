package com.wp.hny.task.api.service;

import java.util.List;

import com.wp.hny.task.api.dto.req.AddWxTaskReqDto;
import com.wp.hny.task.api.dto.resp.TaskInfoRespDto;

/**
 * 
 * @author swiftwen
 * @date 2018年12月3日 下午6:05:58
 */
public interface TaskService {
	/**
	 * 任务列表
	 * @param type
	 * @return
	 */
	List<TaskInfoRespDto> taskInfoList(int type);
	/**
	 * 新增微信任务
	 * @param reqDto
	 * @return
	 */
	boolean addWxTaskInfo(AddWxTaskReqDto reqDto);
	
}
