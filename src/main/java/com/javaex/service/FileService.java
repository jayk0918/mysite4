package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileDao;
import com.javaex.vo.FileVo;

@Service
public class FileService {
	
	@Autowired
	private FileDao fileDao;
	
	// 파일 HDD저장, 파일정보(DB저장) 추출 저장
	public String save(MultipartFile file) {
		System.out.println("FileService>save()");
		System.out.println(file.getOriginalFilename());
		
		String saveDir = "/Users/jaykim0918/Downloads/BufferedWriter/";
		
		// 원본파일명
		String orgName = file.getOriginalFilename();
		
		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		// 저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);
		
		// 파일경로(directory+저장파일명) => path
		String filePath = saveDir + saveName;
		
		// 파일사이즈
		long fileSize = file.getSize();
		
		FileVo fileVo = new FileVo(orgName, saveName, filePath, fileSize);
		System.out.println(fileVo);
		
		// 파일저장
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return "";
	}
	
	
	
}
