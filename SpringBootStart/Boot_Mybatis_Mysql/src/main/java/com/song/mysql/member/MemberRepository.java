package com.song.mysql.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
}
