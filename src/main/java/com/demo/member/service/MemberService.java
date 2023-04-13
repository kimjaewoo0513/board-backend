package com.demo.member.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jwt.JwtTokenUtil;
import com.demo.member.dao.MemberDao;
import com.demo.member.dto.param.CreateMemberParam;
import com.demo.member.dto.request.JoinRequest;
import com.demo.member.dto.request.LoginRequest;
import com.demo.member.dto.response.JoinResponse;
import com.demo.member.dto.response.LoginResponse;
import com.demo.member.exception.MemberException;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	
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

	public LoginResponse login(@Valid LoginRequest req) {
		
		authenticate(req.getId(), req.getPwd());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getId());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return new LoginResponse(token, req.getId());
	}

	private void authenticate(String id, String pwd) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));
		} catch (DisabledException e) {
			throw new MemberException("인증되지 않은 아이디입니다.", HttpStatus.BAD_REQUEST);
		} catch (BadCredentialsException e) {
			throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
