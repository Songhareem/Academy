package com.song.Spring_legacy2.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.song.Spring_legacy2.util.Pager;

@Repository
public class MemoDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.memo.MemoDAO.";
	
	public int memoInsert(MemoVO memoVO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"memoInsert", memoVO);
	}
	
	public List<MemoVO> memoList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"memoList", pager);
	}
	
}
