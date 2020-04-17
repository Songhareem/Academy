package com.song.Spring_legacy2.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.member.MemberDAO.";
	
	// memberJoin (Insert)
	public int memberJoin(MemberVO memberVO) throws Exception {

		return sqlSession.insert(NAMESPACE+"memberJoin", memberVO);
	}
	
	// memberLogin (Select One)
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {

		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}
	
	// memberUpdate (Update)
	public int memberUpdate(MemberVO memberVO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"memberUpdate", memberVO);
	}
	
	// memberDelete (Delete)
	public int memberDelete(MemberVO memberVO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"memberDelete", memberVO);
	}
}
