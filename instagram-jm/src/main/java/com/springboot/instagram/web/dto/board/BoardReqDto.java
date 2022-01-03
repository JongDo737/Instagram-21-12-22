package com.springboot.instagram.web.dto.board;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.instagram.domain.board.Board;

import lombok.Data;

@Data
public class BoardReqDto {
	private MultipartFile file;
	private String boardContent;
	
	public Board toEntity(int userId, String boardImg) {		
		return Board.builder()
				.board_img(boardImg)
				.board_content(boardContent)
				.user_id(userId)
				.build();
	}
}
