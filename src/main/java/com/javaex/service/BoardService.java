package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getList(){
		return boardDao.getList();
	}
	
	public BoardVo getContent(int no) {
		return boardDao.getContent(no);
	}
	
	public int updateContent(BoardVo boardVo) {
		return boardDao.updateContent(boardVo);
	}
	
	public int insertContent(BoardVo boardVo) {
		return boardDao.insertContent(boardVo);
	}
	
	public int hit(int no) {
		return boardDao.hit(no);
	}
	
}	
