package com.springboot.instagram.service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.web.dto.accounts.PasswordReqDto;
import com.springboot.instagram.web.dto.accounts.PasswordRespDto;
import com.springboot.instagram.web.dto.accounts.ProfileReqDto;

public interface AccountsService {
	public boolean usernameCheck(String username);
	public boolean updateUser(PrincipalDetails principalDetails, ProfileReqDto profileReqDto);
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails, PasswordReqDto passwordReqDto);
}
