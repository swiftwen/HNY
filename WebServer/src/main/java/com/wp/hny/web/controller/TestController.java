package com.wp.hny.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wp.hny.web.service.TestService;

/**
 * 
 * @author swiftwen
 * @date 2018年11月23日 下午4:19:07
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	//@Autowired
	//private TestService testService;
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
    public void say(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(required = true) int a,@RequestParam(required = true)  int b) {
		
		//int ans = testService.add(a,b);
        //return ans;
		
		
    }
}
