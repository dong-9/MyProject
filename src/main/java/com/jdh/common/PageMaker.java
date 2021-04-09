package com.jdh.common;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;

@Getter
public class PageMaker {
	private int displayNum = 5;
	private int totalRowCount;
	private int lastPageNum;
	private int startPageNum;
	private int endPageNum;
	private boolean next;
	private boolean prev;
	
	private SearchCriteria criteria;
	
	public void setCriteria(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
		caclData();
	}
	
	public void caclData() {
		endPageNum = (int)(Math.ceil(criteria.getPage() / (double)displayNum) * displayNum);
		startPageNum = endPageNum - displayNum + 1;
		lastPageNum = (int)(Math.ceil(totalRowCount / (double)criteria.getPerPage()));
		
		if(endPageNum > lastPageNum) endPageNum = lastPageNum;
		next = endPageNum == lastPageNum ? false : true;
		prev = startPageNum == 1 ? false : true;
		
	}
	
	public String makeSearchQuery(int page) {
		UriComponents uriComponets = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("searchType", criteria.getSearchType())
				.queryParam("keyword", criteria.getKeyword())
				.build();
		
		return uriComponets.toString();
	}
	
	
	
}