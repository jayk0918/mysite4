package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getList4(int crtPage){
		System.out.println("BoardService > getList4");
		System.out.println(crtPage);
		
		// 페이지 당 contents개수
		int listCnt = 2;
		
		// 현재 페이지
		if(crtPage>0) {
			crtPage = (crtPage>0) ? crtPage : (crtPage=1);
		}else {
			crtPage = 1;
		}
		
		// 시작 글 번호
		int startRownum = (crtPage - 1) * listCnt + 1;
		
		// 끝 글 번호
		int endRownum = (startRownum + listCnt) - 1;
		
		/*
		System.out.println("listCnt : " + listCnt);
		System.out.println("crtPage : " + crtPage);
		System.out.println("startRownum : " + startRownum);
		System.out.println("endRownum : " + endRownum);
		*/
		
		int totalCnt = boardDao.selectTotalCnt();
		System.out.println("Service totalCnt : " + totalCnt);
		
		// 페이지 당 버튼 갯수
		int pageBtnCount = 5;
		
		// 마지막 버튼
		int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount) * (pageBtnCount);
		
		// 시작 버튼
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		System.out.println("crtPage : " + crtPage);
		System.out.println("startPageBtnNo : " + startPageBtnNo);
		System.out.println("endPageBtnNo : " + endPageBtnNo);
		
		// 화살표 유무
		boolean next = false;
		boolean previous = false;
		
		if((listCnt * endPageBtnNo) < totalCnt) {
			next = true;
		}else {
			endPageBtnNo = (int)Math.ceil(totalCnt / (double)listCnt);
		}
		
		if((startPageBtnNo != 1)) {
			previous = true;
		}
		
		System.out.println(crtPage);
		System.out.println("previous : " + previous);
		System.out.println("next: " + next);
		
		List <BoardVo> boardList = boardDao.getList4(startRownum, endRownum);
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList);
		pMap.put("next", next);
		pMap.put("previous", previous);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		
		System.out.println(pMap);
		
		return pMap;
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
	
	public int insertContent4(BoardVo boardVo) {
		for(int i=0; i<=1972; i++) {
			boardVo.setTitle(i + "트 내가 고자라니");
			boardVo.setContent(i + "트 말도안돼");
		}
		return boardDao.insertContent4(boardVo);
	}
	
	public int hit(int no) {
		return boardDao.hit(no);
	}

}	
