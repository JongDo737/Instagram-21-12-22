package com.springboot.instagram.service;

import org.springframework.validation.BindingResult;

import com.springboot.instagram.web.dto.auth.SignupReqDto;
import com.springboot.instagram.web.dto.auth.SignupRespDto;

public interface AuthService {
	public SignupRespDto<?> validCheck(SignupReqDto signupReqDto, BindingResult bindingResult);
}
