package com.song.bankbook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class BankBookService {

	private BankBookDAO bankBookDAO = null;
	
	public BankBookService() {
		
		bankBookDAO = new BankBookDAO();
	}
	
	public ArrayList<BankBookDTO> selectList(){
		
		ArrayList<BankBookDTO> ar = null;
		
		try {
			ar = bankBookDAO.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}
	
	public int insert(BankBookDTO bankBookDTO) {
		
		// BankBook insert
		// 일련번호(겹치지 않는 랜덤한 수) 만들어주기
		// 1. 현재 시간을 밀리세컨즈로 변환
		// 2. DB시퀀스 번호를 받아오기(DB에서 시퀀스 미리 만들어줘야 함)
		// 3. Java에서 제공하는 API
		
		// this.useTime();
		// this.useApi();
		
		int result = 0;
		try {
			bankBookDTO.setBookNumber(this.useDBSeq());
			result = bankBookDAO.insert(bankBookDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateBookSale(BankBookDTO bankBookDTO) {
		
		int result = 0;
		
		try {
			result = bankBookDAO.updateBookSale(bankBookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private String useTime() {
		Calendar ca = Calendar.getInstance();
		long millTime = ca.getTimeInMillis();
		System.out.println(millTime);
		return millTime + "";
	}
	
	private String useApi() {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		return uuid;
	}

	private String useDBSeq() throws Exception{
		
		String result = new BankBookDAO().seqSelect();
		System.out.println(result);
		return result + "";
	}
}
