package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.service.AccountsService;
import com.springboot.instagram.web.dto.accounts.ProfileReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountsController {
	
	private final AccountsService accountsService;
	
	@GetMapping("/accounts/username-check")
	public boolean usernameCheck(@RequestParam String username) {
		return accountsService.usernameCheck(username);
	}
	
	@PutMapping("/accounts/edit")
	public boolean profileEdit(@AuthenticationPrincipal PrincipalDetails principalDetails, ProfileReqDto profileReqDto) {
		return accountsService.updateUser(principalDetails, profileReqDto);
	}
	
	
}
