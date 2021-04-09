package com.jdh.service;

import java.util.List;

import com.jdh.vo.SeatVO;
import com.jdh.vo.TicketingVO;

public interface SeatService {
	
	public List<SeatVO> selectList(String busName);
	public int selectCountSeat(TicketingVO vo);

	
	public int updateSeat(TicketingVO vo);
	
	public int updateSeatCancle(TicketingVO vo);
}
