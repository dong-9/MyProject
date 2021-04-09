package com.jdh.utils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdh.vo.AreaTimeVO;
import com.jdh.vo.TicketingVO;

@Repository
public class AreaTimeDAOImpl implements AreaTimeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String MAPPER = "com.jdh.AreaTimeMapper.";
	
	@Override
	public List<AreaTimeVO> selectList(String area){
		return sqlSession.selectList(MAPPER+"selectList", area);
	}
	
	@Override
	public AreaTimeVO selectOne(Map<String, String> busInfo) {
		return sqlSession.selectOne(MAPPER+"selectOne", busInfo);
	}
	
	@Override
	public int updateAreaTime(TicketingVO vo) {
		return sqlSession.update(MAPPER+"updateAreaTime", vo);
	}
}
