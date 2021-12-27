package com.springboot.instagram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //해당파일로 시큐리티 활성화
@Configuration //IoC등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests() //서버에 요청이 들어오면
			.antMatchers("/", "/index", "/user/**") //해당 요청들은
			.authenticated() //모두 인증을 거처야한다.
			.anyRequest() //그 외의 모든 요청은
			.permitAll() //승인해준다.(모두 권한을 허가)
			.and() //그리고
			.formLogin() //로그인 화면은
			.loginPage("/auth/signin") //해당 GET요청으로 응답해주면되고
			.loginProcessingUrl("/auth/signin") //로그인 submit 요청시에 Post요청으로 /auth/signin 요청을 해라.
			.defaultSuccessUrl("/"); //로그인에 성공했으면 해당 url로 이동을 해라.
	}
	
}
