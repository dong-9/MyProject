package com.jdh.controller.admin;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdh.common.PageMaker;
import com.jdh.common.SearchCriteria;
import com.jdh.service.MemberService;
import com.jdh.vo.MemberVO;


@Controller
@RequestMapping(value = "/admin/member")
public class MemberManagementController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/list")
	public String memberList(Model model, SearchCriteria cri, PageMaker maker) {
		cri.setStartAndEndRow();
		model.addAttribute("memberList", service.selectSearchList(cri));
		maker.setCriteria(cri);
		maker.setTotalRowCount(service.totalRowCount(cri));
		return "admin/member/list";
	}
	
	@RequestMapping(value = "/modify")
	public String memberModify(Model model, MemberVO vo) {
		vo = service.selectOne(vo);
		if(vo == null) {
			return "forward:list";
		}
		model.addAttribute("memberInfo", vo);
		return "admin/member/modify";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdate(@Valid @ModelAttribute("memberInfo") MemberVO vo, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/member/modify";
		}
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		service.update(vo);
		return "redirect:list";
	}

	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String memberDelete(@RequestParam String[] select_obj) {
		if(service.delete(select_obj) > 0) {
			return "삭제완료";
		}
		return "삭제실패";
	}
	
}
