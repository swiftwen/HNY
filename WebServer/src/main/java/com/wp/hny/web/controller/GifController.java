/*package com.wp.hny.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*//**
 * 
 * @author swiftwen
 * @date 2018年12月5日 下午1:15:20
 *//*
@Controller
public class GifController {
	

@RequestMapping(value="/getGifCode",method=RequestMethod.GET)
public void getGifCode(HttpServletResponse response,HttpServletRequest request){
   try {
       response.setHeader("Pragma", "No-cache");  
       response.setHeader("Cache-Control", "no-cache");  
       response.setDateHeader("Expires", 0);  
       response.setContentType("image/gif");  
       *//**
        * gif格式动画验证码
        * 宽，高，位数。
        *//*
       Captcha captcha = new GifCaptcha(146,33,4);
       //输出
       captcha.out(response.getOutputStream());
       HttpSession session = request.getSession(true);  
       //存入Session
       session.setAttribute("_code",captcha.text().toLowerCase());  
   } catch (Exception e) {
       System.err.println("获取验证码异常："+e.getMessage());
   }
}


	
}
*/