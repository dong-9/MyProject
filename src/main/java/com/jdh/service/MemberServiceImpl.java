package com.jdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdh.common.SearchCriteria;
import com.jdh.utils.MemberDAO;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	
	/* common */
	@Override
	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int updateMinPoint(TicketingVO ticket) {
		return dao.updateMinPoint(ticket);
	}
	
	@Override
	public int updateAddPoint(TicketingVO ticket) {
		return dao.updateAddPoint(ticket);
	}
	
	
	/* admin */
	
	@Override
	public List<MemberVO> selectSearchList(SearchCriteria cri) {
		return dao.selectSearchList(cri);
	}

	@Override
	public int totalRowCount(SearchCriteria cri) {
		return dao.totalRowCount(cri);
	}
	
	@Override
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	
	@Override
	public int delete(String[] select_obj) {
		return dao.delete(select_obj);
	}
	
	/* user */
	@Override
	public int selectCountMyTicket(String email) {
		return dao.selectCountMyTicket(email);
	}
	
	@Override
	public int updatePassword(MemberVO vo) {
		return dao.updatePassword(vo);
	}
	
	@Override
	public int updatePhone(MemberVO vo) {
		return dao.updatePhone(vo);
	}
	
	@Override
	public int insertMemberInfo(MemberVO vo) {
		return dao.insertMemberInfo(vo);
	}

	@Override
	public int deleteUser(MemberVO vo) {
		return dao.deleteUser(vo);
	}
}
