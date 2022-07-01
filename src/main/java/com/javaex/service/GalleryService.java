package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	public List<GalleryVo> getList() {
		
		List<GalleryVo> gList = galleryDao.getList();
		return gList;
	}
	
	public String save(int userNo, String content, MultipartFile file) {
		
		String saveDir = "/Users/jaykim0918/javaStudy/upload/";
		String orgName = file.getOriginalFilename();
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		String filePath = saveDir + saveName;
		
		long fileSize = file.getSize();
		
		GalleryVo galleryVo = new GalleryVo();
		galleryVo.setOrgName(orgName);
		galleryVo.setSaveName(saveName);
		galleryVo.setFilePath(filePath);
		galleryVo.setFileSize(fileSize);
		galleryVo.setUserNo(userNo);
		galleryVo.setContent(content);
		
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			bos.write(fileData);
			bos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		galleryDao.imgInsert(galleryVo);
		
		System.out.println(galleryVo);
		System.out.println(saveName);
		
		return saveName;
	}
	
	
	
}
