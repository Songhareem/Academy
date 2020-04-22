package com.song.Spring_legacy2.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.song.Spring_legacy2.member.memberFile.MemberFileDAO;
import com.song.Spring_legacy2.member.memberFile.MemberFileVO;
import com.song.Spring_legacy2.util.FileSaver;
import com.song.Spring_legacy2.util.Pager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	// memberList
	public List<MemberVO> memberList(Pager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = memberDAO.memberCount(pager);
		pager.makePage(totalCount);
		return memberDAO.memberList(pager);
	}
	
	// memberJoin
	public int memberJoin(MemberVO memberVO, MultipartFile thumb, HttpSession session) throws Exception {

		// 1. 실제 경로 가져오기
		String path = session.getServletContext().getRealPath("/resources/images/memberUpload"); // Application 객체 가져옴
		System.out.println(path);
		
		// 2. HDD에 저장
		String fileName = fileSaver.saveByUtils(thumb, path);
		//String fileName = fileSaver.saveByTransfer(thumb, path);
		//String fileName = fileSaver.saveByStream(thumb, path);
		
		// 2-1. memberFileVO 값 넣기
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriginName(thumb.getOriginalFilename());
		
		// 3. DB에 반영		
		int result = memberDAO.memberJoin(memberVO);
		return memberFileDAO.memberFileInsert(memberFileVO);
	}

	// memberLogin
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {

		return memberDAO.memberLogin(memberVO);
	}

	// memberUpdate
	public int memberUpdate(MemberVO memberVO) throws Exception {

		return memberDAO.memberUpdate(memberVO);
	}

	// memberDelete
	public int memberDelete(MemberVO memberVO) throws Exception {

		return memberDAO.memberDelete(memberVO);
	}
	
	// memberPage
	public MemberFileVO memberPage(MemberFileVO memberFileVO) throws Exception {
		
		return memberFileDAO.memberFileSelect(memberFileVO);
	}
	
	// memberFileDelete
	public int MemberFileDelete(MemberFileVO memberFileVO, HttpSession session) throws Exception {
		
		memberFileVO = memberFileDAO.memberFileSelect(memberFileVO);
		int result = memberFileDAO.memberFileDelete(memberFileVO);
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/memberUpload");
			result = fileSaver.deleteFile(memberFileVO.getFileName(), path);
			System.out.println("result : " + result);
		}
		return result; 
	}
}
