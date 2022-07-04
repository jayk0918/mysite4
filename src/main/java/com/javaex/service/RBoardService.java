package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RBoardDao;
import com.javaex.vo.RBoardVo;

@Service
public class RBoardService {
	
	@Autowired
	RBoardDao rBoardDao;
	
	public List<RBoardVo> getList(){
		return rBoardDao.getList();
	}
	
	public RBoardVo getContent(int no) {
		rBoardDao.hit(no);
		return rBoardDao.getContent(no);
	}
	
	public void replyInsert(RBoardVo rBoardVo) {
		
		rBoardDao.replyInsert(rBoardVo);
		
		int no = rBoardVo.getNo();
		rBoardDao.replyOrderNoUpdate(no);
		rBoardDao.replyDepthUpdate(no);
		
	}
	
	
	
}
