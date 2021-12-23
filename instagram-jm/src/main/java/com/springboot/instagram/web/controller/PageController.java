package com.springboot.instagram.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping({"/", "index"})
	public String indexForm() {
		return null;
	}
	
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
}
