package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.service.BoardService;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PageController {
	private final BoardService boardService;
	
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
	public String accountsEditForm() {
		return "accounts/accounts_edit";
	}
	
	@GetMapping("/accounts/password/change")
	public String accountsPasswordForm() {
		return "accounts/accounts_password";
	}
	
	@GetMapping("/upload")
	public String uploadForm() {
		return "upload/upload";
	}
	
	@GetMapping("/{username}")
	public String profileForm(Model model, @PathVariable String username, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		ProfileRespDto profileRespDto = boardService.getProfileBoardTotalCount(username);
		if(principalDetails != null && principalDetails.getUser().getUsername().equals(username)) {
			profileRespDto.setUsername(username);
			profileRespDto.setProfile_img(principalDetails.getUserDtl().getProfile_img());
			profileRespDto.setIntroduction(principalDetails.getUserDtl().getIntroduction());
			
			model.addAttribute("profileRespDto", profileRespDto);
			
			return "profile/my_profile";
		}else {
			return "profile/my_profile";
		}
	}
	
}