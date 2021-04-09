package com.jdh.utils;

import java.util.List;

import com.jdh.common.SearchCriteria;
import com.jdh.vo.QuestionVO;

public interface QuestionDAO {
	
	public List<QuestionVO> selectList();
	
	public List<QuestionVO> selectSearchList(SearchCriteria cri);
	
	public QuestionVO selectOne(QuestionVO vo);
	
	public int totalRowCount(SearchCriteria cri);
	
	public int update(QuestionVO vo);
	
	public int delete(String[] select_obj);
	
	public int qnaInsert(QuestionVO vo);
}
