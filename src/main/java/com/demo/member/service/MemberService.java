package com.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.member.dao.MemberDao;
import com.demo.member.exception.MemberException;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public HttpStatus checkIdDuplicate (String id) {
		isExistUserId(id);
		return HttpStatus.OK;
	}

	private void isExistUserId(String id) {
		
		Integer result = dao.isExistUserId(id);
		if(result == 1) {
			throw new MemberException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
