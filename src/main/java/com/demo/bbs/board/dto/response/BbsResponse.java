package com.demo.bbs.board.dto.response;

import com.demo.bbs.board.domain.Bbs;

public class BbsResponse {
	
	private Bbs bbs;
	
	public BbsResponse(Bbs bbs) {
        this.bbs = bbs;
    }

    public Bbs getBbs() {
        return bbs;
    }

    public void setBbs(Bbs bbs) {
        this.bbs = bbs;
    }

}
