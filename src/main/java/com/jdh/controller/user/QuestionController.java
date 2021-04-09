package com.jdh.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdh.common.PageMaker;
import com.jdh.common.SearchCriteria;
import com.jdh.service.QuestionService;
import com.jdh.vo.QuestionVO;


@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	//아무나 이용가능
	@RequestMapping(value = "/qnaList")
	public String questionsList(Model model, SearchCriteria cri, PageMaker maker) {
		cri.setStartAndEndRow();
		model.addAttribute("questionList", questionService.selectSearchList(cri));
		maker.setCriteria(cri);
		maker.setTotalRowCount(questionService.totalRowCount(cri));
		return "user/qna/list";
	}
	
	@RequestMapping(value = "/qnaRegister")
	public String qnaRegister() {
		return "user/qna/register";
	}
	
	//로그인한사람만 글 쓰기 가능
	@RequestMapping(value = "/qnaInsert")
	public String insertQna(Model model, QuestionVO vo) {
		if(questionService.qnaInsert(vo) > 0) {
			return "forward:qnaList";
		}
		return "redirect:main";
	}
}
