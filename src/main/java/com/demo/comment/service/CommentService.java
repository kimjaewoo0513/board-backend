package com.demo.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.comment.dao.CommentDao;
import com.demo.comment.dto.request.CommentRequest;
import com.demo.comment.dto.response.CommentResponse;

@Service
public class CommentService {
	
	@Autowired
	private CommentDao dao;

	/* 댓글 조회 */
	public CommentResponse getBbsCommentList(CommentRequest req) {
		
		
		// TODO dao 호출 코드 짜기
		return null;
	}

}
