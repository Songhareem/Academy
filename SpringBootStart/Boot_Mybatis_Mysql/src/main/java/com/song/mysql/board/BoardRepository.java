package com.song.mysql.board;

import java.util.List;

public interface BoardRepository {

	// insert
	public int setInsert(BoardVO boardVO) throws Exception;
	
	// update
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	// delete
	public int setDelete(BoardVO boardVO) throws Exception;
	
	// selectOne
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;
	
	// selectList
	public List<BoardVO> getSelectList() throws Exception;
	
	// totalCount
	
	// 조회수 update
}
