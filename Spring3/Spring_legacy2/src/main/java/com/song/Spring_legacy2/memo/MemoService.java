package com.song.Spring_legacy2.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.Spring_legacy2.util.Pager;

@Service
public class MemoService {

	@Autowired
	private MemoDAO memoDAO;
	
	public int memoInsert(MemoVO memoVO) throws Exception {
		
		return memoDAO.memoInsert(memoVO);
	}
	
	public List<MemoVO> memoList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		return memoDAO.memoList(pager);
	}
}
