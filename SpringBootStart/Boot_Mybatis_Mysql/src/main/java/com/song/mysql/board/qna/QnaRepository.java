package com.song.mysql.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.song.mysql.board.BoardRepository;
import com.song.mysql.board.BoardVO;

@Mapper
public interface QnaRepository extends BoardRepository {

	public int setRef(QnaVO qnaVO) throws Exception;
	
	public int setInsertReply(BoardVO boardVO) throws Exception;
	
	public int setUpdateReply(BoardVO boardVO) throws Exception;
}
