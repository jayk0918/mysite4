package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		return "/board/list";
	}
	
	@RequestMapping(value = "modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		return "/board/modifyForm";
	}
	
	@RequestMapping(value = "read", method = {RequestMethod.GET, RequestMethod.POST})
	public String read() {
		return "/board/read";
	}

	@RequestMapping(value = "writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		return "/board/writeForm";
	}
	
	
}
