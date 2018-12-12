package com.weiye.workflow.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.weiye.annotation.SystemControllerLog;
import com.weiye.properties.ProcessDefine;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "流程定义", description = "流程定义")
@RequestMapping("/processDefine")
public class ProcessDefineController {

    private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProcessDefine processDefine;
	@PostMapping("/deployProcess")
	@SystemControllerLog(value = "部署流程文件")
	@ApiOperation(value = "部署流程文件", httpMethod = "POST", notes = "200: 发送成功")
	public Object deployProcess(@ApiParam(value = "上传文件", required = true) @RequestParam MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info(processDefine.getPath());
		map.put("httpCode", "200");
		return map;
	}
}
