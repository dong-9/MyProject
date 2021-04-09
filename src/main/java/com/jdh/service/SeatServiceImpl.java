package com.jdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdh.utils.SeatDAO;
import com.jdh.vo.SeatVO;
import com.jdh.vo.TicketingVO;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatDAO dao;

	@Override
	public List<SeatVO> selectList(String busName) {
		return dao.selectList(busName);
	}
	
	@Override
	public int selectCountSeat(TicketingVO vo) {
		return dao.selectCountSeat(vo);
	}
	
	@Override
	public int updateSeat(TicketingVO vo) {
		return dao.updateSeat(vo);
	}
	
	@Override
	public int updateSeatCancle(TicketingVO vo) {
		return dao.updateSeatCancle(vo);
	}

}
