package com.demo.bbs.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bbs.board.dao.BbsDao;
import com.demo.bbs.board.domain.Bbs;
import com.demo.bbs.board.dto.param.BbsCountParam;
import com.demo.bbs.board.dto.param.BbsListParam;
import com.demo.bbs.board.dto.param.CreateBbsParam;
import com.demo.bbs.board.dto.param.UpdateBbsParam;
import com.demo.bbs.board.dto.request.BbsListRequest;
import com.demo.bbs.board.dto.request.CreateBbsRequest;
import com.demo.bbs.board.dto.request.UpdateBbsRequest;
import com.demo.bbs.board.dto.response.BbsListResponse;
import com.demo.bbs.board.dto.response.BbsResponse;
import com.demo.bbs.board.dto.response.CreateBbsResponse;
import com.demo.bbs.board.dto.response.DeleteBbsResponse;
import com.demo.bbs.board.dto.response.UpdateBbsResponse;

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

}
