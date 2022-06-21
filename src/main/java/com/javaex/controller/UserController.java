package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController > joinForm");
		return "/user/joinForm";
	}
	
	@RequestMapping(value = "join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController > join");
		userService.join(userVo);
		return "/user/joinOk";
	}
	
	@RequestMapping(value = "loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController > loginForm");
		return "/user/loginForm";
	}
	
	@RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController > login");
		
		UserVo authUser = userService.login(userVo);
		
		if(authUser != null) {
			System.out.println("로그인 성공");
			// 세션에 저장
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}else {
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	@RequestMapping(value = "logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController > logout");
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/main";
	}
	
	@RequestMapping(value = "modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("UserController > modifyForm");
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		int no = authUser.getNo();
		
		UserVo userVo = userService.getUser(no);
		//request.setAttribute("userVo", userVo); -> session 이용 최소화
		model.addAttribute("userVo", userVo);
		System.out.println(userVo);
		
		return "/user/modifyForm";
	}
	
	@RequestMapping(value = "modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController > modify");
		userService.userUpdate(userVo);
		/*
		session.setAttribute("authUser", userVo);
		-> userVo에 no, name, password gender 다 들어감
		*/
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		authUser.setName(userVo.getName());
		return "redirect:/main";
	}
}
