package com.song.mysql.board;

import java.util.List;

import com.song.mysql.util.Pager;

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
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
	
	// totalCount
	public Long getSelectCount(Pager pager) throws Exception;
	
	// 조회수 update
}
