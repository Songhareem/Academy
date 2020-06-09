package com.song.s1.member;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.song.s1.util.FileManager;
import com.song.s1.util.FilePathMaker;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FilePathMaker pathMaker; // 파일 경로 생성
	@Autowired
	private FileManager fileManager; // 파일 저장 매니저
	@Value("${board.member.filePath}")
	private String filePath;

	// memberJoin
	public MemberVO memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		
		System.out.println("service");
		
		// filePath 지정
		File fileInfo = pathMaker.getUseClassPathResource(filePath);
		System.out.println("join filePath: "+filePath);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		if(files != null) {
		
			System.out.println("not null");
			
			// 들어온 file 및 member 데이터 연관시키기
			String fileName = fileManager.saveTransfer(files, fileInfo);
			memberFileVO.setFileName(fileName);
			memberFileVO.setOriName(files.getOriginalFilename());
			memberFileVO.setMemberVO(memberVO);
			
			memberVO.setMemberFileVO(memberFileVO);
		} else {
			System.out.println("null");
		}
		
		// DB에 save
		return memberRepository.save(memberVO);
	}

	public MemberVO memberLogin(MemberVO memberVO) throws Exception {

		// 입력한 아이디 비번이 같다면 return vo, 아니라면 null
//			MemberVO findVO = memberRepository.getOne(memberVO.getId());
//			if(findVO.getPw().equals(memberVO.getPw())) {
//				return findVO;
//			}
//			return null;

		return memberRepository.findLoginMember(memberVO.getId(), memberVO.getPw());
	}

	public MemberVO memberUpdate(MemberVO memberVO) throws Exception {

		// update 전 조회 후, 데이터 null이라면 입력
		MemberVO findVO = memberRepository.getOne(memberVO.getId());

		if (memberVO.getName() == null || memberVO.getName().equals("")) {
			memberVO.setName(findVO.getName());
		} else if (memberVO.getPw() == null || memberVO.getPw().equals("")) {
			memberVO.setPw(findVO.getPw());
		} else if (memberVO.getPhone() == null || memberVO.getPhone().equals("")) {
			memberVO.setPhone(findVO.getPhone());
		} else if (memberVO.getEmail() == null || memberVO.getEmail().equals("")) {
			memberVO.setEmail(findVO.getEmail());
		}

		// 이미지 업데이트 부분 안했음
		
		return memberRepository.save(memberVO);
	}

	// 검증 메서드
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {

		// 1. Annotation으로 가능한 검증
		if (bindingResult.hasErrors()) {
			System.out.println("type err");
			return true;
		}

		// 2. ID 중복 검증
		if (memberRepository.existsById(memberVO.getId())) {

			System.out.println("id 중복 err");
			bindingResult.rejectValue("id", "memberVO.id.same");
			return true;
		}

		// 3. pw 일치여부
		if (!memberVO.getPw().equals(memberVO.getPwCheck())) {

			System.out.println("pw 불일치 err");
			bindingResult.rejectValue("pwCheck", "memberVO.password.notEqual");
			return true;
		}

		// 전부 통과
		System.out.println("all pass");
		return false;
	}
	
	public boolean memberDelete(MemberVO memberVO) throws Exception {
		
		// 삭제
		memberRepository.deleteById(memberVO.getId());
		
		System.out.println("deleted");
		
		// exists로 삭제가 됐는지 확인, 존재한다면 return 0, 존재하지않는다면 return 1
		return !memberRepository.existsById(memberVO.getId());
	}
}
