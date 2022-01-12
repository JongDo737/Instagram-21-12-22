package com.springboot.instagram.web.dto.board;

import java.util.List;

import com.springboot.instagram.domain.board.IndexBoard;

import lombok.Data;

@Data
public class IndexBoardRespDto {
	private List<IndexBoard> indexBoardList;
	private int indexBoardTotalCount;
}
