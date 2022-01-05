package com.springboot.instagram.service;

import org.springframework.stereotype.Service;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService{	//other이 profile 볼때 정보들을 가져옴

	private final UserRepository userRepository;
	
	//유저에 대한 정보를 들고와야함
	@Override
	public ProfileRespDto getProfile(String username) { 
		User userEntity = userRepository.getUserByUsername(username);
		UserDtl userDtl = userRepository.getUserDtlById(userEntity.getId());
		
		ProfileRespDto profileRespDto = new ProfileRespDto();
		profileRespDto.setProfile_img(username);
		profileRespDto.setProfile_img(userDtl.getProfile_img());
		profileRespDto.setIntroduction(userDtl.getIntroduction());
		
		return profileRespDto;
	}

}
