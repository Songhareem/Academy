package com.song.Spring_legacy2.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.Spring_legacy2.AbstractTestCase;
import com.song.Spring_legacy2.notice.NoticeDAO;
import com.song.Spring_legacy2.notice.NoticeVO;

public class memberDAOTest extends AbstractTestCase {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void boardWriteTest() throws Exception{

		String id;
		String pw;
		String name;
		int age;
		String email;
		String email2;
		String naver = "@naver.com";
		String google = "@google.co.kr";
		String kakao = "@kakao.com";
		String phone;
		
		for(int i=1; i<151; i++) {
			MemberVO memberVO = new MemberVO();
			if(i%3 == 0) {
				id = "Choi";
				pw = "in";
				name = "hae";
				email = "hea";
				email2 = naver;
				phone = "01052521004";
			} else if(i%3 == 1) {
				id = "Song";
				pw = "ha";
				name = "reem";
				email = "reem";
				email2 = google;
				phone = "01000010001";
			} else {
				id = "Ham";
				pw = "jun";
				name = "ho";
				email = "ho";
				email2 = kakao;
				phone ="01012341234";
			}
			memberVO.setId(id+i);
			memberVO.setPw(pw);
			memberVO.setName(name+1);
			memberVO.setAge(i);
			memberVO.setEmail(email+i+email2);
			System.out.println(email+i+email2);
			memberVO.setPhone(phone);

			int result = memberDAO.memberJoin(memberVO);
			if(i == 50 || i == 100) {
				Thread.sleep(2000);
			}
		}
	}
}
