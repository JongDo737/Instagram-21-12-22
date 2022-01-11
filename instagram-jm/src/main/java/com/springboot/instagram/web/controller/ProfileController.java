package com.springboot.instagram.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.service.BoardService;
import com.springboot.instagram.web.dto.profile.ProfileBoardRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProfileController {
	
	private final BoardService boardService;
	
	@GetMapping("/{username}/board")
	public Object getProfileBoard(@PathVariable String username, @RequestParam int page) {
		ProfileBoardRespDto boardRespDto = boardService.getProfileBoard(username, page);
		return boardRespDto;
	}
}