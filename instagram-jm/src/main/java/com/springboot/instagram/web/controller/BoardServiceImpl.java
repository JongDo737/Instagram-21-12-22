package com.springboot.instagram.web.controller;

import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.board.Board;
import com.springboot.instagram.domain.board.BoardRepository;
import com.springboot.instagram.service.BoardService;
import com.springboot.instagram.web.dto.board.BoardReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepository;

	@Override
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto) {
		Board boardEntity = boardReqDto.toEntity(principalDetails.getUser().getId());
		return false;
	}
}
