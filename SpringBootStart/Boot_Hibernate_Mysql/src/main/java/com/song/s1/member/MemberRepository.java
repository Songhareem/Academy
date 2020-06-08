package com.song.s1.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaRepository<T,ID>
// T  : Entity 타입
// ID : Primary의 데이터 타입 
public interface MemberRepository extends JpaRepository<MemberVO, String> {

	@Query(value = "SELECT * FROM member WHERE id = :id AND pw = :pw", nativeQuery = true)
	MemberVO findLoginMember(MemberVO memberVO);
}
