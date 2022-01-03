package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.service.BoardService;
import com.springboot.instagram.web.dto.board.BoardReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController {
	
	private final BoardService boardService;
	
	@PostMapping("/upload")
	public boolean uploadInsert(@AuthenticationPrincipal PrincipalDetails principalDetails ,BoardReqDto boardReqDto) {
		return boardService.insertBoard(principalDetails, boardReqDto);
	}
	
}
