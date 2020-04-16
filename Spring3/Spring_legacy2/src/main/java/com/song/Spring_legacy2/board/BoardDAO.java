package com.song.Spring_legacy2.board;

import java.util.List;

public interface BoardDAO {

	// 멤버 상수
	
	// 추상 메서드 (public abstract 생략 가능)

	// insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	// select All
	public List<BoardVO> boardList() throws Exception;
	
	// select One
	public BoardVO boardSelect(BoardVO boardVO) throws Exception;
	
	// update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	public int hitUpdate(BoardVO boardVO) throws Exception;
	
	// delete
	public int boardDelete(long num) throws Exception;
}
