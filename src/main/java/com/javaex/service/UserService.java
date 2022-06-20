package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void join(UserVo userVo) {
		System.out.println("UserService.join()");
		userDao.userInsert(userVo);
	}
	
	public UserVo login(UserVo userVo) {
		System.out.println("UserService.login()");
		
		UserVo authUser = userDao.getUser(userVo);
		return authUser;
	}
	
	public UserVo getUser(int no) {
		System.out.println("UserService.getUser()");
		
		UserVo authUser = userDao.getUser(no);
		return authUser;
	}
	
	public int userUpdate(UserVo userVo) {
		int count = userDao.userUpdate(userVo);
		return count;
	}
	
	
	
	
}
