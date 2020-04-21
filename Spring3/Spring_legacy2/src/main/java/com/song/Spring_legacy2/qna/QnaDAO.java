package com.song.Spring_legacy2.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.song.Spring_legacy2.board.BoardDAO;
import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.qna.QnaDAO.";
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}

	@Override
	public long boardCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardCount", pager);
	}

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"boardList", pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardSelect", num);
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
	
	public int boardReplyUpdate(BoardVO boardVO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"boardReplyUpdate", boardVO);
	}
	
	public int boardReply(BoardVO boardVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"boardReply", boardVO);
	}
}
