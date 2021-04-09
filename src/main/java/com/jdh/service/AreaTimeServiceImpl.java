package com.jdh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdh.utils.AreaTimeDAO;
import com.jdh.vo.AreaTimeVO;
import com.jdh.vo.TicketingVO;

@Service
public class AreaTimeServiceImpl implements AreaTimeService {
	
	@Autowired
	private AreaTimeDAO dao;
	
	@Override
	public List<AreaTimeVO> selectList(String area) {
		return dao.selectList(area);
	}

	@Override
	public AreaTimeVO selectOne(Map<String, String> busInfo) {
		return dao.selectOne(busInfo);
	}
	
	@Override
	public int updateAreaTime(TicketingVO vo) {
		return dao.updateAreaTime(vo);
	}

}
