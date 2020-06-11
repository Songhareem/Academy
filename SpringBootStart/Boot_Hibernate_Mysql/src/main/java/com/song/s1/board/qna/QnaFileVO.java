package com.song.s1.board.qna;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="qnaFile")
public class QnaFileVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileNum;
	@Column
	private String fileName;
	@Column
	private String oriName;

	@ManyToOne
	@JoinColumn(name="num")
	private QnaVO qnaVO;
}