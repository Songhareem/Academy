package com.song.mysql.board.qna;

import com.song.mysql.board.BoardVO;

public class QnaVO extends BoardVO{

	private int ref;
	private int step;
	private int dept;
	
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
}
