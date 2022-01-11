package com.springboot.instagram.service;

import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.user.Subscribe;
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
	public ProfileRespDto getProfile(PrincipalDetails principalDetails, String username) {
		User userEntity = userRepository.getUserByUsername(username);
		ProfileRespDto profileRespDto = new ProfileRespDto();
		if(userEntity != null) {
			UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
			profileRespDto.setUserId(userEntity.getId());
			profileRespDto.setUsername(username);
			profileRespDto.setProfile_img(userDtlEntity.getProfile_img());
			profileRespDto.setIntroduction(userDtlEntity.getIntroduction());
			if(principalDetails != null) {
				Subscribe subscribeEntity = Subscribe.builder()
												.from_user_id(principalDetails.getUser().getId())
												.to_user_id(userEntity.getId())
												.build();
				if(userRepository.getFollow(subscribeEntity) != null) {
					profileRespDto.setFollow("팔로우 취소");
				}else {
					profileRespDto.setFollow("팔로우");
				}
			}
			
		}
		return profileRespDto;
	}

}
