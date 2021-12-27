package com.springboot.instagram.web.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.instagram.domain.user.User;

import lombok.Data;

@Data
public class SignupReqDto {
	@NotBlank
	private String email;
	@NotBlank
	private String name;
	@NotBlank
	@Size(min = 4, max = 20)
	private String username;
	@NotBlank
	private String password;
	
	public User toEntity() {
		return User.builder()
				.email(email)
				.name(name)
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))
				.role("ROLE_USER")
				.build();
	}
}
