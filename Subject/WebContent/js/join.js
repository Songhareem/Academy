/**
 * 
 */

// 가입하기 버튼
var joinButton = document.getElementById("joinBtn");

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