package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.service.ApiService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final ApiService apiService;
	
	@PostMapping("/follow/{userId}")
	public int follow(@AuthenticationPrincipal PrincipalDetails principalDetails ,@PathVariable int userId) {
		apiService.follow(principalDetails.getUser().getId(), userId);
		
		
		return 1;
	}
	@DeleteMapping("/follow/{userId}")
	public int followCancel(@AuthenticationPrincipal PrincipalDetails principalDetails ,@PathVariable int userId) {
		apiService.followCancel(principalDetails.getUser().getId(), userId);
		
		return 1;
	}
}
