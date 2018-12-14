package com.weiye.workflow.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.weiye.annotation.SystemControllerLog;
import com.weiye.config.ActivitiConfig;
import com.weiye.properties.ProcessDefine;
import com.weiye.workflow.service.WorkFlowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 流程定义
 * @author Liweiye
 * @date 2018年12月13日
 */
@RestController
@Api(value = "流程定义", description = "流程定义")
@RequestMapping("/processDefine")
public class ProcessDefineController {

    private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProcessDefine processDefine;
	
	@Autowired
	private  ActivitiConfig activitiConfig;
	
	@PostMapping("/deployProcess")
	@SystemControllerLog(value = "部署流程文件")
	@ApiOperation(value = "部署流程文件", httpMethod = "POST", notes = "200: 发送成功")
	public Object deployProcess(@ApiParam(value = "上传文件", required = true) @RequestParam MultipartFile file) throws IOException {
		File uploadFile = new File(processDefine.getPath() + file.getOriginalFilename());
		if (!uploadFile.getParentFile().exists()) {
			uploadFile.getParentFile().mkdirs();
		}
		FileUtils.writeByteArrayToFile(uploadFile, file.getBytes());
		InputStream inputStream = new FileInputStream(uploadFile);
		//部署流程
		activitiConfig.repositoryService().createDeployment().addInputStream(file.getOriginalFilename(), inputStream).deploy();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("httpCode", "200");
		return map;
	}
}
