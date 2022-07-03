package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value="/gallery/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<GalleryVo> gList = galleryService.getList();
		model.addAttribute("gList", gList);
		return "gallery/list";
	}
	
	@RequestMapping(value="/gallery/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam(value="userNo") int userNo,
						 @RequestParam(value="content") String content,
						 @RequestParam(value="file") MultipartFile file,
						 Model model) {
		System.out.println("GalleryController > upload()");
		
		String saveName = galleryService.save(userNo, content, file);
		
		model.addAttribute("saveName", saveName);
		
		return "redirect:/gallery/list";
	}
	
	
	
}
