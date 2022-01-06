package com.springboot.instagram.web.dto.board;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardRespDto {
	private int boardId;
	private String boardImg;
	private String boardContent;
	private int userId;
	private String profileImg;
	private String username;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	
}
