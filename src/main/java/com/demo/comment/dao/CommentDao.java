package com.demo.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.comment.domain.Comment;
import com.demo.comment.dto.param.CommentListParam;
import com.demo.comment.dto.param.CreateCommentParam;
import com.demo.comment.dto.param.UpdateCommentParam;

@Mapper
@Repository
public interface CommentDao {
	
	List<Comment> getCommentPageList(CommentListParam param);
	Integer getCommentCount(Integer seq);
	
	void createComment(CreateCommentParam param);
	Integer deleteComment(Integer seq);
	
	Comment getCommentBySeq(Integer seq);
	Integer updateComment(UpdateCommentParam param);

}
