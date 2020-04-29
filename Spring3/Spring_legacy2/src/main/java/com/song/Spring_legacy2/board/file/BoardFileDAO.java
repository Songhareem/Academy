package com.song.Spring_legacy2.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAO {

	@Autowired
	private SqlSession sqlSession;
	private String NAMESPACE = "com.song.Spring_legacy2.board.file.BoardFileDAO.";
	
	// C
	public int boardFileInsert(BoardFileVO boardFileVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"boardFileInsert", boardFileVO);
	}
	
	// R
	public BoardFileVO boardFileSelect(BoardFileVO boardFileVO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardFileSelect", boardFileVO);
	}
	
	public List<BoardFileVO> boardFileList(Long num) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"boardFileList", num);
	}
	
	// U
	
	// D
	public int boardFileDelete(BoardFileVO boardFileVO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"boardFileDelete", boardFileVO);
	}
	
	public int boardFileDeleteCascade(Long num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"boardFileDeleteCascade", num);
	}
}
