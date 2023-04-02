package com.demo.member.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.member.service.MemberService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping
	public ResponseEntity<?> checkIdDuplicate (@RequestParam String id) {
		
		System.out.println("UserController checkIdDuplicate " + new Date());
		
		HttpStatus status = service.checkIdDuplicate(id);
		
		return new ResponseEntity<>(status);
		
	}

}
