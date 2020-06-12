package com.song.s1.board;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.song.s1.board.notice.NoticeVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor		// 디폴트 생성자
@AllArgsConstructor     // 인자 있는 생성자
@MappedSuperclass		// 부모 클래스라는것은 명시
public class BoardFileVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileNum;
	@Column
	private String fileName;
	@Column
	private String oriName;
}
