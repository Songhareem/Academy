package com.song.s1.board.qna;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.song.s1.board.BoardFileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="qnaFile")
public class QnaFileVO extends BoardFileVO{

	@ManyToOne
	@JoinColumn(name="num")
	private QnaVO qnaVO;
}
