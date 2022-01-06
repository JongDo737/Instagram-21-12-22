package com.springboot.instagram.domain.board;

import java.time.LocalDateTime;

import com.springboot.instagram.web.dto.board.BoardRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	private int id;
	
	private String board_img;
	private String board_content;
	private int user_id;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public BoardRespDto toBoardRespDto() {
		return BoardRespDto.builder()
				.boardId(id)
				.boardImg(board_img)
				.boardContent(board_content)
				.userId(user_id)
				.create_date(create_date)
				.update_date(update_date)
				.build();
	}
}