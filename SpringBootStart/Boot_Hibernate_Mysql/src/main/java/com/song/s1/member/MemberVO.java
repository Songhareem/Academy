package com.song.s1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@NotEmpty
	@Size(min=3, max=15)
	private String pw; 
	
	@Transient // 테이블에서 제외
	@Size(min=3, max=15)
	private String pwCheck;
	
	@Column // 일반 컬럼명
	@NotEmpty
	@Size(min=3, max=20)
	private String name;
	
	@Column // 일반 컬럼명
	@NotEmpty
	@Email
	private String email;
	
	@Column // 일반 컬럼명
	@NotEmpty
	private String phone;
}
