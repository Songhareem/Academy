package com.song.s1.util;

import org.springframework.stereotype.Component;

import lombok.Data;

//=========================
// ?ъ슜
//
// pager.setSize(16);
// pager.makeRow();
// int totalNum = marketDAO.marketTotalNum(pager);
// pager.makePage(totalNum);
// return marketDAO.marketList(pager);
//
//=========================

@Data
@Component
public class Pager {

	private Integer page;
	private Integer size = 10;
	
	private Integer perBlock = 5;
	private Integer curBlock;
	
	private Integer startRow;
	private Integer lastRow;
	
	private Integer totalPage;
	private Integer totalBlock;
	
	private Integer startNum;
	private Integer lastNum;
	
	private String kind;
	private String search;

	public void makeRow() {
		this.startRow = this.getPage() - 1;
	}

	public void makePage(int totalPage) {
		this.setTotalPage(totalPage);
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			this.totalBlock++;
		}
		
		this.curBlock = this.page/this.perBlock;
		if(this.page%this.perBlock != 0) {
			this.curBlock++;
		}
		
		this.startNum = this.perBlock*(this.curBlock-1) + 1;
		this.lastNum = this.perBlock*this.curBlock;
		if(curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
	}
	
	

	public Integer getPage() {
		if(this.page == null || this.page == 0)
			this.page = 1;
		return this.page;
	}
	
	
	public Integer getSize() {
		if(this.size == null || this.size == 0)
			this.setSize(10);
		return size;
	}

	public String getKind() {
		if(this.kind==null || this.kind.equals("")) {
			this.kind="title";
		}
		return kind;
	}
	
	public String getSearch() {
		
		if(this.search == null)
			this.search = "";
		
		return search;
	}
	
}