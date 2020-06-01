package com.song.s1.board;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {
	
	public int setInsert(BoardVO boardVO) throws Exception;
	public int setDelete(BoardVO boardVO) throws Exception;
	public BoardVO setSelect(BoardVO boardVO) throws Exception;
}
