package com.song.product;

public class ProductDTO {

	private String proNum;
	private String proName;
	private String proComment;
	private Double proRate;
	private Integer proSale;
	
	public String getProNum() {
		return proNum;
	}
	public void setProNum(String proNum) {
		this.proNum = proNum;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proNama) {
		this.proName = proNama;
	}
	public String getProComment() {
		return proComment;
	}
	public void setProComment(String proComment) {
		this.proComment = proComment;
	}
	public Double getProRate() {
		return proRate;
	}
	public void setProRate(Double proRate) {
		this.proRate = proRate;
	}
	public Integer getProSale() {
		return proSale;
	}
	public void setProSale(Integer proSale) {
		this.proSale = proSale;
	}
}
