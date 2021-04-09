package com.jdh.utils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdh.common.SearchCriteria;
import com.jdh.vo.TicketingVO;

@Repository
public class TicketingDAOImpl implements TicketingDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private final String MAPPER = "com.jdh.TicketingMapper.";
	
	/* admin */
	@Override
	public List<TicketingVO> selectList(){
		return sqlSession.selectList(MAPPER+"selectList");
	}
	
	@Override
	public List<TicketingVO> selectSearchList(SearchCriteria cri){
		return sqlSession.selectList(MAPPER+"selectSearchList", cri);
	}
	
	@Override
	public int totalRowCount(SearchCriteria cri) {
		return sqlSession.selectOne(MAPPER+"totalRowCount", cri);
	}
	
	@Override
	public int delete(String[] select_obj) {
		return sqlSession.delete(MAPPER+"delete", select_obj);
	}
	
	//예매취소
	@Override
	public int updateTicket(TicketingVO vo) {
		return sqlSession.update(MAPPER+"updateTicket", vo);
	}
	
	@Override
	public TicketingVO selectMyTicket(TicketingVO vo) {
		return sqlSession.selectOne(MAPPER+"selectMyTicket", vo);
	}
	
	
	/* user */
	//예매내역
	@Override
	public List<TicketingVO> selectMyTicketList(TicketingVO vo) {
		return sqlSession.selectList(MAPPER+"selectMyTicketList", vo);
	}
	
	//예매
	@Override
	public int insertTicket(TicketingVO vo) {
		return sqlSession.insert(MAPPER+"insertTicket", vo);
	}
}
