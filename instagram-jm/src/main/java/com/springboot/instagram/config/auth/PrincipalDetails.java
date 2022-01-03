package com.springboot.instagram.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private User user;
	private UserDtl userDtl;
	

	
	public PrincipalDetails(User user, UserDtl userDtl) {
		this.user = user;
		this.userDtl = userDtl;
	}
	
	@Override  // 권한 가져다 쓸때 (시큐리티가)
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//권한 컬렉션ㄴ -> 리스트 셋의 부모인터페이스이다.
		// 여러개의 데이터를 컬렉션에 담을 수 있음.\
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
		collection.add(new GrantedAuthority() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정이 만료되었는지 확인
		// 예) 한달동안 로그인이 안됐을때 등
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//비밀번호 5번 이상 틀리면 잠김
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 자격 증명 만료거 되지 않았는지 확인
		return true;
	}

	@Override
	public boolean isEnabled() {
		//휴먼계정
		return true;
	}
	
	

}
