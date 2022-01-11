package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/board/{boardId}")
	public Object getBoard(@PathVariable int boardId) {
		
		return boardService.getBoard(boardId);
	}
	@GetMapping("/index/board")
	public Object getIndexBoard(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestParam int page) {
		return boardService.getIndexBoardList(principalDetails.getUsername(), page);
	}
}
