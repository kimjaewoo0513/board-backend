package com.demo.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.comment.domain.Comment;
import com.demo.comment.dto.param.CommentListParam;

@Mapper
@Repository
public interface CommentDao {
	
	 List<Comment> getCommentPageList(CommentListParam param);
	 Integer getCommentCount(Integer seq);


}
