package com.song.Spring_legacy2.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.Spring_legacy2.board.BoardService;
import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return qnaDAO.boardWrite(boardVO);
	}

	@Override
	public long boardCount(Pager pager) throws Exception {
		
		return qnaDAO.boardCount(pager);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = qnaDAO.boardCount(pager);
		pager.makePage(totalCount);
		
		return qnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		int result = qnaDAO.hitUpdate(boardVO);
		if(result > 0) {
			System.out.println("BoardSelect : hit update 성공");
		} else {
			System.out.println("BoardSelect : hit update 실패");
		}
		return qnaDAO.boardSelect(num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		
		return qnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int hitUpdate(BoardVO boardVO) throws Exception {
		
		return qnaDAO.hitUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		
		return qnaDAO.boardDelete(num);
	}
	
	public int boardReply(BoardVO boardVO) throws Exception {
		
		int result = qnaDAO.boardReplyUpdate(boardVO);
		result = qnaDAO.boardReply(boardVO);
		return result;
	}
}
