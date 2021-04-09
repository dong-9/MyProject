package com.jdh.service;

import com.jdh.vo.MemberVO;

public interface SendMailService {
	public boolean sendEmail(MemberVO vo);
}
