package com.song.s1.board.qna;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QnaRepository extends JpaRepository<QnaVO, Long> {

	public Page<QnaVO> findByTitleContaining(String search, Pageable pageable);
	public Page<QnaVO> findByWriterContaining(String search, Pageable pageable);
	public Page<QnaVO> findByContentsContaining(String search, Pageable pageable);
	
	public List<QnaVO> findByRefAndStepGreaterThan(long ref, long step);
	
	@Modifying
	@Transactional
	//@Query(value = "UPDATE QnaVO q SET q.title=?1, q.writer=?2, q.contents=?3 WHERE num=?4")
	@Query(value = "UPDATE QnaVO q SET q.title=:title, q.writer=:writer, q.contents=:contents WHERE num=:num")
	public void qnaUpdate(String title, String writer, String contents, long num);
	
	@Query(value = "SELECT q FROM QnaVO q WHERE q.num=:num")
	QnaVO qnaSelect(Long num);
}
