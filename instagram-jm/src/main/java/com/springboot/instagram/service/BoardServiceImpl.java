package com.springboot.instagram.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.board.Board;
import com.springboot.instagram.domain.board.BoardRepository;
import com.springboot.instagram.domain.board.ProfileBoard;
import com.springboot.instagram.web.dto.board.BoardReqDto;
import com.springboot.instagram.web.dto.profile.ProfileBoardRespDto;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	@Value("${file.path}")
	private String filePath;

	@Override
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto) {
		String imgFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_"
				+ boardReqDto.getFile().getOriginalFilename();
		String boardImg = "board_img\\" + imgFileName;
		Path imgFilePath = Paths.get(filePath, boardImg);
		// 파일 path 지정

		File file = new File(filePath + "board_img");
		if (!file.exists()) {// 파일이 존재하지 않으면
			file.mkdirs();
		}

		try {
			Files.write(imgFilePath, boardReqDto.getFile().getBytes());
			// imgFilePath 파일 객체에다가 쓰기를 해라 !
			// 우리가 요청때 받은 파일데이터를 쓰는거임
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Board boardEntity = boardReqDto.toEntity(principalDetails.getUser().getId(), boardImg);

		int result = boardRepository.insertBoard(boardEntity);
		if (result == 1) {
			// insert 성공
			return true;
		} else {
			// insert 실패
			return false;
		}

	}

	@Override
	public ProfileRespDto getProfileBoardTotalCount(String username) {
		List<ProfileBoard> boardList = boardRepository.getProfileBoardListByUsername(username);
		ProfileRespDto profileRespDto = new ProfileRespDto();
		profileRespDto.setBoardTotalCount(boardList.size());
		return profileRespDto;
	}

	@Override
	public ProfileBoardRespDto getProfileBoard(String username, int page) {
		List<ProfileBoard> boardListAll = boardRepository.getProfileBoardListByUsername(username);	//전체 보드
		List<List<ProfileBoard>> boardGroup = new ArrayList<List<ProfileBoard>>();	//3개씩 짤라서 들어간 리스트를 담는 리스트
		int boardListTotalCount = boardListAll.size();
		int groupSize = boardListAll.size() % 3 == 0? boardListTotalCount / 3 : (boardListTotalCount / 3) + 1 ; 
		// 100 개 라면 33객 하고 남으면 리스트 3개짜리 한개 더 추가해줌
		
		int j=0;
		
		for(int i =0; i< groupSize; i++) {
			List<ProfileBoard> boardList = new ArrayList<ProfileBoard>();
			for(; j < (i+1) + 3 && j < boardListTotalCount; j++ ) {
				boardList.add(boardListAll.get(j));
			}
			boardGroup.add(boardList);
			
		}
		
		return new ProfileBoardRespDto(boardGroup);
	}

}
