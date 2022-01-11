package com.springboot.instagram.domain.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subscribe {
	private int from_user_id;
	private String from_username;
	private int to_user_id;
	private String to_username;
	private LocalDateTime create_date;

}
