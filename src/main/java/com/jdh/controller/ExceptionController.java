package com.jdh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleError404(Model model, HttpServletRequest request, Exception e) {
		model.addAttribute("message", "404오류");
		model.addAttribute("url", request.getRequestURL());
		return "error/404";
	}
	
	/* Exception 타입으로 처리하는 모든 예외를 처리하도록 설정*/
	@ExceptionHandler(Exception.class)
	public String commonException(Model model, Exception e, HttpServletRequest request) {
		model.addAttribute("exception", e);  
		model.addAttribute("url", request.getRequestURL());
		return "error/exception";
	}
}
