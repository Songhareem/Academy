package com.song.s1.board.qna;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(rollbackOn = Exception.class)
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

		qnaVO.setHit(0L);
		qnaVO.setStep(0L);
		qnaVO.setDepth(0L);
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		
		return qnaRepository.save(qnaVO);
	}
	
	public Page<QnaVO> boardList(Pageable pageable, String search, String kind) throws Exception {
		
		Page<QnaVO> page = null;
		switch(kind) {
		case "title" : 
			page = qnaRepository.findByTitleContaining(search, pageable);
			break;
		case "writer" :
			page = qnaRepository.findByWriterContaining(search, pageable);
			break;
		case "contents" :
			page = qnaRepository.findByContentsContaining(search, pageable);
			break;
		default:
			System.out.println("qnaService_qnaList : something worng");
			break;
		}

		return page;
	}
}

