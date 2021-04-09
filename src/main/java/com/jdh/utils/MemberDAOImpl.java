package com.jdh.utils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdh.common.SearchCriteria;
import com.jdh.security.CustomUserDetails;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private final String MAPPER = "com.jdh.MemberMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	/* 공용 */
	//인증
	@Override
	public CustomUserDetails selectOneUser(String username) {
		return sqlSession.selectOne(MAPPER+"selectOneUser",username);
	}

	//회원정보 가져오기
	@Override
	public MemberVO selectOne(MemberVO vo){
		return sqlSession.selectOne(MAPPER+"selectOne", vo);
	}
	
	@Override
	public int updateMinPoint(TicketingVO ticket) {
		return sqlSession.update(MAPPER+"updateMinPoint", ticket);
	}
	
	@Override
	public int updateAddPoint(TicketingVO ticket) {
		return sqlSession.update(MAPPER+"updateAddPoint", ticket);
	}
	
	/* admin */
	@Override
	public List<MemberVO> selectSearchList(SearchCriteria cri) {
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
	
	@Override
	public int update(MemberVO vo) {
		return sqlSession.update(MAPPER+"update", vo);
	}
	
	
	/* user */
	@Override
	public int selectCountMyTicket(String email) {
		return sqlSession.selectOne(MAPPER+"selectCountMyTicket", email);
	}
	
	@Override
	public int updatePassword(MemberVO vo) {
		return sqlSession.update(MAPPER+"updatePassword", vo);
	}
	
	@Override
	public int updatePhone(MemberVO vo) {
		return sqlSession.update(MAPPER+"updatePhone", vo);
	}
	
	//회원가입
	@Override
	public int insertMemberInfo(MemberVO vo) {
		return sqlSession.insert(MAPPER+"insertMemberInfo", vo);
	}
	
	@Override
	public int deleteUser(MemberVO vo) {
		return sqlSession.delete(MAPPER+"deleteUser", vo);
	}
	
	
}
