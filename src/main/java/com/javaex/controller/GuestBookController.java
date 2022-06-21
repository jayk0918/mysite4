package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestBookController {

		@Autowired
		private GuestBookService guestBookService;
		
		@RequestMapping(value = "addList", method = {RequestMethod.GET, RequestMethod.POST})
		public String addList(Model model) {
			System.out.println("addList");
			List<GuestBookVo> gList = guestBookService.getList();
			model.addAttribute("gList", gList);
;			return "/guestbook/addList";
		}
		
		@RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
		public String add(@ModelAttribute GuestBookVo guestBookVo) {
			guestBookService.addList(guestBookVo);
			return "redirect:/guestbook/addList";
		}
		
		@RequestMapping(value = "deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
		public String deleteForm() {
			System.out.println("deleteForm");
			return "/guestbook/deleteForm";
		}
	
		@RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
		public String delete(@ModelAttribute GuestBookVo guestBookVo, @RequestParam("password") String password, @RequestParam("no") int no) {
			guestBookVo.setPassword(password);
			guestBookVo.setNo(no);
			System.out.println(guestBookVo);
			guestBookService.deleteList(guestBookVo);
			return "redirect:/guestbook/addList";
		}
		
		
		
	
}
