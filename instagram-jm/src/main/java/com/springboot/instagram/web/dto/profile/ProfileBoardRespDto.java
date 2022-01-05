package com.springboot.instagram.web.dto.profile;

import java.util.List;

import com.springboot.instagram.domain.board.ProfileBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileBoardRespDto {
	private List<List<ProfileBoard>> boardGroup; 
}
