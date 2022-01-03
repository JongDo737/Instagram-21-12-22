package com.springboot.instagram.domain.board;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileBoard {
	private int id;
	private String board_img;
	private String board_content;
	
	private int user_id;
	private String username;
	
	private LocalDateTime update_date;
}
