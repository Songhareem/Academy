package com.song.Spring_legacy2.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	// 멤버 상수
	
	// 추상 메서드 (public abstract 생략 가능)

	// insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	// select All / One
	public long boardCount() throws Exception;
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception;
	public BoardVO boardSelect(long num) throws Exception;
	// update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	public int hitUpdate(BoardVO boardVO) throws Exception;
	
	// delete
	public int boardDelete(long num) throws Exception;
}