package com.song.mysql.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService {

	// insert
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception;

	// update
	public int setUpdate(BoardVO boardVO) throws Exception;

	// delete
	public int setDelete(BoardVO boardVO) throws Exception;

	// selectOne
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;

	// selectList
	public List<BoardVO> getSelectList() throws Exception;
}
