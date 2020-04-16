package com.song.Spring_legacy2.qna;

import com.song.Spring_legacy2.board.BoardVO;

public class QnaVO extends BoardVO{
	
	private long ref;
	private long step;
	private long dept;
	
	public long getRef() {
		return ref;
	}
	public void setRef(long ref) {
		this.ref = ref;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}
	public long getDept() {
		return dept;
	}
	public void setDept(long dept) {
		this.dept = dept;
	}
}
