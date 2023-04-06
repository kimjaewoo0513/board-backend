package com.demo.member.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.member.dao.MemberDao;
import com.demo.member.dto.request.JoinRequest;
import com.demo.member.dto.response.JoinResponse;
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

	//500 번 에러 해결 해야함
	private void isExistUserId(String id) {
		Integer result = dao.isExistUserId(id);
		if (result == 1) {
			throw new MemberException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional
	public JoinResponse join(@Valid JoinRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
