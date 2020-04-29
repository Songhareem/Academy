package com.song.Spring_legacy2.board.file;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.song.Spring_legacy2.util.FileSaver;

@Service
public class BoardFileService {

	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private FileSaver fileSaver; 
	
	// select
	public BoardFileVO boardFileSelect(BoardFileVO boardFileVO) throws Exception {
		
		return boardFileDAO.boardFileSelect(boardFileVO);
	}
	
	// insert
	public String boardFileInsert(MultipartFile files, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath("/resources/images/summer");
		System.out.println(path);
		path = fileSaver.saveByTransfer(files, path);
		path = session.getServletContext().getContextPath() + "/resources/images/summer/" + path;
		return path;
	}
	
	// fileDelete
	public int boardFileDelete(String fileName, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/images/summer");
		return  fileSaver.deleteFile(fileName, path);
	}
	
	// delete
	public int boardFileDelete(BoardFileVO boardFileVO, HttpSession session) throws Exception {
		
		// 조회
		boardFileVO = boardFileDAO.boardFileSelect(boardFileVO);

		// DB에서 삭제		
		int result = boardFileDAO.boardFileDelete(boardFileVO);
				
		// HDD에서 삭제
		String path = "";
		String fileName = boardFileVO.getFileName();
		switch(boardFileVO.getBoard()) {
		case 1:
			path = session.getServletContext().getRealPath("/resources/images/noticeUpload");
			break;
		case 2:
			path = session.getServletContext().getRealPath("/resources/images/qnaUpload");
			break;
		default:
			break;
		}
		
		fileSaver.deleteFile(fileName, path);
		
		return result;
	}
}
