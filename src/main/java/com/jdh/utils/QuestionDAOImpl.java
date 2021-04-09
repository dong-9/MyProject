package com.jdh.utils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdh.common.SearchCriteria;
import com.jdh.vo.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	private final String MAPPER = "com.jdh.QuestionMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<QuestionVO> selectList(){
		return sqlSession.selectList(MAPPER+"selectList");
	}
	
	@Override
	public List<QuestionVO> selectSearchList(SearchCriteria cri){
		return sqlSession.selectList(MAPPER+"selectSearchList", cri);
	}
	
	@Override
	public QuestionVO selectOne(QuestionVO vo) {
		return sqlSession.selectOne(MAPPER+"selectOne", vo);
	}
	
	@Override
	public int totalRowCount(SearchCriteria cri) {
		return sqlSession.selectOne(MAPPER+"totalRowCount", cri);
	}
	
	@Override
	public int update(QuestionVO vo) {
		return sqlSession.update(MAPPER+"update", vo);
	}
	
	@Override
	public int delete(String[] select_obj) {
		return sqlSession.delete(MAPPER+"delete", select_obj);
	}
	
	@Override
	public int qnaInsert(QuestionVO vo) {
		return sqlSession.insert(MAPPER+"qnaInsert", vo);
	}
}
