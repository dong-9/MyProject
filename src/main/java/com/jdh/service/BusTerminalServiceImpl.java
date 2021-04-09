package com.jdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdh.utils.BusTerminalDAO;
import com.jdh.vo.BusTerminalVO;

@Service
public class BusTerminalServiceImpl implements  BusTerminalService {
	
	@Autowired
	private BusTerminalDAO dao;
	
	@Override
	public List<BusTerminalVO> selectList(String area) {
		return dao.selectList(area);
	}

}
