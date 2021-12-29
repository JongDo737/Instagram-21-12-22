package com.springboot.instagram.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	// 유저네임(id) 로 검색해서 세션에 저장
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.getUserByUsername(username);
		if(userEntity == null) {
			return null;			
		}else {

			return new PrincipalDetails(userEntity);
			//이렇게 하면 알아서 암호화된 비밀번호를 알아내고
			//알아서 세션객체에 넣어줌 (시큐리티가)
		}
	}

}
