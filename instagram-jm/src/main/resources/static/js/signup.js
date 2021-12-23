/**
 * 회원가입
 */
 
const signupInputs = document.querySelectorAll('.su-input');
const submitBtns = document.querySelectorAll('.su-submit-btn');

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
			
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

submitBtns[1].onclick = () => {
	signup();
}