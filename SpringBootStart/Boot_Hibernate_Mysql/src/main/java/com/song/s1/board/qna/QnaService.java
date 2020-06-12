package com.song.s1.board.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.song.s1.util.FileManager;
import com.song.s1.util.FilePathMaker;
import com.song.s1.util.Pager;

@Service
@Transactional(rollbackOn = Exception.class)
public class QnaService {
	
	@Autowired
	private  QnaRepository qnaRepository;
	@Autowired
	private FilePathMaker pathMaker; // 파일 경로 생성
	@Autowired
	private FileManager fileManager; // 파일 저장 매니저
	@Value("${board.qna.filePath}")
	private String filePath;
	
	public QnaVO qnaReply(QnaVO qnaVO) throws Exception{
		
		QnaVO childVO = new QnaVO();
		childVO.setTitle(qnaVO.getTitle());
		childVO.setWriter(qnaVO.getWriter());
		childVO.setContents(qnaVO.getContents());
		
		
		//update
		// ref == 부모, step > 부모의 step => step += 1
		qnaVO = qnaRepository.findById(qnaVO.getNum()).get();
		List<QnaVO> list = qnaRepository.findByRefAndStepGreaterThan(qnaVO.getRef(), qnaVO.getStep());
		
		// 자기자신의 ref = 부모 ref, step = 부모 step + 1, depth = 부모의 depth + 1
		for (QnaVO vo : list) {
			vo.setStep(vo.getStep()+1);
		}
		qnaRepository.saveAll(list);
		
		childVO.setRef(qnaVO.getRef());
		childVO.setStep(qnaVO.getStep()+1);
		childVO.setDepth(qnaVO.getDepth()+1);
		qnaRepository.save(childVO);
		
		return childVO;
	}
	
	public QnaVO setInsert(QnaVO qnaVO, MultipartFile[] files) throws Exception {
		
		File file = pathMaker.getUserResourceLoader(filePath);
		System.out.println("insert filePath: " + filePath);

		List<QnaFileVO> qnaFileVOs = new ArrayList<QnaFileVO>();
		
		for (MultipartFile multipartFile : files) {
			// 빈값 오는거 받지않음
			if (!(multipartFile.getSize() > 0))
				continue;

			String fileName = fileManager.saveTransfer(multipartFile, file);
			QnaFileVO qnaFileVO = new QnaFileVO();
			qnaFileVO.setFileName(fileName);
			qnaFileVO.setOriName(multipartFile.getOriginalFilename());
			qnaFileVO.setQnaVO(qnaVO);

			qnaFileVOs.add(qnaFileVO);
		}
		
		qnaVO.setBoardFileVOs(qnaFileVOs);

		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		
		return qnaRepository.save(qnaVO);
	}
	
	// pageable 이용
//	public Page<QnaVO> boardList(Pageable pageable, String search, String kind) throws Exception {
//		
//		Page<QnaVO> page = null;
//		switch(kind) {
//		case "title" : 
//			page = qnaRepository.findByTitleContaining(search, pageable);
//			break;
//		case "writer" :
//			page = qnaRepository.findByWriterContaining(search, pageable);
//			break;
//		case "contents" :
//			page = qnaRepository.findByContentsContaining(search, pageable);
//			break;
//		default:
//			System.out.println("qnaService_qnaList : something worng");
//			break;
//		}
//
//		return page;
//	}
	
	// Pager 이용
	public Page<QnaVO> qnaList(Pager pager) throws Exception {
		
		pager.makeRow();
		Pageable pageable = PageRequest.of(pager.getStartRow(), pager.getSize(), Sort.by("ref").descending().and(Sort.by("step").ascending()));
		
		Page<QnaVO> page = null;
		
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		switch(pager.getKind()) {
		case "writer" :
			page = qnaRepository.findByWriterContaining(pager.getSearch(), pageable);
			break;
		case "contents" :
			page = qnaRepository.findByContentsContaining(pager.getSearch(), pageable);
			break;
		default: // case title : 
			page = qnaRepository.findByTitleContaining(pager.getSearch(), pageable);
			break;
		}

		pager.makePage(page.getTotalPages());
		
		return page;
	}
	
	public QnaVO qnaSelectOne(QnaVO qnaVO) throws Exception {

		// selectOne
	    QnaVO findVO = qnaRepository.getOne(qnaVO.getNum());
	    
	    // hit update
	    findVO.setHit(findVO.getHit()+1);
	    findVO = qnaRepository.save(findVO);
		return findVO;
	}
	
	public boolean qnaDelete(QnaVO qnaVO) throws Exception {
		
		qnaRepository.deleteById(qnaVO.getNum());
		return !qnaRepository.existsById(qnaVO.getNum());
	}
	
//	public QnaVO qnaUpdate(QnaVO qnaVO) throws Exception {
//		// TODO Auto-generated method stub
//		QnaVO findVO = qnaRepository.getOne(qnaVO.getNum());
//		qnaVO.setRegDate(findVO.getRegDate());
//		qnaVO.setRef(findVO.getRef());
//		qnaVO.setStep(findVO.getStep());
//		qnaVO.setDepth(findVO.getDepth());
//		return qnaRepository.save(qnaVO);
//	}
	
	public void qnaUpdate(QnaVO qnaVO) throws Exception {
		// TODO Auto-generated method stub
		qnaRepository.qnaUpdate(qnaVO.getTitle(), qnaVO.getWriter(), qnaVO.getContents(), qnaVO.getNum());
	}
}

