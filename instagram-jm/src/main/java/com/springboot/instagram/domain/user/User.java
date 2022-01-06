package com.springboot.instagram.domain.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private int id;
	
	private String email;
	private String name;
	private String username;
	private String oauth2_username;
	private String password;
	private String provider;
	private String role;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
