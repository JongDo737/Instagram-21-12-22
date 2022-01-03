/**
 * 회원가입
 */
 
const signupInputs = document.querySelectorAll('.su-input');
const submitBtns = document.querySelectorAll('.su-submit-btn');

function isEmpty(str){
	if(typeof str == "undefined" || str == null || str == ''){
		return '사용가능';
	}else {
		return str;
	}
}

function signupValidMsg(data){
	let signupDataObj = JSON.parse(data);
	if(signupDataObj.code == 400){
		alert(
			'유효성 검사 오류.\n' + 
			'오류코드: ' + signupDataObj.code + '\n' +
			'오류 내용\n' +
			'email: ' + isEmpty(signupDataObj.data.email) + '\n' +
			'name: ' + isEmpty(signupDataObj.data.name) + '\n' +
			'username: ' + isEmpty(signupDataObj.data.username) + '\n' +
			'password: ' + isEmpty(signupDataObj.data.password)
		);
	}else if(signupDataObj.code == 401){
		alert(
			'아이디 중복 오류.\n' + 
			'오류코드: ' + signupDataObj.code + '\n' +
			'오류 내용\n' +
			signupDataObj.data
		);
	}else if(signupDataObj.code == 200){
		alert(signupDataObj.data);
		location.replace('/auth/signin');
	}
}

function signup() {
	let signupObj = {
		email: signupInputs[0].value,
		name: signupInputs[1].value,
		username: signupInputs[2].value,
		password: signupInputs[3].value
	}
	
	$.ajax({
		type: "post",
		url: "/auth/signup",
		data: signupObj,
		dataType: "text",
		success: function(data) {
			signupValidMsg(data);
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

submitBtns[1].onclick = () => {
	signup();
}