package com.song.Spring_legacy2.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.song.Spring_legacy2.util.Pager;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.song.Spring_legacy2.member.MemberDAO.";
	
	// memberIdCheck
	public Long memberIdCheck(MemberVO memberVO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", memberVO);
	}
	
	// memberCount
	public Long memberCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"memberCount", pager);
	}
	
	// memberList
	public List<MemberVO> memberList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"memberList", pager);
	}
	
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
	
	// memberDeletes (Deletes)
	public int memberDeletes(List<String> list) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"memberDeletes", list);
	}
}
