package com.jdh.service;

import java.util.List;

import com.jdh.common.SearchCriteria;
import com.jdh.vo.TicketingVO;

public interface TicketingService {

	public List<TicketingVO> selectList();
	
	public List<TicketingVO> selectSearchList(SearchCriteria cri);
	
	public int totalRowCount(SearchCriteria cri);
	
	public int delete(String[] select_obj);

	public int updateTicket(TicketingVO vo);
	
	
	public TicketingVO selectMyTicket(TicketingVO vo);
	
	
	public List<TicketingVO> selectMyTicketList(TicketingVO vo);
	
	public int insertTicket(TicketingVO vo);
	
}
