package com.jdh.controller.user;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdh.service.AreaTimeService;
import com.jdh.service.MemberService;
import com.jdh.service.SeatService;
import com.jdh.service.TicketingService;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class TicketingController {
	
	Date date = new Date();
	SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy.MM.dd E");
	
	@Autowired
	private AreaTimeService areaTimeService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private TicketingService ticketingService;
	
	@Autowired
	private MemberService memberService;
	
	
	// 로그인 한 사람만
	@RequestMapping(value = "/ticketList")
	public String ticketList(Principal principal, TicketingVO vo, Model model) {
		vo.setEmail(principal.getName());
		List<TicketingVO> list = ticketingService.selectMyTicketList(vo);
		model.addAttribute("myTicketList", list);
		model.addAttribute("serverTime", formattedDate.format(date));
		return "user/myPage/ticketList";
	}
	
	@RequestMapping(value = "/search")
	public String searchTime(Model model, @RequestParam(required = false) String area) {
		if(area == "") {
			return "redirect:main";
		}
		model.addAttribute("serverTime", formattedDate.format(date));
		model.addAttribute("area", area);
		model.addAttribute("areaTimeList", areaTimeService.selectList(area));
		return "user/ticketing/search";
	}
	
	//로그인한사람만
	@RequestMapping(value = "/seat")
	public String seat(Model model, @RequestParam HashMap<String,String> map) {
		model.addAttribute("serverTime", formattedDate.format(date));
		model.addAttribute("seatList", seatService.selectList(map.get("busName")));
		model.addAttribute("bus_info", areaTimeService.selectOne(map));
		model.addAttribute("area", map.get("area"));
		return "user/ticketing/seat";
	}
	
	//로그인한사람만
	@RequestMapping(value = "/insertTicket")
	@ResponseBody
	public String insertTicket(Model model, TicketingVO ticket, MemberVO member) {
		log.info("vo {}", member);
		member = memberService.selectOne(member);
		
		//결제금액이 부족하면 리턴
		if(ticket.getTotal_price() > member.getPoint()) {
			return "noMoney";
		}
		
		//예매하려는 좌석이 이미 있으면 실패
		if(seatService.selectCountSeat(ticket) != 0) {
			return "fail";
		}
		
		//좌석 형식 변환
		ticket.setInsertSeatNumbers();
		/* 티켓 isnert & 좌석 업데이트 & 시간표에 남은좌석 & member point 업데이트 */
		if(ticketingService.insertTicket(ticket) > 0 && seatService.updateSeat(ticket) > 0 
				&& areaTimeService.updateAreaTime(ticket) > 0 && memberService.updateMinPoint(ticket) > 0) {
			return "success";
		}
		
		return "fail";
	}
	
	@RequestMapping(value = "/userCancleTicket")
	@ResponseBody
	public String updateUserCancleTicket(TicketingVO vo) {
		vo = ticketingService.selectMyTicket(vo);
		vo.setUpdateSeatNumbers(vo.getSeat_number());
		//예매취소 & 좌석 업데이트 & 버스시간표 총좌석 & member point 업데이트
		if(ticketingService.updateTicket(vo) > 0 && seatService.updateSeatCancle(vo) > 0 
				&& areaTimeService.updateAreaTime(vo) > 0 && memberService.updateAddPoint(vo) > 0) {
			return "success";
		}
		
		return "fail";
	}
	
}
