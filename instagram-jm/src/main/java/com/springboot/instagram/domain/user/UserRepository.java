package com.springboot.instagram.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int checkUsernameByUsername(String username);
	public int insertUser(User user);
	public User getUserByUsername(String username);
	public UserDtl getUserDtlById(int id);
	
	//accounts
	public int updateUserById(User user);
	public int updateUserDtlById(UserDtl userDtl);
}
