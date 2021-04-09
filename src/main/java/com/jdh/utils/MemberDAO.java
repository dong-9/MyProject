package com.jdh.utils;

import java.util.List;

import com.jdh.common.SearchCriteria;
import com.jdh.security.CustomUserDetails;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

public interface MemberDAO {
	
	public CustomUserDetails selectOneUser(String username);

	public MemberVO selectOne(MemberVO vo);
	
	public int updateMinPoint(TicketingVO ticket);
	
	public int updateAddPoint(TicketingVO ticket);
	
	public List<MemberVO> selectSearchList(SearchCriteria cri);
	
	public int totalRowCount(SearchCriteria cri);
	
	public int delete(String[] select_obj);
	
	public int update(MemberVO vo);
	
	public int selectCountMyTicket(String email);
	
	public int updatePassword(MemberVO vo);
	
	public int updatePhone(MemberVO vo);
	
	public int insertMemberInfo(MemberVO vo);
	
	public int deleteUser(MemberVO vo);
}
