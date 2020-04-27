package com.song.Spring_legacy2.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFileService {

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	// select
	public BoardFileVO boardFileSelect(BoardFileVO boardFileVO) throws Exception {
		
		return boardFileDAO.boardFileSelect(boardFileVO);
	}
	
	// delete
	public int boardFileDelete(BoardFileVO boardFileVO) throws Exception {
		
		return boardFileDAO.boardFileDelete(boardFileVO);
	}
}
