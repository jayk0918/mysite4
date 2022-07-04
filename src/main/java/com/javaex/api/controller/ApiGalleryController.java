package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class ApiGalleryController {
	
	@Autowired
	GalleryService galleryService;
	
	@RequestMapping(value = "/api/gallery/getListOne", method = {RequestMethod.GET, RequestMethod.POST})
	public GalleryVo getListOne(@RequestParam(value = "no") int no) {
		GalleryVo galleryVo = galleryService.getListOne(no);
		System.out.println(galleryVo);
		return galleryVo;
	}
	
	
	
	
}
