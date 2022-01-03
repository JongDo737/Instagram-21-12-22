package com.springboot.instagram.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.auth.SignupReqDto;
import com.springboot.instagram.web.dto.auth.SignupRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	
	@Override
	public SignupRespDto<?> validCheck(SignupReqDto signupReqDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			SignupRespDto<Map<String, String>> signupRespDto = new SignupRespDto<Map<String,String>>();
			signupRespDto.setCode(400);
			signupRespDto.setData(errorMap);
			
			return signupRespDto;
		}else {
			int checkUsernameResult = userRepository.checkUsernameByUsername(signupReqDto.getUsername());
			SignupRespDto<String> signupRespDto = new SignupRespDto<String>();
			
			if(checkUsernameResult == 0) {
				// 회원가입 가능
				User userEntity = signupReqDto.toEntity();
				userRepository.insertUser(userEntity);
				signupRespDto.setCode(200);
				signupRespDto.setData("회원가입 성공.");
			}else {
				// 회원가입 불가능(username 중복)
				signupRespDto.setCode(401);
				signupRespDto.setData("이미 존재하는 아이디입니다.");
			}
			
			return signupRespDto;
		}
	}

}
