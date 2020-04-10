
# Servlet_3

## 기능

- member
	- 회원가입(Insert)
	- 로그인(Select One)
	- 회원정보 수정(Update)
	- 회원탈퇴(Delete)
	- 회원정보

- point/
	- point list 출력
	- point 등록
	- point 상세 정보 출력
	- point 수정
	- point 삭제

- notice
	- 공지사항(Notice) 게시판
	- 글쓰기, 수정, 삭제  (id가 admin 만 가능)
	- 리스트 페이지
	- 최신순으로 출력
	- 글쓰기 버튼 클릭시, 글쓰기로 이동
	- 리스트 페이지에서 글제목 누르면 글내용 보기 가능(상세보기)
	- 글 상세보기에 글 수정, 글 삭제 버튼이 있음
	- 글삭제 버튼 누르면 확인, 취소 창을 띄우고 확인을 누르면 삭제
	- 글수정 버튼 누르면 글 수정페이지로 이동
	- option / 글보기 시, 조회수 1 증가
	
## JSP

- /WEB-INF/views/member/*
	- memberJoin.jsp	: 회원가입 폼
	- memberLogin.jsp	: 로그인 폼
	- member

- /WEB-INF/views/point/*
    - pointList.jsp     : point list 출력
    - pointAdd.jsp      : 입력폼
    - pointSelect.jsp   : point 상세정보 출력
    - pointMod.jsp      : point 수정
    
- /WEB-INF/views/notice/*
	- noticeList.jsp	: notice list 출력
	- noticeAdd.jsp		: notice 입력
	- noticeSelect.jsp	: notice 상세정보 출력
	- noticeMod.jsp		: notice 수정
		
## URL

- member
	- /member/memberJoin	| GET	| memberJoin.jsp
	- /member/memberJoin	| POST	| 
	- /member/memberLogin	| GET	| memberLogin.jsp
	- /member/memberLogin	| POST	|
	- /member/memberUpdate	| GET	| memberUpdate.jsp
	- /member/memberUpdate 	| POST	|
	- /member/memberPage	| GET	| memberPage.jsp
	- /member/memberDelete	| GET	|

- point
	- /point/pointList      | GET   | pointList.jsp
	- /point/pointAdd       | GET   | pointAdd.jsp
	- /point/pointAdd       | POST  |
	- /point/pointSelect    | GET   | pointSelect.jsp
	- /point/pointMod       | GET   | pointMod.jsp
	- /point/pointMod       | POST  | 
	- /point/pointDel       | GET   |

- notice
	- /notice/noticeList	| GET	| noticeList.jsp
	- /notice/noticeAdd		| GET	| noticeAdd.jsp
	- /notice/noticeAdd		| POST	|
	- /notice/noticeSelect	| GET	| noticeSelect.jsp
	- /notice/noticeMod		| GET	| noticeMod.jsp
	- /notice/noticeMod		| POST	|
	- /notice/noticeDel		| GET	|
	