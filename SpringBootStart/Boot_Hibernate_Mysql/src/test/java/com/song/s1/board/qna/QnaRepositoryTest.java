package com.song.s1.board.qna;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QnaRepositoryTest {

	@Autowired
	private QnaRepository qnaRepository;
	
	@Test
	public void insertTest() {
		
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("title");
		qnaVO.setWriter("writer");
		qnaVO.setContents("contents");
		
		qnaVO = qnaRepository.save(qnaVO);
		assertNotNull(qnaVO);
	}
}
