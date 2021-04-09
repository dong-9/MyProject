package com.jdh.utils;

import java.util.List;

import com.jdh.vo.SeatVO;
import com.jdh.vo.TicketingVO;

public interface SeatDAO {
	
	public List<SeatVO> selectList(String busName);
	
	public int selectCountSeat(TicketingVO vo);
	
	public int updateSeat(TicketingVO vo);

	public int updateSeatCancle(TicketingVO vo);
}
