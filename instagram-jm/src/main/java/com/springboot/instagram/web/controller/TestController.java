package com.springboot.instagram.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.instagram.web.dto.TestDto;

@Controller
public class TestController {
	
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String testPage() {
		return "test";
	}
	
	@RequestMapping(value = "/test-submit", method = RequestMethod.POST)
	public String testSubmit(TestDto TestDto) {
		
		return "test";
	}
}
