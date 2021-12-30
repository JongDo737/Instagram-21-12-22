package com.springboot.instagram.domain.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDtl {
	private int id;
	private String website;
	private String introduction;
	private String phone;
	private String gender;
	private String profile_img;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
