package com.song.s1.board.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.song.s1.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "notice")
//@DynamicUpdate(value = true)
public class NoticeVO extends BoardVO{
	
	@Column
	private int ref;
	@Column
	private int step;
	@Column
	private int dept;
	
	// fetch.Eager : 조회시, NoticeVO와 NoticeFileVO를 같이 조회해옴
	// fetch.Lazy : 조회시, NoticeVO만 가져오고, NoticeFileVO를 사용하려 할때 조회함
	// One To Many : 앞은 자기 자신, 뒤는 연결되는 테이블
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFileVO> noticeFileVOs;
}
