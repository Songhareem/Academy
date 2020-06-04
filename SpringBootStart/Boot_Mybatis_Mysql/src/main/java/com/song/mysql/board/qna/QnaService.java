package com.song.mysql.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.song.mysql.board.BoardService;
import com.song.mysql.board.BoardVO;
import com.song.mysql.board.qna.qnaFile.QnaFileRepository;
import com.song.mysql.board.qna.qnaFile.QnaFileVO;
import com.song.mysql.util.FileManager;
import com.song.mysql.util.FilePathMaker;
import com.song.mysql.util.Pager;

@Service
@Transactional
public class QnaService implements BoardService {

	@Autowired
	private QnaRepository qnaRepository; 
	@Autowired
	private QnaFileRepository qnaFileRepository;
	@Autowired
	private FilePathMaker pathMaker;	// 파일 경로 생성
	@Autowired
	private FileManager fileManager;	// 파일 저장 매니저
	@Value("${board.qna.filePath}")
	private String filePath;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {

		File file = pathMaker.getUseClassPathResource(filePath);
		System.out.println("insert filePath: "+filePath);
		
		// 기본 데이터 및 ref insert
		int result = qnaRepository.setInsert(boardVO);
		QnaVO qnaVO = new QnaVO();
		qnaVO.setNum(boardVO.getNum());
		qnaVO.setRef(boardVO.getNum());
		result = qnaRepository.setRef(qnaVO);
		
		for (MultipartFile multipartFile : files) {
			// 빈값 오는거 받지않음
			if(!(multipartFile.getSize() > 0))
				continue;
			
			String fileName = fileManager.saveTransfer(multipartFile, file);
			QnaFileVO qnaFileVO = new QnaFileVO();
			qnaFileVO.setNum(boardVO.getNum());
			qnaFileVO.setFileName(fileName);
			qnaFileVO.setOriName(multipartFile.getOriginalFilename());
				
			System.out.println(fileName);
		
			// file Table 에 값 넣기
			result = qnaFileRepository.setInsert(qnaFileVO);
		}
			
		return result;
	}

	public int setInsertReply(BoardVO boardVO) throws Exception {
		
		int result = qnaRepository.setUpdateReply(boardVO);
		result = qnaRepository.setInsertReply(boardVO);
		return result;
	}
	
	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaRepository.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaRepository.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaRepository.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		long totalNum = qnaRepository.getSelectCount(pager);
		pager.makeRow();
		pager.makePage(totalNum);
		return qnaRepository.getSelectList(pager);
	}
	
	public QnaFileVO fileDown(QnaFileVO qnaFileVO) throws Exception {
		
		return qnaFileRepository.fileDown(qnaFileVO);
	}
}
