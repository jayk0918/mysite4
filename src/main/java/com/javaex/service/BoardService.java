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
		System.out.println("BoardService > getList");
		return boardDao.getList();
	}
	
	public List<BoardVo> searchList(String keyword){
		System.out.println("BoardService > getList2");
		return boardDao.searchList(keyword);
	}
	
	public List<BoardVo> searchList2(String keyword){
		return boardDao.searchList2(keyword);
	}
	
	public BoardVo getContent(int no) {
		boardDao.hit(no);
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
