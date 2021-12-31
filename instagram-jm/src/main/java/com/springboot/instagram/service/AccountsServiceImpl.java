package com.springboot.instagram.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.accounts.PasswordReqDto;
import com.springboot.instagram.web.dto.accounts.PasswordRespDto;
import com.springboot.instagram.web.dto.accounts.ProfileReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService{
	
	private final UserRepository userRepository;
	
	@Value("${file.path}")
	private String filePath;

	@Override
	public boolean usernameCheck(String username) {
		int result = userRepository.checkUsernameByUsername(username);
		if(result == 0) {
			// 수정 가능한 username
			return true;
		}else {
			// 이미 존재하는 username
			return false;
		}
	}
	
	public void deleteProfileImgFile(PrincipalDetails principalDetails) {
		String imgUrl = principalDetails.getUserDtl().getProfile_img();
		if(!imgUrl.equals("profile_img\\default.png")) {
			File file = new File(imgUrl);
			if(file.exists()) { //해당 경로에 파일이 존재할떄
				file.delete();
				
			}
		}
	}
	
	@Override
	public boolean updateUser(PrincipalDetails principalDetails, ProfileReqDto profileReqDto) {
		int id = principalDetails.getUser().getId();
		String password = principalDetails.getUser().getPassword();
		String profile_img = null;
		
		User userEntity = profileReqDto.toUserEntity(id, password);
		UserDtl userDtlEntity = null;
		
		int result = 0;
		
		if(profileReqDto.getFile() == null) {
			profile_img = principalDetails.getUserDtl().getProfile_img();
		}else {
			String imageFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + profileReqDto.getFile().getOriginalFilename();
			Path imageFilePath = Paths.get(filePath, "profile_img\\" + imageFileName);
			
			File file = new File(filePath + "profile_img");
			if(!file.exists()) {
				file.mkdirs();
			}
			
			try {
				Files.write(imageFilePath, profileReqDto.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			profile_img = "profile_img\\" + imageFileName;
			
			deleteProfileImgFile(principalDetails);
		}
		
		userDtlEntity = profileReqDto.toUserDtlEntity(id, profile_img);
		
		result += userRepository.updateUserById(userEntity);
		result += userRepository.updateUserDtlById(userDtlEntity);
		
		if(result == 2) {
			principalDetails.setUser(userEntity);
			principalDetails.setUserDtl(userDtlEntity);
			return true;
		}else {
			return false;
		}
	}
	//현재 비밀번호 확인
	public boolean prePasswordCheck(String principalPassword, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//일치하면 true 일치 안하면 false
		return encoder.matches(password, principalPassword); //앞에 입력받은값 뒤에 암호화되어진 값
		
	}
	
	@Override
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails, PasswordReqDto passwordReqDto) {
		boolean prePasswordCheckFlag = prePasswordCheck(principalDetails.getPassword(),passwordReqDto.getPrePassword());
		boolean newPasswordCheckFlag = prePasswordCheck(principalDetails.getPassword(),passwordReqDto.getNewPassword());
		PasswordRespDto passwordRespDto = new PasswordRespDto();
		if(prePasswordCheckFlag == false) {
			// 이전비밀번호와 일치 하지 않음
			passwordRespDto.setCode(450);
			passwordRespDto.setMessage("이전 비밀번호가 일치하지 않습니다.");
			
		}else if(newPasswordCheckFlag == true) {
			//새 비밀번호가 이전 비밀번호와 동일
			passwordRespDto.setCode(451);
			passwordRespDto.setMessage("새 비밀번호가 이전 비밀번호와 동일합니다.");
			
		}
		else {
			// 새 비밀번호로 변경
			User userEntity = passwordReqDto.toEntity(principalDetails.getUser().getId());
			int result = userRepository.updatePasswordById(userEntity);
			
			if(result == 1) {
				passwordRespDto.setCode(200);
				passwordRespDto.setMessage("새 비밀번호로 변경되었습니다.");
				principalDetails.getUser().setPassword(userEntity.getPassword());
				// 변경된 사항을 세션에 저장
			}		
		}
		
		return passwordRespDto;
	}

}
