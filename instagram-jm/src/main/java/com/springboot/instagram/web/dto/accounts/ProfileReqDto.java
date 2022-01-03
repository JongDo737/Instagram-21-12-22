package com.springboot.instagram.web.dto.accounts;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;

import lombok.Data;

@Data
public class ProfileReqDto {
	private String name;
	private String username;
	private String website;
	private String introduction;
	private String email;
	private String phone;
	private String gender;
	
	private MultipartFile file;
	
	public User toUserEntity(int id, String password) {
		return User.builder()
				.id(id)
				.password(password)
				.email(email)
				.name(name)
				.username(username)
				.build();
	}
	
	public UserDtl toUserDtlEntity(int id, String profile_img) {
		return UserDtl.builder()
				.id(id)
				.website(website)
				.introduction(introduction)
				.phone(phone)
				.gender(gender)
				.profile_img(profile_img)
				.build();
	}
}
