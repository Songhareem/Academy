package com.song.s1.board.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.song.s1.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="qna")
public class QnaVO extends BoardVO {

	@Column
	private long ref;
	@Column
	private long step;
	@Column
	private long depth;
	
	@OneToMany(mappedBy = "qnaVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<QnaFileVO> boardFileVOs;

//	public Long getRef() {
//		if(this.ref == null) {
//			this.ref = 0L;
//		}
//		return this.ref;
//	}
//	
//	public Long getStep() {
//		if(this.step == null) {
//			this.step = 0L;
//		}
//		return this.step;
//	}
//	
//	public Long getDepth() {
//		if(this.depth == null) {
//			this.depth = 0L;
//		}
//		return this.depth;
//	}
}
