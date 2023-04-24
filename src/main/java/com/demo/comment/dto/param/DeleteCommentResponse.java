package com.demo.comment.dto.param;

public class DeleteCommentResponse {
	
	private Integer deletedRecordCount;

    public DeleteCommentResponse(Integer deletedRecordCount) {
        this.deletedRecordCount = deletedRecordCount;
    }

    public Integer getDeletedRecordCount() {
        return deletedRecordCount;
    }

    public void setDeletedRecordCount(Integer deletedRecordCount) {
        this.deletedRecordCount = deletedRecordCount;
    }

}
