package com.springboot.instagram.boardstudy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.instagram.boardstudy.db.BRepository;
import com.springboot.instagram.boardstudy.db.BoardStudy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/study")
public class BoardStudyController {

	private final BRepository bRepository;
	
	@Value("${test.filename}")
	private String filename;
	
	@Value("${file.path}")
	private String filePath;
	
	@GetMapping("/file")
	public String file() {
		File file = new File(filePath + filename);	//파일객체를 생성할 땐 파일 경로랑 파일 명이 들어가야함
		if(!file.exists()) {	//해당경로에 파일이 존재하지 않으면
			file.mkdirs();		//만들어라
		}
		return null;
	}

	@GetMapping("/board")
	public String boardPage(Model model, @RequestParam int page) {
		
		List<BoardStudy> boardListAll = bRepository.getBoardList();
		List<BoardStudy> boardList = new ArrayList<BoardStudy>();
		
		if (page == 0) {
			boardList = boardListAll;
		} else {
			int num = page * 5 - 5;
			for (int i = num; i < num + 5; i++) {
				boardList.add(boardListAll.get(i));
			}
		}
		
		model.addAttribute("b", boardList);
		return "study/board";
	}
}
