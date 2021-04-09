package com.jdh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdh.common.PageMaker;
import com.jdh.common.SearchCriteria;
import com.jdh.service.QuestionService;
import com.jdh.vo.QuestionVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/admin/questions")
public class QuestionManagementController {

	@Autowired
	private QuestionService service;
	
	@RequestMapping(value = "/list")
	public String questionsList(Model model, SearchCriteria cri, PageMaker maker) {
		cri.setStartAndEndRow();
		model.addAttribute("questionList", service.selectSearchList(cri));
		maker.setCriteria(cri);
		maker.setTotalRowCount(service.totalRowCount(cri));
		return "admin/questions/list";
	}
	
	@RequestMapping(value = "/detail")
	public String questionsDetail(Model model, QuestionVO vo) {
		vo = service.selectOne(vo);
		model.addAttribute("questionInfo", vo);
		return "admin/questions/detail";
	}
	
	@RequestMapping(value = "/update")
	public String questionUpdate(Model model, QuestionVO vo) {
		service.update(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String questionDelete(@RequestParam String[] select_obj) {
		if(service.delete(select_obj) > 0) {
			log.info("삭제완료");
			return "삭제완료";
		}
		return "삭제실패";
	}
	
}
