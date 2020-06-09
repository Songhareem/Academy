package com.song.s1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="memberFile")
//@SequenceGenerator(name = "시퀀스명", sequenceName = "DB의 시퀀스명", initialValue = 1, allocationSize = 1)
public class MemberFileVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 기본키 생성을 DB에 위임 (Auto Increment)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "시퀀스명")
	private Long fileNum;
		
	@Column
	private String fileName;
	
	@Column
	private String oriName;
	
	@OneToOne
	@JoinColumn(name = "id")
	private MemberVO memberVO;	// 멤버변수명 = MemberVO table의 mappedBy에 선언한 명
}
