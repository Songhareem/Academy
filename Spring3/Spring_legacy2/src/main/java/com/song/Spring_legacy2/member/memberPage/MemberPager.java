package com.song.Spring_legacy2.member.memberPage;

public class MemberPager {

	private Long curPage = 1L;
	private Integer perPage = 10;
	private Long perBlock = 5L;
	private Long curBlock;
	
	private Long totalPage;
	private Long totalBlock;
	
	private long startRow;
	private long lastRow;
	
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	public void makeRow() {
		this.startRow = (this.curPage - 1) * this.perPage + 1;
		this.lastRow = this.curPage * this.perPage;
	}

	public void makePage(long totalCount) {
		
		// 전체 페이지 수 구하기
		totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}

		// 전체 블록 수(페이지 단위로 끊긴 전체 페이지 수) 구하기
		this.totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		// 현재 블록 구하기
		this.curBlock = this.curPage/this.perBlock;
		if(this.curPage%this.perBlock != 0) {
			this.curBlock++;
		}
		
		// 현 블록 내의 시작 Page , 마지막 page 구하기
		this.startNum = this.perBlock*(this.curBlock-1) + 1;
		this.lastNum = this.perBlock*this.curBlock;
		
		// 끝페이지 처리
		if(curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
	}
	
	public Long getCurPage() {
		if(curPage == 0 || curPage == null)
			curPage = 1L;
		
		return curPage;
	}

	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		if(perPage == 0 || perPage == null)
			perPage = 10;
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}


	public Long getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(Long curBlock) {
		this.curBlock = curBlock;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Long totalBlock) {
		this.totalBlock = totalBlock;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null)
			this.search = "";
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
