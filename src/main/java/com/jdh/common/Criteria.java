package com.jdh.common;

import lombok.Getter;

@Getter
public class Criteria {
	private int page;			//페이지번호
	private int perPage = 5; 	//화면에 보여줄 게시글수
	private int startRow; 		//시작로우
	private	int endRow;   		//끝 로우

	public Criteria() {
		this.page = 1;
	}

	public void setPage(int page) {
		if(page < 1) this.page = 1;
		else this.page = page;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public void setStartAndEndRow() {
		startRow = (page - 1) * perPage + 1;
		endRow = startRow + perPage - 1;
	}
}