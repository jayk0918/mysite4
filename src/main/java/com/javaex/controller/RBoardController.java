package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RBoardService;
import com.javaex.vo.RBoardVo;

@Controller
@RequestMapping(value = "/rboard")
public class RBoardController {
	
	@Autowired
	RBoardService rBoardService;
	
	
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<RBoardVo> rList = rBoardService.getList();
		model.addAttribute("rList", rList);
		return "/rboard/list";
	}
	
	@RequestMapping(value = "read", method = {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam int no, Model model) {
		RBoardVo rBoardVo = rBoardService.getContent(no);
		model.addAttribute("RBoardVo", rBoardVo);
		
		System.out.println(rBoardVo);
		
		return "/rboard/read";
	}
	
	@RequestMapping(value = "writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		return "/rboard/writeForm";
	}
	
	@RequestMapping(value = "modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		return "/rboard/modifyForm";
	}
	
	@RequestMapping(value = "replyWriteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String replyWriteForm(@RequestParam int no, Model model){
		
		RBoardVo rBoardVo = rBoardService.getContent(no);
		model.addAttribute("RBoardVo", rBoardVo);
		
		return "/rboard/replyWriteForm";
	}
	
	@RequestMapping(value = "replyWrite", method = {RequestMethod.GET, RequestMethod.POST})
	public String replyInsert(@ModelAttribute RBoardVo rBoardVo){
		rBoardService.replyInsert(rBoardVo);
		
		return "redirect:/rboard/list";
	}
	
	
}
