package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class ApiGuestBookController {
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping(value="/api/guestbook/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList() {
		System.out.println("ApiGuestBookController>addList()");
		
		return "/apiGuestbook/addList";
	}
	
	@RequestMapping(value="/api/guestbook/deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		return "/apiGuestbook/deleteForm";
	}
	
	// 방명록 리스트 데이터만 수신
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<GuestBookVo> list() {
		List<GuestBookVo>gList = guestBookService.getList();
		return gList;
	}
	
	// 방명록 저장
	@RequestMapping(value = "/api/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo guestBookVo) {
		System.out.println("ApiGuestBookController > add()");
		
		guestBookService.insertGuest(guestBookVo);
		
		return "redirect:/api/guestbook/addList";
	}
	
	
	
	
	
	
	
	
}
