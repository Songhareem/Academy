package com.song.Spring_legacy2.board.file;

public class BoardFileVO {

    private long fileNum;
	private long num;
	private String fileName;
	private String originName;
	private int	board;
	
	public long getFileNum() {
		return fileNum;
	}
	public void setFileNum(long fileNum) {
		this.fileNum = fileNum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public int getBoard() {
		return board;
	}
	public void setBoard(int board) {
		this.board = board;
	}
}
