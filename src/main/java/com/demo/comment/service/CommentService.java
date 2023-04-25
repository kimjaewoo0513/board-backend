package com.demo.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.comment.dao.CommentDao;
import com.demo.comment.domain.Comment;
import com.demo.comment.dto.param.CommentListParam;
import com.demo.comment.dto.param.CreateCommentParam;
import com.demo.comment.dto.param.DeleteCommentResponse;
import com.demo.comment.dto.request.CommentRequest;
import com.demo.comment.dto.request.CreateCommentRequest;
import com.demo.comment.dto.request.UpdateCommentRequest;
import com.demo.comment.dto.response.CommentResponse;
import com.demo.comment.dto.response.CreateCommentResponse;
import com.demo.comment.dto.response.UpdateCommentResponse;

@Service
public class CommentService {
	
	@Autowired
	private CommentDao dao;

	/* 댓글 조회 */
    public CommentResponse getBbsCommentList(CommentRequest req) {
        CommentListParam param = new CommentListParam(req.getBbsSeq());
        param.setPageParam(req.getPage(), 5);

        List<Comment> commentList = dao.getCommentPageList(param);
        Integer pageCnt = dao.getCommentCount(req.getBbsSeq());

        return new CommentResponse(commentList, pageCnt);
    }

    /* 댓글 작성 */
    public CreateCommentResponse createComment(Integer seq, CreateCommentRequest req) {
        CreateCommentParam param = new CreateCommentParam(seq, req);
        dao.createComment(param);
        return new CreateCommentResponse(param.getSeq());
    }

    /* 댓글 삭제 */
    public DeleteCommentResponse deleteComment(Integer seq) {
        Integer deletedRecordCount = dao.deleteComment(seq);
        return new DeleteCommentResponse(deletedRecordCount);
    }

	public UpdateCommentResponse updateComment(String username, Integer seq, UpdateCommentRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
    

}
