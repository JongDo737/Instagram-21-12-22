package com.springboot.instagram.service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.web.dto.accounts.ProfileReqDto;

public interface AccountsService {
	public boolean usernameCheck(String username);
	public boolean updateUser(PrincipalDetails principalDetails, ProfileReqDto profileReqDto);
}
