package com.springboot.instagram.config.oauth2;

import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.config.oauth2.provider.Oauth2UserDto;
import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println(userRequest.getClientRegistration());
		System.out.println(userRequest.getAccessToken());
		OAuth2User oAuth2User =  super.loadUser(userRequest);
		Map<String, Object> oAuth2UserAttributes = oAuth2User.getAttributes();
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		// naver
		String providerId = null;
		if(provider.equals("naver")) {
			oAuth2UserAttributes = (Map<String, Object>)oAuth2UserAttributes.get("response"); //response객체를
			providerId = (String)oAuth2UserAttributes.get("id"); //object -> Stirng 형변환
		}
		else {
			providerId = UUID.randomUUID().toString().replaceAll("-", "");
		}
		String oauth2_username = provider + "_" + providerId;
		//naver_mt2S35CEshjGTABwrtEvtN2iqSmQXCNvv3RQSO_io
		
		Oauth2UserDto oAuth2UserDto = Oauth2UserDto.builder()
				.oauth2_username(oauth2_username)
				.email((String)oAuth2UserAttributes.get("email"))
				.name((String)oAuth2UserAttributes.get("name"))
				.provider(providerId)
				.role("ROLE_USER")
				.build();
		
		User userEntity = userRepository.getUserByOAuth2Username(oauth2_username);
		
		//naver 로그인으로 처음할 때 --> 회원가입 시키기
		if(userEntity == null) {
			userEntity = oAuth2UserDto.toEntity();
			userEntity.setPassword(new BCryptPasswordEncoder().encode("qweqwe"));
			userRepository.insertUser(userEntity);
		}
		UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
		
		return new PrincipalDetails(userEntity, userDtlEntity, oAuth2UserAttributes);
	}
}
