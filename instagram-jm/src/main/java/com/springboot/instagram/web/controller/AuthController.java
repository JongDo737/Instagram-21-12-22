package com.springboot.instagram.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.web.dto.auth.SignupReqDto;
import com.springboot.instagram.web.dto.auth.SignupRespDto;

@RestController
public class AuthController {
	
	
	@PostMapping("/auth/signup")
	public Object signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult ) {
		System.out.println(signupReqDto);
		
		if(bindingResult.hasErrors()) {
			//System.out.println("벨리데이션 체크 오류");
			Map<String, String> errorMap = new HashMap<String,String>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				// 에러맵에다가 담는데 에러필드명(변수), 어떤 에러인지
			}
			SignupRespDto<Map<String, String>> signupRespDto = new SignupRespDto<Map<String,String>>();
			signupRespDto.setCode(400);
			signupRespDto.setData(errorMap);
			return signupRespDto;
		
		}
		else {
			//System.out.println("벨리데이션 체크 성공");
		}
		
		
		return null;
	}
	
	
}
