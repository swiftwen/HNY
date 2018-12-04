package com.wp.hny.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author swiftwen
 * @date 2018年11月23日 下午4:19:07
 */
@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/homepage",method = RequestMethod.GET)
    public String homepage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		return "index";
    }
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, HttpServletResponse response)throws Exception {
		return "welcome";
    }
}
