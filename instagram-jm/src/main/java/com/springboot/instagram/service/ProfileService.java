package com.springboot.instagram.service;

import com.springboot.instagram.web.dto.profile.ProfileRespDto;

public interface ProfileService {
	public ProfileRespDto getProfile(String username);
}
