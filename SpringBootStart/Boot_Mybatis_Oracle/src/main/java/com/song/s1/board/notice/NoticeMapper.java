package com.song.s1.board.notice;

import org.apache.ibatis.annotations.Mapper;

import com.song.s1.board.BoardMapper;

//@Repository
@Mapper
public interface NoticeMapper extends BoardMapper {
	
	// namespace = package 경로값 + 인터페이스명 으로 자동 생성
	// mapper id = 인터페이스 내의 메소드명을 mapper의 id로 인식
	// setInsert
	// setDelete
}
