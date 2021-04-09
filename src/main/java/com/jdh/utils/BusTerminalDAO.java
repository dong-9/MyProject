package com.jdh.utils;

import java.util.List;

import com.jdh.vo.BusTerminalVO;

public interface BusTerminalDAO {
	
	public List<BusTerminalVO> selectList(String area);
}
