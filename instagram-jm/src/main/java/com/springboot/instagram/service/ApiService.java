package com.springboot.instagram.service;

public interface ApiService {
	public void follow(int fromUserId, int toUserId);
	public void followCancel(int fromUserId, int toUserId);
}
