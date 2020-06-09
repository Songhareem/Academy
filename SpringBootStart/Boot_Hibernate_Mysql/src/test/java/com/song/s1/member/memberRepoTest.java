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
	void loginTest() {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test");
		memberVO.setPw("test");
		memberVO = memberRepository.findByIdAndPw("test", "test");
	}
	
	//@Test
	void idCheckTest() {
		
		boolean check = memberRepository.existsById("testID");
		assertEquals(check, true);
	}
	
	//@Test
	void saveOneToOneTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("idid");
		memberVO.setPw("pwpw");
		memberVO.setPwCheck("pwcheck");
		memberVO.setName("name");
		memberVO.setEmail("test@naver.com");
		memberVO.setPhone("01011111111");
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		
		// 서로 주입
		memberVO.setMemberFileVO(memberFileVO);
		memberFileVO.setMemberVO(memberVO);
		
		memberVO = memberRepository.save(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void saveTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("idid");
		memberVO.setPw("pwpw");
		memberVO.setPwCheck("pwcheck");
		memberVO.setName("name");
		memberVO.setEmail("test@naver.com");
		memberVO.setPhone("01011111111");
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		
		// 서로 주입
		memberVO.setMemberFileVO(memberFileVO);
		memberFileVO.setMemberVO(memberVO);
		
		memberVO = memberRepository.save(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("idid");
		memberVO.setPw("pwpw2");
		memberVO.setPwCheck("pwcheck");
		memberVO.setName("name2");
		memberVO.setEmail("test2@naver.com");
		memberVO.setPhone("01011111111");
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileNum(1L);
		memberFileVO.setFileName("change fileName");
		memberFileVO.setOriName("change oriName");
		
		memberVO.setMemberFileVO(memberFileVO);
		memberFileVO.setMemberVO(memberVO);
		
		memberVO = memberRepository.save(memberVO);
		assertNotNull(memberVO);
	}
	
	@Test
	void deleteTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("idid");

		//MemberVO memberVO2 = new MemberVO();
		//memberVO2.setId("testID4");
		
		//List<MemberVO> list = new ArrayList<MemberVO>();
		
		//list.add(memberVO);
		//list.add(memberVO2);
		
		//memberRepository.deleteInBatch(list);
		memberRepository.deleteById(memberVO.getId());
	}

}
