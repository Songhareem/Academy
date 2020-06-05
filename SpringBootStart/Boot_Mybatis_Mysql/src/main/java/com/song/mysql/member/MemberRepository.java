package com.song.mysql.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	public int memberJoin(MemberVO memberVO) throws Exception;
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	public MemberVO memberSelectOne(MemberVO memberVO) throws Exception;
}
