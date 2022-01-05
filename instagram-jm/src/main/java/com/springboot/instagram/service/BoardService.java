package com.springboot.instagram.service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.web.dto.board.BoardReqDto;
import com.springboot.instagram.web.dto.profile.ProfileBoardRespDto;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

public interface BoardService {
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto);
	public ProfileRespDto getProfileBoardTotalCount(String username);
	public ProfileBoardRespDto getProfileBoard(String username, int page);
}
