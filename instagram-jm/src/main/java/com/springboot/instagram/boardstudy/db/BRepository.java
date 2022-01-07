package com.springboot.instagram.boardstudy.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BRepository {
	public List<BoardStudy> getBoardList();
	//entity객체 를 담는 list
}
