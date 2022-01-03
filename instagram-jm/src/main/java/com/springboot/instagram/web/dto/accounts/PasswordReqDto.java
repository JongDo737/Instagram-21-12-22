package com.springboot.instagram.web.dto.accounts;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.instagram.domain.user.User;

import lombok.Data;

@Data
public class PasswordReqDto {
	
	//ajax에서 날린 데이터 값이 담김
	private String prePassword;
	private String newPassword;

	public User toEntity(int id) {
		return User.builder()
				.id(id)
				.password(new BCryptPasswordEncoder().encode(newPassword))
				.build();
	}
}