package com.song.Spring_legacy2.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.Spring_legacy2.board.BoardService;
import com.song.Spring_legacy2.board.BoardVO;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return noticeDAO.boardWrite(boardVO);
	}

	@Override
	public long boardCount() throws Exception {
		
		return noticeDAO.boardCount();
	}
	
	@Override
	public List<BoardVO> boardList(int curPage, int perPage) throws Exception {
		
		int startRow = (curPage-1)*perPage+1;
		int lastRow = curPage*perPage;
		long totalCount = noticeDAO.boardCount();
		long totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		return noticeDAO.boardList(map);
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
