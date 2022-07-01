package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value="/gallery/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		
		galleryService.getList();
		
		return "gallery/list";
	}
	
	
	
	
}
