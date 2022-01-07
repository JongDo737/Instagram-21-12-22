package com.springboot.instagram.boardstudy;

import java.util.ArrayList;
import java.util.List;

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

	@GetMapping("/board")
	public String boardPage(Model model, @RequestParam int page) {
		
		List<BoardStudy> boardListAll = bRepository.getBoardList();
		List<BoardStudy> boardList = new ArrayList<BoardStudy>();
		
		if (page == 0) {
			boardList = boardListAll;
		} else {
			int num = page * 5 - 5;
			for (int i = num; i < num + 5; i++) {
				System.out.println(i);
				boardList.add(boardListAll.get(i));
			}
		}
		
		model.addAttribute("b", boardList);
		return "study/board";
	}
}
