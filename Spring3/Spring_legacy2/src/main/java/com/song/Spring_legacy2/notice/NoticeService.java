package com.song.Spring_legacy2.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.Spring_legacy2.board.BoardService;
import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.board.page.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return noticeDAO.boardWrite(boardVO);
	}

	@Override
	public long boardCount(Pager pager) throws Exception {
		
		return noticeDAO.boardCount(pager);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = noticeDAO.boardCount(pager);
		pager.makePage(totalCount);
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int hitUpdate(BoardVO boardVO) throws Exception {
		
		return noticeDAO.hitUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		
		return noticeDAO.boardDelete(num);
	}

	
}
