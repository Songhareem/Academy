package com.song.s1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.song.s1.board.BoardVO;
import com.song.s1.util.FileManager;
import com.song.s1.util.FilePathMaker;
import com.song.s1.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private FilePathMaker pathMaker;	// 파일 경로 생성
	@Autowired
	private FileManager fileManager;	// 파일 저장 매니저
	@Value("${board.notice.filePath}")
	private String filePath;
	
	
	public NoticeVO setInsert(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
		
		File file = pathMaker.getUserResourceLoader(filePath);
		System.out.println("insert filePath: " + filePath);

		List<NoticeFileVO> noticeFileVOs = new ArrayList<NoticeFileVO>();
		
		for (MultipartFile multipartFile : files) {
			// 빈값 오는거 받지않음
			if (!(multipartFile.getSize() > 0))
				continue;

			String fileName = fileManager.saveTransfer(multipartFile, file);
			NoticeFileVO noticeFileVO = new NoticeFileVO();
			noticeFileVO.setFileName(fileName);
			noticeFileVO.setOriName(multipartFile.getOriginalFilename());
			noticeFileVO.setNoticeVO(noticeVO);

			noticeFileVOs.add(noticeFileVO);
		}
		
		noticeVO.setNoticeFileVOs(noticeFileVOs);

		return noticeRepository.save(noticeVO);
	}
	
//	public List<NoticeVO> noticeList(Pageable pageable, String search, String kind) throws Exception {
//		
//		//List<NoticeVO> list = noticeRepository.findByNumGreaterThanOrderByNumDesc(0L);
//		
//		List<NoticeVO> list = null;
//		switch(kind) {
//		case "title" : 
//			list = noticeRepository.findByTitleContaining(search, pageable);
//			break;
//		case "writer" :
//			list = noticeRepository.findByWriterContaining(search, pageable);
//			break;
//		case "contents" :
//			list = noticeRepository.findByContentsContaining(search, pageable);
//			break;
//		default:
//			System.out.println("noticeService_noticeList : something worng");
//			break;
//		} 
//		
//		return list;
//	}
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception {
		
		pager.makeRow();
		Pageable pageable = PageRequest.of((int)pager.getStartRow(), pager.getPerPage(), Sort.Direction.DESC, "num");
		
		List<NoticeVO> list = null;
		switch(pager.getKind()) {
		case "writer" :
			System.out.println("writer");
			list = noticeRepository.findByWriterContaining(pager.getSearch(), pageable);
			pager.makePage(noticeRepository.countByWriterContaining(pager.getSearch()));
			break;
		case "contents" :
			System.out.println("contents");
			list = noticeRepository.findByContentsContaining(pager.getSearch(), pageable);
			pager.makePage(noticeRepository.countByContentsContaining(pager.getSearch()));
			break;
		default:
			System.out.println("title");
			list = noticeRepository.findByTitleContaining(pager.getSearch(), pageable);
			pager.makePage(noticeRepository.countByTitleContaining(pager.getSearch()));
			break;
		} 

		return list;
	}
	
	public NoticeVO noticeSelectOne(BoardVO boardVO) throws Exception {
		
		return noticeRepository.getOne(boardVO.getNum());
	}
}
