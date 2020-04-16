package com.song.Spring_legacy2.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.song.Spring_legacy2.board.BoardDAO;
import com.song.Spring_legacy2.board.BoardVO;

@Repository
public class NoticeDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.notice.NoticeDAO.";
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}

	@Override
	public List<BoardVO> boardList() throws Exception {
			
		return null;
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		
		return null;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}
	
	@Override
	public int hitUpdate(BoardVO boardVO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"hitUpdate", boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}
}
