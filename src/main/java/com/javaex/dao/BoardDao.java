package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getList(){
		List<BoardVo> bList = sqlSession.selectList("board.getList");
		System.out.println(bList);
		return bList;
	}
	
	public List<BoardVo> getList4(int startRownum, int endRownum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRownum", startRownum);
		map.put("endRownum", endRownum);
		
		System.out.println(map);
		
		List<BoardVo> bList = sqlSession.selectList("board.getList4", map);
		System.out.println("getList4: " + bList);
		return bList;
	}
	
	public List<BoardVo> searchList(String keyword){
		List<BoardVo> bList = sqlSession.selectList("board.searchList", keyword);
		System.out.println(bList);
		return bList;
	}
	
	public List<BoardVo> searchList2(String keyword){
		System.out.println("dao keyword = " + keyword);
		List<BoardVo> bList = sqlSession.selectList("board.searchList2", keyword);
		return bList;
	}
	
	public BoardVo getContent(int no) {
		BoardVo boardVo = sqlSession.selectOne("board.getContent", no);
		System.out.println("dao : " + boardVo);
		return boardVo;
	}
	
	public int updateContent(BoardVo boardVo) {
		int count = -1;
		count = sqlSession.update("board.updateContent", boardVo);
		return count;
	}
	
	public int insertContent(BoardVo boardVo) {
		int count = -1;
		count = sqlSession.insert("board.insertContent", boardVo);
		return count;
	}
	
	public int insertContent4(BoardVo boardVo) {
		int count = -1;
		count = sqlSession.insert("board.insertContent4", boardVo);
		return count;
	}
	
	public int hit(int no) {
		int count = -1;
		count = sqlSession.update("board.hit", no);
		return count;
	}
	
	public int selectTotalCnt() {
		System.out.println("BoardDao > selectTotalCnt()");
		
		int totalCnt = sqlSession.selectOne("board.selectTotalCnt");
		
		
		return totalCnt;
	}
	
	
	
}
