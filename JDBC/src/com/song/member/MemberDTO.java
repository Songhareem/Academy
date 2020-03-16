package com.song.member;

public class MemberDTO {

	private Long memNum;
	private String memId;
	private String memPw;
	private String memName;
	private String memAddress;
	private String memPhone;
	private String memEmail;
	private Boolean memGetSns;
	private Boolean memGetEmail;
	
	public Long getMemNum() {
		return memNum;
	}
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public Boolean getMemGetSns() {
		return memGetSns;
	}
	public void setMemGetSns(Boolean memGetSns) {
		this.memGetSns = memGetSns;
	}
	public Boolean getMemGetEmail() {
		return memGetEmail;
	}
	public void setMemGetEmail(Boolean memGetMail) {
		this.memGetEmail = memGetMail;
	}
}
