package com.demo.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.bbs.domain.Bbs;
import com.demo.bbs.dto.param.BbsCountParam;
import com.demo.bbs.dto.param.BbsListParam;
import com.demo.bbs.dto.param.CreateBbsAnswerParam;
import com.demo.bbs.dto.param.CreateBbsParam;
import com.demo.bbs.dto.param.UpdateBbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	// 게시글 목록
	List<Bbs> getBbsSearchPageList(BbsListParam param);
	
	// 게시글 목록 카운트
	Integer getBbsCount(BbsCountParam param);
	
	// 게시글 상세
	Bbs getBbs(Integer seq);
	
	// 게시글 생성
	void createBbs(CreateBbsParam param);
	
	// 게시글 수정 
	Integer updateBbs(UpdateBbsParam param);
	
	// 게시글 삭제
	Integer deleteBbs(Integer seq);
	
	Integer updateBbsStep(Integer parentSeq);
	Integer getBbsAnswerCount(Integer parentSeq);
	void createBbsAnswer(CreateBbsAnswerParam param);

}
