package com.song.Spring_legacy2.board;

import java.util.List;

public interface BoardService {
	
	// insert
	public int boardWrite(BoardVO boardVO) throws Exception;

	// select All / One
	public long boardCount() throws Exception;
	public List<BoardVO> boardList(int curPage, int perPage) throws Exception;
	public BoardVO boardSelect(long num) throws Exception;

	// update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	public int hitUpdate(BoardVO boardVO) throws Exception;

	// delete
	public int boardDelete(long num) throws Exception;
}
