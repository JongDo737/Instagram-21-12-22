package com.springboot.instagram.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	@GetMapping("/test-get2")
	public String testGet() {
		System.out.println("Get 요청옴.");
		return "get 요청";
	}
	
	@PostMapping("/test-post2")
	public String testPost() {
		System.out.println("Post 요청옴.");
		return "post 요청";
	}
	
	@PutMapping("/test-put2")
	public String testPut() {
		System.out.println("put 요청옴.");
		return "put 요청";
	}
	
	@DeleteMapping("/test-delete2")
	public String testDelete() {
		System.out.println("delete 요청옴.");
		return "delete 요청";
	}
	
	
	
}
