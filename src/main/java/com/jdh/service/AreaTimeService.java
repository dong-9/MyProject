package com.jdh.service;

import java.util.List;
import java.util.Map;

import com.jdh.vo.AreaTimeVO;
import com.jdh.vo.TicketingVO;

public interface AreaTimeService {
	
	public List<AreaTimeVO> selectList(String area);
	
	public AreaTimeVO selectOne(Map<String, String> busInfo);
	
	public int updateAreaTime(TicketingVO vo);
}
