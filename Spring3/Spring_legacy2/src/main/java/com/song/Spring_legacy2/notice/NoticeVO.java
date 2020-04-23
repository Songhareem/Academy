package com.song.Spring_legacy2.notice;

import java.util.List;

import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.board.file.BoardFileVO;

public class NoticeVO extends BoardVO {

	private List<BoardFileVO> boardFileVOs;

	public List<BoardFileVO> getBoardFileVOs() {
		return boardFileVOs;
	}

	public void setBoardFileVOs(List<BoardFileVO> boardFileVOs) {
		this.boardFileVOs = boardFileVOs;
	}
}
