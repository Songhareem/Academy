package com.song.mysql.board.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.song.mysql.board.BoardRepository;

// @Repository
@Mapper // interface이므로 사용
public interface NoticeRepository extends BoardRepository {

}
