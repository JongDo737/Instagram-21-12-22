package com.springboot.instagram.domain.board;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IndexBoard {
	private int id;
	
	private String board_img;
	private String board_content;
	
	private int user_id;
	private String username;
	private String profile_img;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
