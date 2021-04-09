package com.jdh.utils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdh.vo.SeatVO;
import com.jdh.vo.TicketingVO;

@Repository
public class SeatDAOImpl implements SeatDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String MAPPER = "com.jdh.SeatMapper.";
	
	@Override
	public List<SeatVO> selectList(String busName){
		return sqlSession.selectList(MAPPER+"selectList", busName);
	}
	
	@Override
	public int selectCountSeat(TicketingVO vo) {
		return sqlSession.selectOne(MAPPER+"selectCountSeat", vo);
	}
	
	@Override
	public int updateSeat(TicketingVO vo) {
		return sqlSession.update(MAPPER+"updateSeat", vo);
	}

	@Override
	public int updateSeatCancle(TicketingVO vo) {
		return sqlSession.update(MAPPER+"updateSeatCancle", vo);
	}
}
