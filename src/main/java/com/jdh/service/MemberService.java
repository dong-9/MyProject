package com.jdh.service;

import java.util.List;

import com.jdh.common.SearchCriteria;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

public interface MemberService {
	
	/* common */
	public MemberVO selectOne(MemberVO vo);
	
	public int updateMinPoint(TicketingVO ticket);
	
	public int updateAddPoint(TicketingVO ticket);
	
	/* admin */
	
	public List<MemberVO> selectSearchList(SearchCriteria cri);
	
	public int totalRowCount(SearchCriteria cri);
	
	public int update(MemberVO vo);
	
	public int delete(String[] select_obj);
	
	/* user */
	public int selectCountMyTicket(String email);
	public int updatePassword(MemberVO vo);
	
	public int updatePhone(MemberVO vo);
	
	public int insertMemberInfo(MemberVO vo);
	
	public int deleteUser(MemberVO vo);
}
