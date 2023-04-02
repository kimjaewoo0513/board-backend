package com.demo.bbs.board.dto.response;

public class UpdateBbsResponse {
	
	private Integer updatedRecordCount;
	
	public UpdateBbsResponse(Integer updatedRecordCount) {
	    this.updatedRecordCount = updatedRecordCount;
	}
	
	public Integer getUpdatedRecordCount() {
	    return updatedRecordCount;
	}
	
	public void setUpdatedRecordCount(Integer updatedRecordCount) {
	    this.updatedRecordCount = updatedRecordCount;
	}

}
