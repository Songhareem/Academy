package com.song.s1.board;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor		// 디폴트 생성자
@AllArgsConstructor     // 인자 있는 생성자
@MappedSuperclass		// 부모 클래스라는것은 명시
public class BoardVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	@Column
	private String title;
	@Column
	private String writer;
	@Column
	private String contents;
	@Column
	@CreationTimestamp // 생성시간 저장
	// @UpdateTimestamp update시 시간저장
	private Date regDate;
	@Column
	private Long hit;
}
