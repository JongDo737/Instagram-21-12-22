package com.springboot.instagram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Value("${file.path}") // yml 변수 사용
	private String filePath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 레지스트리 객체를 사용함
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/image/**") //이미지의 하위 모든 요청들은
		.addResourceLocations("file:///" + filePath)
		.setCachePeriod(60*60)// 캐시데이터 60초 * 60 (1시간)
		.resourceChain(true)	//사용이 되면 연결을 허용하겠다
		.addResolver(new PathResourceResolver());
	}
}
