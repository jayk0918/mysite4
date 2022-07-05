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
		List<RBoardVo> rList = rBoardDao.getList();
		
		
		return rList;
	}
	
	public RBoardVo getContent(int no) {
		rBoardDao.hit(no);
		return rBoardDao.getContent(no);
	}
	
	public void replyInsert(RBoardVo rBoardVo) {
		int depth = (rBoardVo.getDepth()) + 1;
		rBoardVo.setDepth(depth);
		rBoardDao.replyInsert(rBoardVo);
		
	}
	
	
	
}
