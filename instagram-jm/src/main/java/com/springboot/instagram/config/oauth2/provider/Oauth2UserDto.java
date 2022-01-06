package com.springboot.instagram.config.oauth2.provider;

import com.springboot.instagram.domain.user.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Oauth2UserDto {
	private String oauth2_username;
	private String email;
	private String name;
	private String provider;
	private String role;
	
	public User toEntity() {
		return User.builder()
				.username(oauth2_username)
				.oauth2_username(oauth2_username)
				.email(email)
				.provider(provider)
				.role(role)
				.build();
				
	}
}

