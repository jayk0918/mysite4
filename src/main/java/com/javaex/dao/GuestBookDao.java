package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getList(){
		List<GuestBookVo> gList = sqlSession.selectList("guestbook.getList");
		System.out.println(gList);
		return gList;
	}
	
	public int addList(GuestBookVo guestBookVo) {
		int count = -1;
		count = sqlSession.insert("guestbook.addList", guestBookVo);
		System.out.println(count + "건 등록되었습니다.");
		return count;
	}
	
	public int deleteList(GuestBookVo guestBookVo) {
		int count = -1;
		count = sqlSession.delete("guestbook.deleteList", guestBookVo);
		System.out.println(count + "건 삭제되었습니다.");
		return count;
	}
	
	public int insertGuest(GuestBookVo guestBookVo) {
		int count = -1;
		System.out.println("GuestBookDao > insertGuest");
		count = sqlSession.insert("guestbook.insertSelectKey", guestBookVo);
		return count;
	}
	
	public GuestBookVo getGuest(int no) {
		
		GuestBookVo gVo = sqlSession.selectOne("guestbook.getGuest", no);
		return gVo;
	}
	
}
