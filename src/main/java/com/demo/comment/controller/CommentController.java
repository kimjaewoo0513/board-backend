package com.demo.comment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.comment.dto.request.CommentRequest;
import com.demo.comment.dto.request.CreateCommentRequest;
import com.demo.comment.dto.response.CommentResponse;
import com.demo.comment.dto.response.CreateCommentResponse;
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
	
	
	/* [POST] /comment?bbsSeq={seq} 댓글 작성 */
    @PostMapping
    public ResponseEntity<CreateCommentResponse> createComment(@RequestParam Integer bbsSeq, @RequestBody CreateCommentRequest req) {
        System.out.println("CommentController createComment " + new Date());

        return ResponseEntity.ok(service.createComment(bbsSeq, req));
    }

	
}
