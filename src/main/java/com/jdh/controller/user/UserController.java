package com.jdh.controller.user;


import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdh.service.BusTerminalService;
import com.jdh.service.MemberService;
import com.jdh.service.SendMailService;
import com.jdh.service.TicketingService;
import com.jdh.vo.BusTerminalVO;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SendMailService sendMailService;
	
	@Autowired
	private BusTerminalService busTerminalService;
	
	@Autowired
	private TicketingService ticketingService;
	
	
	@RequestMapping(value = {"/main", "/"})
	public String main(Authentication auth, Model model) {
		if(auth != null) {
			TicketingVO vo = new TicketingVO();
			vo.setEmail(auth.getName());
			model.addAttribute("myTicketList", ticketingService.selectMyTicketList(vo));
		}
		Date date = new Date();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy. MM. dd E");
		model.addAttribute("serverTime", formattedDate.format(date));
		return "user/main/main";
	}
	
	@RequestMapping(value = "kakaoMap")
	public String kakaoMap() {
		return "user/terminal/kakaoMap";
	}
	
	@RequestMapping(value = "/login")
	public String loginForm() {
		log.info("시큐리티 로그인 폼 요청");
		return "user/login/login";
	}
	
	@RequestMapping(value = "/findID")
	public String findIDForm() {
		log.info("ID찾기 폼 요청");
		return "user/login/findID";
	}
	
	@RequestMapping(value = "/findPW")
	public String findPWForm() {
		log.info("PW찾기 폼 요청");
		return "user/login/findPW";
	}
	
	@RequestMapping(value = "/join")
	public String joinForm() {
		log.info("회원가입 폼 요청");
		return "user/join/join";
	}
	
	@RequestMapping(value = "/changeNumber")
	public String changeNumberForm() {
		return "user/myPage/changeNumber";
	}
	
	@RequestMapping(value = "/changePW")
	public String changePWForm() {
		return "user/myPage/changePW";
	}
	
	//아무나 이용가능, 터미널 리스트 FORM
	@RequestMapping(value = "/terminal")
	public String terminal() {
		log.info("터미널 리스트 요청");
		return "user/terminal/terminal";
	}
	
	//로그인 한 사람만, Session으로 email 꺼내기
	@RequestMapping(value = "/myPage")
	public String myPage(Principal principal, Model model, MemberVO vo) {
		String email = principal.getName();
		log.info("principal userID => {}", principal.getName());
		vo.setEmail(email);
		vo = service.selectOne(vo);
		model.addAttribute("myTicketCount", service.selectCountMyTicket(email));
		model.addAttribute("user", vo);
		return "user/myPage/home";
	}
	
	@RequestMapping(value = "changeNumber", method = RequestMethod.POST)
	@ResponseBody
	public String changeNumber(MemberVO vo) {
		String password = vo.getPassword();
		String phone = vo.getPhone();
		vo = service.selectOne(vo);
		if(!passwordEncoder.matches(password, vo.getPassword())) {
			return "fail";
		}
		vo.setPhone(phone);
		service.updatePhone(vo);
		return "success";
	}
	
	@RequestMapping(value = "changePW", method = RequestMethod.POST)
	@ResponseBody
	public String changePW(MemberVO vo, @RequestParam String newPassword) {
		String password = vo.getPassword();
		vo = service.selectOne(vo);
		if(!passwordEncoder.matches(password, vo.getPassword())) {
			return "fail";
		}
		vo.setPassword(passwordEncoder.encode(newPassword));
		service.updatePassword(vo);
		return "success";
	}
	
	@RequestMapping(value = "/delUser")
	@ResponseBody
	public String deleteUser(MemberVO vo) {
		String password = vo.getPassword();
		vo = service.selectOne(vo);
		if(!passwordEncoder.matches(password, vo.getPassword())) {
			return "false";
		}
		service.deleteUser(vo); 
		return "success";
	}
	

	//AJAX 터미널 리스트 데이터 요청
	@RequestMapping(value = "/terminalList")
	@ResponseBody
	public List<BusTerminalVO> terminalList(@RequestParam String area){
		return busTerminalService.selectList(area);
	}
	
	//ID,PW찾기, 중복확인 공용
	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> findUser(MemberVO vo) {
		Map<String, String> map = new HashMap<String, String>();
		vo = service.selectOne(vo);
		if(vo == null) {
			map.put("type", "fail");
			return map;
		}
		map.put("email", vo.getEmail());
		map.put("type", "success");
		return map;
	}
	
	//이메일전송
	@RequestMapping(value = "sendEmail")
	public String sendEmail(MemberVO vo) {
		if(sendMailService.sendEmail(vo)) {
			return "redirect:login";
		}
		return "findID";
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@Valid MemberVO vo, BindingResult result) {
		if(!result.hasErrors()) {
			vo.setPassword(passwordEncoder.encode(vo.getPassword()));
			if(service.insertMemberInfo(vo) > 0) {
				return "user/login/login";
			}
		}
		return "user/join/join";
	}
	
}
