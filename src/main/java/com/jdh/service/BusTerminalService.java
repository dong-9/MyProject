package com.jdh.service;

import java.util.List;

import com.jdh.vo.BusTerminalVO;

public interface BusTerminalService {
	public List<BusTerminalVO> selectList(String area);
}
