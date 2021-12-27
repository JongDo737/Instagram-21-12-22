package com.springboot.instagram.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.instagram.web.dto.TestDto;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String testPage() {
		return "test";
	}
	
	@RequestMapping(value = "/test-submit", method = RequestMethod.POST)
	public String testSubmit(TestDto testDto) {
		System.out.println(testDto);
		return "test";
	}
	
	@GetMapping("/test-get")
	public String testGet() {
		System.out.println("Get 요청옴.");
		return "test";
	}
	
	@PostMapping("/test-post")
	public String testPost() {
		System.out.println("Post 요청옴.");
		return "test";
	}
	
	@PutMapping("/test-put")
	public String testPut() {
		System.out.println("put 요청옴.");
		return "test";
	}
	
	@DeleteMapping("/test-delete")
	public String testDelete() {
		System.out.println("delete 요청옴.");
		return "test";
	}
	
	
	
}
