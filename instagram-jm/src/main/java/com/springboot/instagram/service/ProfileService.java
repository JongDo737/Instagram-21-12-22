package com.springboot.instagram.service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

public interface ProfileService {
	public ProfileRespDto getProfile(PrincipalDetails principalDetails,String username);
}
