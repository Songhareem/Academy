package com.song.Spring_legacy2.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.song.Spring_legacy2.board.BoardDAO;
import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.notice.NoticeDAO.";
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}

	public long boardNum() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardNum");
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

	
}
