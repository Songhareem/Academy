package com.song.account;

import java.sql.Date;

public class AccountDTO {

	private Long AccountNum;
	private Long memNum;
	private String proNum;
	private Long AccountBalance;
	private Date AccountDate;
	
	public Long getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(Long AccountNum) {
		this.AccountNum = AccountNum;
	}
	public Long getMemNum() {
		return memNum;
	}
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}
	public String getProNum() {
		return proNum;
	}
	public void setProNum(String proNum) {
		this.proNum = proNum;
	}
	public Long getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		AccountBalance = accountBalance;
	}
	public Date getAccountDate() {
		return AccountDate;
	}
	public void setAccountDate(Date accountDate) {
		AccountDate = accountDate;
	}
};
