package com.song.Spring_legacy2.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.Spring_legacy2.AbstractTestCase;
import com.song.Spring_legacy2.member.MemberVO;

public class memberFileDAOTest extends AbstractTestCase {

	@Autowired
	private MemberFileDAO memberDAO;
	
	@Test
	public void memberFileInsertTest() throws Exception{

		String id = "img2";
		String fileName = "img2_123123124124123.jpg";
		String originName = "img2";
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(id);
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriginName(originName);
		
		System.out.println("save1");
		
		int result = memberDAO.memberFileInsert(memberFileVO);
		System.out.println("save3");
		System.out.println("result : "+ result);
		assertEquals(1, result);
	}
}
