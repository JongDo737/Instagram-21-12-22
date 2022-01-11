package com.springboot.instagram.domain.board;

import java.time.LocalDateTime;

public class IndexBoard {
	private int id;
	
	private String board_img;
	private String board_content;
	
	private int user_id;
	private String username;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
