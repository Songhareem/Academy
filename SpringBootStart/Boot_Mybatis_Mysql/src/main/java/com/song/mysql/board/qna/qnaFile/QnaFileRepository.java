package com.song.mysql.board.qna.qnaFile;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaFileRepository {

	public int setInsert(QnaFileVO noticeFileVO) throws Exception;
	
	public QnaFileVO fileDown(QnaFileVO noticeFileVO) throws Exception;
}
