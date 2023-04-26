package com.demo.bbs.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bbs.dao.BbsDao;
import com.demo.bbs.domain.Bbs;
import com.demo.bbs.dto.param.BbsCountParam;
import com.demo.bbs.dto.param.BbsListParam;
import com.demo.bbs.dto.param.CreateBbsAnswerParam;
import com.demo.bbs.dto.param.CreateBbsParam;
import com.demo.bbs.dto.param.UpdateBbsParam;
import com.demo.bbs.dto.request.BbsListRequest;
import com.demo.bbs.dto.request.CreateBbsRequest;
import com.demo.bbs.dto.request.UpdateBbsRequest;
import com.demo.bbs.dto.response.BbsListResponse;
import com.demo.bbs.dto.response.BbsResponse;
import com.demo.bbs.dto.response.CreateBbsResponse;
import com.demo.bbs.dto.response.DeleteBbsResponse;
import com.demo.bbs.dto.response.UpdateBbsResponse;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	private final BbsDao dao;

	public BbsService(BbsDao dao) {
		this.dao = dao;
	}

	/* 게시글 조회 */
	public BbsListResponse getBbsList(BbsListRequest req) {
		BbsListParam param = new BbsListParam(req);
		param.setPageParam(req.getPage(), 10);

		List<Bbs> bbsList = dao.getBbsSearchPageList(param);
		int pageCnt = dao.getBbsCount(new BbsCountParam(req));

		return new BbsListResponse(bbsList, pageCnt);
	}
	
	/* 특정 글 */
	/* 조회수 수정 */
	public BbsResponse getBbs(Integer seq) {
		return new BbsResponse(dao.getBbs(seq));
	}
	
	/* 글 추가 */
	public CreateBbsResponse createBbs(CreateBbsRequest req) {
		CreateBbsParam param = new CreateBbsParam(req);
		dao.createBbs(param);
		return new CreateBbsResponse(param.getSeq());
	}
	
	/* 게시글 수정 */
	public UpdateBbsResponse updateBbs(Integer seq, UpdateBbsRequest req) {
		Integer updatedRecordCount = dao.updateBbs(new UpdateBbsParam(seq,req));
		return new UpdateBbsResponse(updatedRecordCount);
	}

	/* 게시글 삭제 */
	public DeleteBbsResponse deleteBbs(Integer seq) {
		Integer deletedRecordCount = dao.deleteBbs(seq);
		return new DeleteBbsResponse(deletedRecordCount);
	}

	/* 답글 추가 */
	public CreateBbsResponse createBbsAnswer(Integer parentSeq, CreateBbsRequest req) {
		Integer updatedRecordCount = dao.updateBbsStep(parentSeq);
		Integer bbsAnswerCount = dao.getBbsAnswerCount(parentSeq);
		// TODO - 예외처리
		if (!Objects.equals(updatedRecordCount, bbsAnswerCount)) {
			System.out.println("BbsService createBbsAnswer: Fail update parent bbs step !!");
			return null;
		}

		CreateBbsAnswerParam param = new CreateBbsAnswerParam(parentSeq, req);
		dao.createBbsAnswer(param);
		return new CreateBbsResponse(param.getSeq());
	}

}
