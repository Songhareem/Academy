
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
