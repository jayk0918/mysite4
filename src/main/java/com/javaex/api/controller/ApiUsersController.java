package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class ApiUsersController {
	
	@Autowired
	private UserService userService;
	/*
	@RequestMapping(value = "/api/user/chkduplicate", method = {RequestMethod.GET, RequestMethod.POST})
	public List<UserVo> chkduplicate(UserVo userVo) {
		List<UserVo> uList = userService.chkduplicate(userVo);
		System.out.println(uList);
		return uList;
	}
	*/
	
	
	
}
