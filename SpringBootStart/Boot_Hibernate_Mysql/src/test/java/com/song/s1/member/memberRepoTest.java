package com.song.s1.member;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@Transactional(rollbackFor = Exception.class)
class memberRepoTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	//@Test
	void idCheckTest() {
		
		boolean check = memberRepository.existsById("testID");
		assertEquals(check, true);
	}
	
	@Test
	void saveTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("테스트");
		memberVO.setPw("테스트");
		memberVO.setPwCheck("test");
		memberVO.setName("테스트");
		memberVO.setEmail("test@naver.com");
		memberVO.setPhone("01011111111");
		memberVO = memberRepository.save(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testID");
		memberVO.setEmail("test2@naver.com");
		memberVO = memberRepository.save(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void deleteTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testID3");
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setId("testID4");
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		list.add(memberVO);
		list.add(memberVO2);
		
		memberRepository.deleteInBatch(list);
	}

}
