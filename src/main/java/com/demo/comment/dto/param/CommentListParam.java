package com.demo.comment.dto.param;

import com.demo.bbs.dto.param.PageParam;

public class CommentListParam extends PageParam{
	
	 private Integer bbsSeq; // 게시글 번호

	    public CommentListParam(Integer bbsSeq) {
	        this.bbsSeq = bbsSeq;
	    }

	    public Integer getBbsSeq() {
	        return bbsSeq;
	    }

	    public void setBbsSeq(Integer bbsSeq) {
	        this.bbsSeq = bbsSeq;
	    }

}
