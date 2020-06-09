package com.song.s1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class MemberVO {
	
	@Id // PK
	@NotEmpty
	private String id;
	
	@Column(nullable=false) // 일반 컬럼명
	@Size(min=3, max=15)
	private String pw; 
	
	@Transient // 테이블에서 제외
	@Size(min=3, max=15)
	private String pwCheck;
	
	@Column // 일반 컬럼명
	@Size(min=3, max=20)
	private String name;
	
	@Column // 일반 컬럼명
	@Email
	private String email;
	
	@Column // 일반 컬럼명
	@Size(min=11, max=11)
	private String phone;
	
	// 1:1 관계, mappedBy : join하는 엔티티에 선언된 자기 자신의 엔티티 변수명
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL)
	private MemberFileVO memberFileVO;
}
