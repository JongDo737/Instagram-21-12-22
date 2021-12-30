package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.config.auth.PrincipalDetails;

@RestController
public class AccountsController {
	
	@PutMapping("/accounts/edit")
	public Object profileEdit(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		return null;
	}
}
