package com.song.s1.board.notice;

import java.util.List;
import java.lang.Long;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Long> {
	
	// SELECT * FROM notice ORDER BY num DESC
	public List<NoticeVO> findAllByOrderByNumDesc();
	
	// SELECT * FROM notice WHERE num>0 ORDER BY num DESC
	public List<NoticeVO> findByNumGreaterThanOrderByNumDesc(long num);
	
	// SELECT * FROM notice WHERE num between 6 and 10 ORDER BY num DESC
	public List<NoticeVO> findByNumBetweenOrderByNumDesc(long startNum, long endNum);
	
	// SELECT * FROM notice WHERE title LIKE ?? ORDER BY num DESC
	public List<NoticeVO> findByTitleContainingOrderByNumDesc(String search);
	
	// SELECT * FROM notice WHERE ? LIKE ?? ORDER BY num DESC
	public List<NoticeVO> findByTitleContaining(String search, Pageable pageable);
	public List<NoticeVO> findByWriterContaining(String search, Pageable pageable);
	public List<NoticeVO> findByContentsContaining(String search, Pageable pageable);

	// SELECT COUNT(?) FROM notice WHERE ? LIKE ??
	public int countByTitleContaining(String search);
	public int countByWriterContaining(String search);
	public int countByContentsContaining(String search);
	
}
