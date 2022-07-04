package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RBoardVo;

@Repository
public class RBoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<RBoardVo> getList(){
		List<RBoardVo> rList = sqlSession.selectList("rboard.getList");
		System.out.println(rList);
		return rList;
	}
	
	public RBoardVo getContent(int no) {
		RBoardVo rBoardVo = sqlSession.selectOne("rboard.getContent", no);
		return rBoardVo;
	}
	
	public void hit(int no) {
		sqlSession.update("rboard.hit",no);
	}
	
	public void replyInsert(RBoardVo rBoardVo) {
		sqlSession.update("rboard.replyInsert", rBoardVo);
	}
	
	public void replyGroupNoUpdate(int no) {
		sqlSession.update("rboard.replyGroupNoUpdate", no);
	}
	
	public void replyOrderNoUpdate(int no) {
		sqlSession.update("rboard.replyOrderNoUpdate", no);
	}
	
	public void replyDepthUpdate(int no) {
		sqlSession.update("rboard.replyDepthUpdate", no);
	}
	
	
}
