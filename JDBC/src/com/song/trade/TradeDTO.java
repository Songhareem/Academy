package com.song.trade;

import java.sql.Date;

public class TradeDTO {

	private Long accountNum;
	private Date accountDate;
	private Long tradeAmount;
	private Long accountBalance;
	private Boolean tradeIO;
	
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(Long tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Boolean getTradeIO() {
		return tradeIO;
	}
	public void setTradeIO(Boolean tradeIO) {
		this.tradeIO = tradeIO;
	}
}
