package com.song.Spring_legacy2.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.song.Spring_legacy2.board.BoardService;
import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.board.file.BoardFileDAO;
import com.song.Spring_legacy2.board.file.BoardFileVO;
import com.song.Spring_legacy2.util.FileSaver;
import com.song.Spring_legacy2.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] files) throws Exception {
		
		String path = servletContext.getRealPath("/resources/images/noticeUpload");
		System.out.println(path);

		// get notice seq
		boardVO.setNum(noticeDAO.boardNum());
		
		int result = noticeDAO.boardWrite(boardVO);
		
		for (MultipartFile file : files) {
			
			if(file.getSize() == 0) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriginName(file.getOriginalFilename());
			boardFileVO.setBoard(1);
			boardFileDAO.boardFileInsert(boardFileVO);
		}

		return result;
	}

	@Override
	public long boardCount(Pager pager) throws Exception {
		
		return noticeDAO.boardCount(pager);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = noticeDAO.boardCount(pager);
		pager.makePage(totalCount);
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile[] files) throws Exception {
		
		String path = servletContext.getRealPath("/resources/images/noticeUpload");
		System.out.println(path);
		
		int result = noticeDAO.boardUpdate(boardVO);
		
		for (MultipartFile file : files) {
			
			if(file.getSize() == 0) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriginName(file.getOriginalFilename());
			boardFileVO.setBoard(1);
			result = boardFileDAO.boardFileInsert(boardFileVO);
		}

		return result;
	}

	@Override
	public int hitUpdate(BoardVO boardVO) throws Exception {
		
		return noticeDAO.hitUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		
		String path = servletContext.getRealPath("/resources/images/noticeUpload");

		List<BoardFileVO> list = boardFileDAO.boardFileList(num);
		
		// 1. HDD 에서 삭제
		for (BoardFileVO boardFileVO : list) {
			
			fileSaver.deleteFile(boardFileVO.getFileName(), path);
		}
		
		// 2. DB(boardFile) 에서 file삭제
		boardFileDAO.boardFileDeleteCascade(num);
		
		return noticeDAO.boardDelete(num);
	}

	
}
