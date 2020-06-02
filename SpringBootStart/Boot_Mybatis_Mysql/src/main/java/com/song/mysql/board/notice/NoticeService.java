package com.song.mysql.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.song.mysql.board.BoardService;
import com.song.mysql.board.BoardVO;
import com.song.mysql.util.FileManager;
import com.song.mysql.util.FilePathMaker;

@Service
@Transactional
public class NoticeService implements BoardService {

	@Autowired
	private NoticeRepository noticeRepository; 
	@Autowired
	private FilePathMaker pathMaker;	// 파일 경로 생성
	@Autowired
	private FileManager fileManager;	// 파일 저장 매니저
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		
		//File file = pathMaker.getUserResourceLoader(filePath);
		File file = pathMaker.getUseClassPathResource(filePath);
		//File file = pathMaker.getUseServletContext(filePath);
		System.out.println("insert filePath: "+filePath);
		
		for (MultipartFile multipartFile : files) {
			// 빈값 오는거 받지않음
			if(!(multipartFile.getSize() > 0))
				continue;
			
			String fileName = fileManager.saveTransfer(multipartFile, file);
			System.out.println(fileName);
		}
		
		// file Table 에 값 넣기

		// boardTable에 fileVOs 넣고 넣기
		return 0; //noticeRepository.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList() throws Exception {
		// TODO Auto-generated method stub
		return noticeRepository.getSelectList();
	}

}
