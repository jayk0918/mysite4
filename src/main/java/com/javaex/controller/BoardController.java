package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<BoardVo> bList = boardService.getList();
		model.addAttribute("bList", bList);
		return "/board/list";
	}
	
	@RequestMapping(value = "read", method = {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam int no, Model model) {
		boardService.hit(no);
		BoardVo boardVo = boardService.getContent(no);
		model.addAttribute("boardVo", boardVo);
		
		return "/board/read";
	}
	
	@RequestMapping(value = "modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam int no, Model model) {
		BoardVo boardVo = boardService.getContent(no);
		model.addAttribute("boardVo", boardVo);
		
		return "/board/modifyForm";
	}
	
	@RequestMapping(value = "modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo, @RequestParam String title, @RequestParam String content, @RequestParam int no) {
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setNo(no);
		boardService.updateContent(boardVo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		return "/board/writeForm";
	}
	
	@RequestMapping(value = "write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo, @RequestParam int no, @RequestParam String title, @RequestParam String content) {
		boardVo.setNo(no);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardService.insertContent(boardVo);
		
		return "redirect:/board/list";
	}
	
	
	
}
