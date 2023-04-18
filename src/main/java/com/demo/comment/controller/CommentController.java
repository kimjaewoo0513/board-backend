package com.demo.comment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.comment.dto.request.CommentRequest;
import com.demo.comment.dto.response.CommentResponse;
import com.demo.comment.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService service;
	
    /* [GET] /comment?bbsSeq={seq}&page={page} 댓글 조회 */
	@GetMapping
	public ResponseEntity<CommentResponse> getBbsCommentList (@ModelAttribute CommentRequest req){
		System.out.println("CommentController getBbsCommentList " + new Date());
		
		return ResponseEntity.ok(service.getBbsCommentList(req));
	}
	
	
}
