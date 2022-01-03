package com.springboot.instagram.service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.web.dto.board.BoardReqDto;

public interface BoardService {
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto);
}
