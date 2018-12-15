package com.wp.hny.web.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wp.hny.account.api.dto.req.UserInfoReqDto;
import com.wp.hny.base.util.MD5Utils;
import com.wp.hny.web.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author swiftwen
 * @date 2018年11月23日 下午4:19:07
 */
@Api(tags = {"登录相关接口" })
@Controller
public class LoginController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping({"/", "/index" })
	public String index() {
		// Subject subject = SecurityUtils.getSubject();
		// Map<String, Object> resultMap = new HashMap<String, Object>();
		// UserInfoRespDto userInfo = (UserInfoRespDto) subject.getPrincipal();
		// resultMap.put("userInfo",userInfo);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/forgetPwd", method = RequestMethod.GET)
	public String forgetPwd() {
		return "forgetPwd";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "welcome";
	}

	// 登录提交地址和applicationontext-shiro.xml配置的loginurl一致。 (配置文件方式的说法)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		System.out.println("HomeController.login()");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if(exception != null) {
			if(UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if(IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		// 此方法不处理登录成功,由shiro进行处理.
		return "/login";
	}

	@ApiOperation(value = "登录", notes = "登录")
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(String username, String password, String vcode, Boolean rememberMe) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		/*
		 * if(vcode==null||vcode==""){ resultMap.put("status", 500);
		 * resultMap.put("message", "验证码不能为空！"); return resultMap; }
		 */
		Session session = SecurityUtils.getSubject().getSession();
		// 转化成小写字母
		/*
		 * vcode = vcode.toLowerCase(); String v = (String)
		 * session.getAttribute("_code"); //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
		 * //session.removeAttribute("_come"); if(!vcode.equals(v)){
		 * resultMap.put("status", 500); resultMap.put("message", "验证码错误！");
		 * return resultMap; }
		 */
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
			SecurityUtils.getSubject().login(token);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");
		} catch (UnknownAccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "账号不存在！");
		} catch (IncorrectCredentialsException e1) {
			resultMap.put("status", 500);
			resultMap.put("message", "密码错误！");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "用户名或密码错误");
		}
		return resultMap;
	}

	@ApiOperation(value = "注册", notes = "注册")
	@RequestMapping(value = "/ajaxRegister", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitRegister(String username, String password, String mobile) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		System.out.println(username+"--"+password+"---"+mobile);
		if(username == null || username.trim() == "") {
			resultMap.put("status", 500);
			resultMap.put("message", "用户名不能为空！");
			return resultMap;
		}
		if(password == null || password.trim() == "") {
			resultMap.put("status", 500);
			resultMap.put("message", "密码不能为空！");
			return resultMap;
		}
		UserInfoReqDto reqDto = new UserInfoReqDto();
		reqDto.setAccount(username);
		reqDto.setPasswd(MD5Utils.encode(password));
		reqDto.setMobile(mobile);
		userInfoService.createAccount(reqDto);
		resultMap.put("status", 200);
		resultMap.put("message", "注册成功");
		return resultMap;
	}
}
