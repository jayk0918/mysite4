package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int userInsert(UserVo userVo) {
		int count = -1;
		System.out.println("UserDao.userInsert");
		
		count = sqlSession.insert("user.insert", userVo);
		System.out.println(userVo);
		System.out.println(count + "건 등록되었습니다.");
		return count;
	}
	
	
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao.getUser()");
		
		UserVo authVo = sqlSession.selectOne("user.getUser", userVo);
		return authVo;
	}
	
	
	
}
