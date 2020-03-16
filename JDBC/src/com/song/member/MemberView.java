package com.song.member;

import java.util.ArrayList;

public class MemberView {

	public void viewResult(int result) {
		
		String msg = "반영 실패";
		
		if(result > 0) {
			msg = result + "개 행 반영 성공";
		}
		
		System.out.println(msg+"\n");
	}
	
	public void viewSelect(ArrayList<MemberDTO> mdtoList) {
		
		System.out.println("ProNum\t\tProName\tProComment\tProRate\tProSale");
		
		if(mdtoList.size() == 0)
			return;
		
		for (MemberDTO memDTO : mdtoList) {

			StringBuffer sb = new StringBuffer();
			
			sb.append(memDTO.getMemNum() + "\t");
			sb.append(memDTO.getMemId() + "\t");
			sb.append(memDTO.getMemPw() + "\t");
			sb.append(memDTO.getMemName() + "\t");
			sb.append(memDTO.getMemAddress() + "\t\t");
			sb.append(memDTO.getMemPhone() + "%\t");
			sb.append(memDTO.getMemEmail() + "\t");
			sb.append(memDTO.getMemGetEmail() + "\t");
			sb.append(memDTO.getMemGetSns() + "\t");
			
			
			System.out.println(sb);
		}
		System.out.println();
	}
}
