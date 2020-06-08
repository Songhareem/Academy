package com.song.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	// 검증 메서드
		public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
			
			// 1. Annotation으로 가능한 검증
			if(bindingResult.hasErrors()) {
				System.out.println("type err");
				return true;
			}
			
			// 2. ID 중복 검증
			if(memberRepository.existsById(memberVO.getId())) {
				
				System.out.println("id 중복 err");
				bindingResult.rejectValue("id", "memberVO.id.same");
				return true;
			}
			
			// 3. pw 일치여부
			if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
						
				System.out.println("pw 불일치 err");
				bindingResult.rejectValue("pwCheck", "memberVO.password.notEqual");
				return true;
			}
			
			// 전부 통과
			System.out.println("all pass");
			return false;
		}
		
		public MemberVO memberJoin(MemberVO memberVO) throws Exception {
			
			// 있다면 null return , 없다면 save후, save된 vo return
			if(memberRepository.existsById(memberVO.getId())) {
				System.out.println("memberService.memberJoin : 검증 후, 중복 아이디 도달");
				return null;
			}
			
			return memberRepository.save(memberVO);
		}
		
		public MemberVO memberLogin(MemberVO memberVO) throws Exception {
			
			// 입력한 아이디  비번이 같다면 return vo, 아니라면 null
//			MemberVO findVO = memberRepository.getOne(memberVO.getId());
//			if(findVO.getPw().equals(memberVO.getPw())) {
//				return findVO;
//			}
//			return null;
			
			return memberRepository.findLoginMember(memberVO.getId(), memberVO.getPw());
		}
}
