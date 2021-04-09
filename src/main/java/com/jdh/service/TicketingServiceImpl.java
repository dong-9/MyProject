package com.jdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdh.common.SearchCriteria;
import com.jdh.utils.TicketingDAO;
import com.jdh.vo.TicketingVO;

@Service
public class TicketingServiceImpl implements TicketingService {
	
	@Autowired
	private TicketingDAO dao;
	
	@Override
	public List<TicketingVO> selectList() {
		return dao.selectList();
	}

	@Override
	public List<TicketingVO> selectSearchList(SearchCriteria cri) {
		return dao.selectSearchList(cri);
	}

	@Override
	public int totalRowCount(SearchCriteria cri) {
		return dao.totalRowCount(cri);
	}

	@Override
	public int delete(String[] select_obj) {
		return dao.delete(select_obj);
	}


	@Override
	public int updateTicket(TicketingVO vo) {
		return dao.updateTicket(vo);
	}

	@Override
	public TicketingVO selectMyTicket(TicketingVO vo) {
		return dao.selectMyTicket(vo);
	}
	
	
	@Override
	public List<TicketingVO> selectMyTicketList(TicketingVO vo) {
		return dao.selectMyTicketList(vo);
	}
	
	@Override
	public int insertTicket(TicketingVO vo) {
		return dao.insertTicket(vo);
	}


}
