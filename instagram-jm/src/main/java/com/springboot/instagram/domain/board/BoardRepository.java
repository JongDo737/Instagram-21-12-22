package com.springboot.instagram.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	public int insertBoard(Board board);
	public List<ProfileBoard> getProfileBoardListByUsername(String username);
	public Board getBoardById(int board_id); //쿼리문은 소대문자 구분을 안해서 
	//snake 표기법쓰기
	public List<IndexBoard> getIndexBoardListByUsername(String username);
}