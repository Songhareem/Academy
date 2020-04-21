package com.song.Spring_legacy2.qna;

import com.song.Spring_legacy2.board.BoardVO;

public class QnaVO extends BoardVO{
	
	//===================================
	// 아래 변수들은 Insert 시 사용
	//===================================
	
	// 원본글과 답글을 그룹으로 묶을 DATA, 원본글 - 자기 자신의 글번호를 ref에 넣기, 답글 - 부모글의 ref를 자기 자신의 ref에 넣기
	private long ref;
	// 그룹내에서 정렬을 위한 값, 원본글 - 0, 자식 - 0보다 크면 됨 
	// 1) ref값이 부모의 ref와 같은것과 stap이 부모의 step보다 큰것들을 step + 1
	private long step;
	// 화면 출력시, 들여쓰기 횟수 저장, 원본글 - 0번, 나머지 - 부모글 dept + 1
	private long dept;
	
	//SELECT * FROM qna order by ref desc, step asc;
	
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
