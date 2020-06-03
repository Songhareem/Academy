package com.song.mysql.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.song.mysql.board.BoardRepository;

@Mapper
public interface QnaRepository extends BoardRepository {

	public int setRef(QnaVO qnaVO) throws Exception;
}
