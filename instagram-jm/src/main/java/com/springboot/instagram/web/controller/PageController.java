package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.instagram.config.auth.PrincipalDetails;

@Controller
public class PageController {
	
	@GetMapping({"/", "/index"})
	public String indexForm() {
		return "index";
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
	public String accountEditForm() {
		return "accounts/accounts_edit";
	}
	
	@GetMapping("/accounts/password/change")
	public String accountPasswordForm() {
		return "accounts/accounts_password";
	}
	
}
