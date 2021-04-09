package com.jdh.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
@Data
public class MemberVO {
	
	@Email(message = "Email 형식으로 작성해주세요")
	private String email;
	
	@NotEmpty(message = "빈값 허용 X")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$", 
	message = "영,특수문자포함 8자리 ~ 20자리 사이로 입력해주세요")
	private String password;
	
	private String phone;
	
	private String birthd;
	
	@Range(min = 1, max = 10000, message = "6자리 미만으로 입력해주세요")
	private int point;
	
	private String registration_date;
}