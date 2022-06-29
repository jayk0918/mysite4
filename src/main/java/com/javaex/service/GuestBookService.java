package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {

	@Autowired
	private GuestBookDao guestBookDao;
	
	public List<GuestBookVo> getList(){
		return guestBookDao.getList();
	}
	
	public int addList(GuestBookVo guestBookVo) {
		return guestBookDao.addList(guestBookVo);
	}
	
	public String deleteList(GuestBookVo guestBookVo) {
		int count = guestBookDao.deleteList(guestBookVo);
		
		String status;
		
		if(count>0) {
			status = "success";
		}else {
			status = "fail";
		}
		
		return status;
	}
	
	public GuestBookVo insertGuest(GuestBookVo guestBookVo) {
		
		guestBookDao.insertGuest(guestBookVo);
		
		int no = guestBookVo.getNo();
		GuestBookVo gVo = guestBookDao.getGuest(no);
		
		return gVo;
	}
	
	
}
