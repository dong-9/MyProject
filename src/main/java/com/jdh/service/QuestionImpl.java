package com.jdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdh.common.SearchCriteria;
import com.jdh.utils.QuestionDAO;
import com.jdh.vo.QuestionVO;

@Service
public class QuestionImpl implements QuestionService {
	@Autowired
	private QuestionDAO dao;
	
	@Override
	public List<QuestionVO> selectList() {
		return dao.selectList();
	}
	
	@Override
	public List<QuestionVO> selectSearchList(SearchCriteria cri) {
		return dao.selectSearchList(cri);
	}
	
	@Override
	public QuestionVO selectOne(QuestionVO vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int totalRowCount(SearchCriteria cri) {
		return dao.totalRowCount(cri);
	}

	@Override
	public int update(QuestionVO vo) {
		return dao.update(vo);
	}
	
	@Override
	public int delete(String[] select_obj) {
		return dao.delete(select_obj);
	}
	
	@Override
	public int qnaInsert(QuestionVO vo) {
		return dao.qnaInsert(vo);
	}
}
