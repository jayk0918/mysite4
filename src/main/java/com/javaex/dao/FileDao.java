package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository
public class FileDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int fileInsert(FileVo fileVo) {
		
		int count = sqlSession.insert("insertFiles", fileVo);
		
		System.out.println(count + "건 저장되었습니다.");
		
		return count;
	}
	
	
	
	
	
	
}
