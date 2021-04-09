package com.jdh.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdh.common.PageMaker;
import com.jdh.common.SearchCriteria;
import com.jdh.service.TicketingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/admin/ticketing")
public class TicketManagementController {
	
	@Autowired
	private TicketingService service;
	
	@RequestMapping(value = "/list")
	public String list(Model model, SearchCriteria cri, PageMaker maker) {
		Date date = new Date();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy.MM.dd E");
		model.addAttribute("serverTime", formattedDate.format(date));

		cri.setStartAndEndRow();
		model.addAttribute("ticketingList", service.selectSearchList(cri));
		maker.setCriteria(cri);
		maker.setTotalRowCount(service.totalRowCount(cri));
		return "admin/ticketing/list";
	}

	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(@RequestParam String[] select_obj) {
		if(service.delete(select_obj) > 0) {
			log.info("삭제완료");
			return "삭제완료";
		}
		return "삭제실패";
	}
	
}