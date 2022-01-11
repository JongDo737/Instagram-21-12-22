
package com.springboot.instagram.service;

import org.springframework.stereotype.Service;

import com.springboot.instagram.domain.user.Subscribe;
import com.springboot.instagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApiServiceImpl implements ApiService {
	
	private final UserRepository userRepository;

	@Override
	public void follow(int fromUserId, int toUserId) {
		Subscribe subscribeEntity = Subscribe.builder()
										.from_user_id(fromUserId)
										.to_user_id(toUserId)
										.build();
		userRepository.follow(subscribeEntity);
	}

	@Override
	public void followCancel(int fromUserId, int toUserId) {
		Subscribe subscribeEntity = Subscribe.builder()
										.from_user_id(fromUserId)
										.to_user_id(toUserId)
										.build();
		userRepository.followCancel(subscribeEntity);
	}
	
	
}