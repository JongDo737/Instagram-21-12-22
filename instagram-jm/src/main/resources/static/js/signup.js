/**
 * 회원가입
 */

const signupInputs = document.querySelectorAll('.su-input');
const submitBtns = document.querySelectorAll('.su-submit-btn');

function signupValidMsg(data) {
	let signupDataObj = JSON.parse(data);
	if (signupDataObj.code == 400) {

		alert(
			'유혀성 검사 오류.\n' +
			'오류 코드 : ' + signupDataObj.code + '\n' +
			'오류 내용\n' +
			'email : ' + signupDataObj.data.email + '\n' +
			'name : ' + signupDataObj.data.name + '\n' +
			'username : ' + signupDataObj.data.username + '\n' +
			'password : ' + signupDataObj.data.password + '\n'
		)
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
		success: function(data) { //제이슨 데이터가 넘어옴
			//alert(data);
			signupValidMsg(data);
		},
		error: function() {
			alert('비동기 처리 오류.');
		}
	});
}

submitBtns[1].onclick = () => {
	signup();
}