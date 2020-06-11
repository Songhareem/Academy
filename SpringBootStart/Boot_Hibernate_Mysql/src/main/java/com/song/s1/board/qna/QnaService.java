package com.song.s1.board.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class QnaService {
	
	@Autowired
	private  QnaRepository qnaRepository;

	public QnaVO setInsert(QnaVO qnaVO, MultipartFile[] files) throws Exception {
		
//		File file = pathMaker.getUserResourceLoader(filePath);
//		System.out.println("insert filePath: " + filePath);
//
//		List<QnaFileVO> qnaFileVOs = new ArrayList<QnaFileVO>();
//		
//		for (MultipartFile multipartFile : files) {
//			// 빈값 오는거 받지않음
//			if (!(multipartFile.getSize() > 0))
//				continue;
//
//			String fileName = fileManager.saveTransfer(multipartFile, file);
//			QnaFileVO qnaFileVO = new QnaFileVO();
//			qnaFileVO.setFileName(fileName);
//			qnaFileVO.setOriName(multipartFile.getOriginalFilename());
//			qnaFileVO.setQnaVO(qnaVO);
//
//			qnaFileVOs.add(qnaFileVO);
//		}
//		
//		qnaVO.setQnaFileVOs(qnaFileVOs);

		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		
		return qnaRepository.save(qnaVO);
	}
}

