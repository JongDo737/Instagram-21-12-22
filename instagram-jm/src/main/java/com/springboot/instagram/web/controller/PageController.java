package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.instagram.config.auth.PrincipalDetails;

@Controller
public class PageController {
	
	@GetMapping({"/", "/index"})
	public String indexForm(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println(principalDetails.getUser());
		System.out.println(principalDetails.getUser().getId());
		return "test";
	}
	
	@GetMapping("/auth/signin")
	public String siginForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	@GetMapping("/accounts/edit")
	public String accountEditForm(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		//계정 정보들이 들어가있음
		return "account/accounts_edit";
	}
	
}
