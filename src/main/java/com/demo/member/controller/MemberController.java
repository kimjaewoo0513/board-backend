package com.demo.member.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.member.dto.request.JoinRequest;
import com.demo.member.dto.response.JoinResponse;
import com.demo.member.service.MemberService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/user")
public class MemberController {

	private final MemberService service;

	public MemberController(MemberService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<?> checkIdDuplicate(@RequestParam String id) {
		System.out.println("UserController checkIdDuplicate " + new Date());
		HttpStatus status = service.checkIdDuplicate(id);
		return new ResponseEntity<>(status);
	}
	
	
	// 회원가입
	@PostMapping("/join")
	public ResponseEntity<JoinResponse> join (@Valid @RequestBody JoinRequest req){
		System.out.println("UserController join " + new Date());
		return ResponseEntity.ok(service.join(req));
	}

}
