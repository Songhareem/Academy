package com.song.Spring_legacy2.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.member.memberFile.MemberFileDAO.";
	
	// C
	public int memberFileInsert(MemberFileVO memberFileVO) throws Exception {
		
		System.out.println("save2");
		return sqlSession.insert(NAMESPACE+"memberFileInsert", memberFileVO);
	}
	
	// R
	public MemberFileVO memberFileSelect(MemberFileVO memberFileVO) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE+"memberFileSelect", memberFileVO);
	}
	
	// U
	public int memberFileUpdate(MemberFileVO memberFileVO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"memberFileUpdate", memberFileVO);
	}
	
	// D
	public int memberFileDelete(MemberFileVO memberFileVO) throws Exception {

		return sqlSession.delete(NAMESPACE+"memberFileDelete", memberFileVO);
	}
}
