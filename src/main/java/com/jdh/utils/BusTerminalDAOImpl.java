package com.jdh.utils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdh.vo.BusTerminalVO;

@Repository
public class BusTerminalDAOImpl implements BusTerminalDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String MAPPER = "com.jdh.BusTerminalMapper.";
	
	public List<BusTerminalVO> selectList(String area){
		return sqlSession.selectList(MAPPER+"selectList", area);
	}
}
