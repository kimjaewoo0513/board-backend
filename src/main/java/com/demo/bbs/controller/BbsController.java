package com.demo.bbs.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.bbs.dto.request.BbsListRequest;
import com.demo.bbs.dto.request.CreateBbsRequest;
import com.demo.bbs.dto.request.UpdateBbsRequest;
import com.demo.bbs.dto.response.BbsListResponse;
import com.demo.bbs.dto.response.BbsResponse;
import com.demo.bbs.dto.response.CreateBbsResponse;
import com.demo.bbs.dto.response.DeleteBbsResponse;
import com.demo.bbs.dto.response.UpdateBbsResponse;
import com.demo.bbs.service.BbsService;

@RestController
@RequestMapping("/bbs")
public class BbsController {
	
	private final BbsService service;

	public BbsController(BbsService service) {
		this.service = service;
	}
	
	/* [GET /bbs?choice={choice}&search={search}&page={page}] 게시글 목록 API */
	@GetMapping
	public ResponseEntity<BbsListResponse> getBbsList(@ModelAttribute BbsListRequest req) {
		
		System.out.println("BbsController getBbsList() " + new Date());
		
		return ResponseEntity.ok(service.getBbsList(req));
	}
	
	/* [GET /bbs/{seq}?readerId={id}] 게시글 상세 API */
	@GetMapping("/{seq}")
	public ResponseEntity<BbsResponse> getBbs(@PathVariable Integer seq){
		System.out.println("BbsController getBbs() " + new Date());
		
		return ResponseEntity.ok(service.getBbs(seq));
	}
	
	/* [POST] /bbs 게시글 작성 */
	@PostMapping
	public ResponseEntity<CreateBbsResponse> createBbs(CreateBbsRequest req , MultipartFile[] multipartFiles){
		System.out.println("BbsController createBbs " + new Date());
		
		
		return null;
		//return ResponseEntity.ok(service.createBbs(req));
	}
	
	/* [POST] /bbs/{parentSeq}/answer 게시글 답글 작성  */
	@PostMapping("/{parentSeq}/answer")
	public ResponseEntity<CreateBbsResponse> createBbsAnswer(@PathVariable Integer parentSeq, @RequestBody CreateBbsRequest req) {
		System.out.println("BbsController createBbsAnswer " + new Date());

		return ResponseEntity.ok(service.createBbsAnswer(parentSeq, req));
	}
	
	/* [PATCH] /bbs/{seq} 게시글 수정  */
	@PatchMapping("/{seq}")
	public ResponseEntity<UpdateBbsResponse> updateBbs(@PathVariable Integer seq , @RequestBody UpdateBbsRequest req) {
		System.out.println("BbsController updateBbs " + new Date());
		
		return ResponseEntity.ok(service.updateBbs(seq, req));
	}
	
	/* [DELETE] /bbs/{seq} 게시글 삭제  */
	@DeleteMapping("/{seq}")
	public ResponseEntity<DeleteBbsResponse> deleteBbs(@PathVariable Integer seq){
		System.out.println("BbsController deleteBbs " + new Date());
		
		return ResponseEntity.ok(service.deleteBbs(seq));
	}
	
	
	
	
}
