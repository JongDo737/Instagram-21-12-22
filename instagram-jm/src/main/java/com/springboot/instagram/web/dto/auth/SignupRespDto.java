package com.springboot.instagram.web.dto.auth;

import lombok.Data;

@Data
public class SignupRespDto<T> {
	private int code;
	private T data;
	//제네릭을 쓴이유는 벨리데이션 오류 땐 map 을 담고
	//성공 땐 String 값을 담기 위함
	
}
