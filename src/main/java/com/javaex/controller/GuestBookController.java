package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestBookService;

@Controller
@RequestMapping(value="/gbc")
public class GuestBookController {

		@Autowired
		private GuestBookService guestBookService;
		
		@RequestMapping(value = "addList", method = {RequestMethod.GET, RequestMethod.POST})
		public String addList() {
			System.out.println("addList");
			return "/gbc/addList";
		}
	
	
	
	
	
}
