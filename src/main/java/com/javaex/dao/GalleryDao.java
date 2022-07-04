package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GalleryVo> getList() {
		List<GalleryVo> gList = sqlSession.selectList("gallery.getList");
		
		return gList;
	}
	
	public GalleryVo getListOne(int no) {
		GalleryVo galleryVo = sqlSession.selectOne("gallery.getListOne", no);
		
		return galleryVo;
	}
	
	public int imgInsert(GalleryVo galleryVo) {
		int count = sqlSession.insert("gallery.insertImg", galleryVo);
		System.out.println(count + "건 저장되었습니다.");
		return count;
	}
	
	
	
	
	
}
