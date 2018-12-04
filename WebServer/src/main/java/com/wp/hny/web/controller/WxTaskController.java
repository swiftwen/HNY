package com.wp.hny.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wp.hny.base.constants.TaskInfoType;
import com.wp.hny.task.api.dto.resp.TaskInfoRespDto;
import com.wp.hny.task.api.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author swiftwen
 * @date 2018年12月3日 下午7:47:00
 */
@Api(tags= {"微信任务接口"})
@Controller
@RequestMapping("/wx_task")
public class WxTaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@ApiOperation(value = "查询投票任务" ,  notes="查询投票任务")
	@RequestMapping(value = "/wxVoteTaskInfoList",method = RequestMethod.GET)
    public String wxVoteTaskInfoList(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<TaskInfoRespDto> list = taskService.taskInfoList(TaskInfoType.WX_VOTE);
		model.addAttribute("list", list);
        return "wx_vote";
    }
	
	@ApiOperation(value = "查询点赞任务" ,  notes="查询点赞任务")
	@RequestMapping(value = "/wxPraseTaskInfoList",method = RequestMethod.GET)
    public String wxPraseTaskInfoList(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<TaskInfoRespDto> list = taskService.taskInfoList(TaskInfoType.WX_PRASE);
		model.addAttribute("list", list);
        return "wx_prase";
    }
	
	@ApiOperation(value = "查询关注任务" ,  notes="查询关注任务")
	@RequestMapping(value = "/wxFollowTaskInfoList",method = RequestMethod.GET)
    public String wxFollowTaskInfoList(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<TaskInfoRespDto> list = taskService.taskInfoList(TaskInfoType.WX_FOLLOW);
		model.addAttribute("list", list);
        return "wx_follow";
    }
	
	@ApiOperation(value = "查询评论任务" ,  notes="查询评论任务")
	@RequestMapping(value = "/wxCommentTaskInfoList",method = RequestMethod.GET)
    public String wxCommentTaskInfoList(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<TaskInfoRespDto> list = taskService.taskInfoList(TaskInfoType.WX_COMMENT);
		model.addAttribute("list", list);
        return "wx_comment";
    }
	
	
}
