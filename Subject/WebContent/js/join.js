
//=========================================================
// 초기화 관련
//=========================================================
var authCodeDiv = document.getElementById("authCodeDiv");
var authBtn = document.getElementById("authBtn");
var codeBtn = document.getElementById("codeBtn");
var email = document.getElementById("email");
var name = document.getElementById("name");
var joinButton = document.getElementById("joinBtn");

authCodeDiv.style.display = "none";
email.value="";
email.focus();

//=========================================================
// 이메일 관련
//=========================================================

// 이메일 인증 (메일보내기)
authBtn.addEventListener("click", function() {
	
	var email = document.getElementById("email");
	var emailPart = document.getElementById("emailPart");
	var emailComment = document.getElementById("emailComment");

	// 이메일 주소 비었는지, 이메일 형식인지 확인
	// 나중엔 정규표현식으로 한번 더 이메일 형식 확인
	if(email.value === "" || email.value.indexOf('@') == -1 || email.value.indexOf('.') == -1) {
		emailPart.style.height = "85px";
		emailComment.innerHTML = "이메일을 입력해주세요";
		email.value="";
		email.focus();
		return;
	}

	// 이메일이 비지 않았고, 이메일 형식이라면
	emailPart.style.height = "60px";
	emailComment.innerHTML = "";
	
	// 버튼 눌리면 칸 생성
	authCodeDiv.style.display = "block";
	
	// 이메일 보내기 (서버에 요청)
});

// 인증코드 확인
codeBtn.addEventListener("click", function() {
	
	var code = document.getElementById("code");
	
	// 인증버튼 제한시간 value에 표기(5분 정도)
	// msg = "인증코드 (00:00)";
	
	// 서버에서 맞는 코드 받아옴
	var answerCode = 111111;
	
	// 코드가 다르다면
	if(parseInt(code.value) !== answerCode) {
		authCodeDiv.style.height = "85px";
		codeComment.innerHTML = "코드를 다시 입력해주세요";
		code.value="";
		code.focus();
		return;
	}
	
	// 코드가 맞다면
	authCodeDiv.style.height = "60px";
	codeComment.innerHTML = "";
	authCodeDiv.style.display = "none";

	var email = document.getElementById("email");
	email.setAttribute("readonly","true");
	email.style.cursor="default";
	authBtn.style.color = "#FFFFFF";
	authBtn.style.backgroundColor = "#FD7622";
	authBtn.disabled = 'disabled';
	authBtn.value = "인증확인";
		
	// name으로 넘기기
	var name = document.getElementById("name");
	//name.focus();
});

//=========================================================
// 이름 관련 
//=========================================================

// 여기서부터!
// 이름 입력
name.addEventListener("focus", function() {
	var name = document.getElementById("name");
	var namePart = document.getElementById("namePart");
	var nameCommnet = document.getElementById("nameComment");
	
	// name 입력을 안했다면
	if(name.value === "") {
		namePart.style.height = "85px";
		nameComment.innerHTML = "이름을 입력해주세요";
	}
});

//=========================================================
// 가입버튼 관련
//=========================================================

// 가입하기 버튼
joinButton.addEventListener("click", function() {
	
	// 이메일 이름 비번 비번확인 약관동의
	var email = document.getElementById("email");
	var name = document.getElementById("name");
	var pw = document.getElementById("pw");
	var pwConfirm = document.getElementById("pwConfirm");
	var term = document.getElementById("term");
	
	console.log(email.value);
	console.log(name.value);
	console.log(pw.value);
	console.log(pwConfirm.value);
	console.log(term.checked);
	
	if(email.value.length === 0) {
		alert("이메일을 기입해주세요");
		return false;
	}
	
	if((email.value.indexOf('@') == -1 )&&(email.value.indexOf('.') == -1)) {
		alert("이메일 양식이 맞지 않습니다");
		return false;
	}
	
	if(name.value.length === 0) {
		alert("id를 기입해주세요");
		return false;
	}
	
	if(pw.value.length === 0) {
		alert("password를 기입해주세요");
		return false;
	}
	
	if(pwConfirm.value.length === 0) {
		alert("password를 한번 더 기입해주세요")
		return false;
	}
	
	if(term.checked === false) {
		alert("약관에 동의해주세요");
		return false;
	}
	
	location.href="../pages/login.html";
});