package com.song.account;

import java.util.ArrayList;
import java.util.Calendar;

public class AccountService {

	private AccountDAO accountDAO;
	
	public AccountService() {
	
		accountDAO = new AccountDAO();
	}
	
	public ArrayList<AccountDTO> selectList(String memberID){
		ArrayList<AccountDTO> ar=null;
		
		try {
			ar = accountDAO.selectList(memberID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}

	public int insert(AccountDTO accountDTO) {
		
		int result = 0;
		try {
			// 계좌번호 생성(중복금지)
			// 6-2-6
			// 생성 년월일 - 
			Calendar ca = Calendar.getInstance();
			long t = ca.getTimeInMillis();
			accountDTO.setAccountNum(t);

			result= accountDAO.insert(accountDTO);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
