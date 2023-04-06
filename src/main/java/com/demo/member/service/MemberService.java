package com.demo.member.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.member.dao.MemberDao;
import com.demo.member.dto.param.CreateMemberParam;
import com.demo.member.dto.request.JoinRequest;
import com.demo.member.dto.response.JoinResponse;
import com.demo.member.exception.MemberException;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	@Autowired
	private PasswordEncoder encoder;
	
	public HttpStatus checkIdDuplicate (String id) {
		isExistUserId(id);
		return HttpStatus.OK;
	}

	@Transactional
	public JoinResponse join(@Valid JoinRequest req) {
		
		saveMember(req);
		
		return new JoinResponse(req.getId());
	}

	private void saveMember(@Valid JoinRequest req) {
		// 아이디 중복 확인
		isExistUserId(req.getId());
		
		// 비밀번호 일치 확인
		checkPwd(req.getPwd(), req.getCheckPwd());
		
		// 회원 정보 생성
		String encodedPwd = encoder.encode(req.getPwd());
		CreateMemberParam param = new CreateMemberParam(req, encodedPwd);
		
		Integer result = dao.createMember(param);
		if(result == 0) {
			throw new MemberException("회원가입의 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private void checkPwd(String pwd, String checkPwd) {
		if(!pwd.equals(checkPwd)) {
			throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
		
	}

	// TODO 500번 에러 처리
	private void isExistUserId(String id) {
		Integer result = dao.isExistUserId(id);
		if (result == 1) {
			throw new MemberException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
