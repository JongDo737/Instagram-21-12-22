/**
 * 
 */
 
 const passwordSubmitBtn = document.querySelector('.password-submit-btn');
 const prePasswordInput = document.querySelector('#pre-password-ip');
 const newPasswordInput = document.querySelector('#new-password-ip');
 const newRePasswordInput = document.querySelector('#new-repassword-ip');
 
 function passwordSubmit(){
	
	$.ajax({
		type: "put",
		url: "/accounts/password/change",
		data: {
			"prePassword": prePasswordInput.value,
			"newPassword": newPasswordInput.value 
		},
		dataType: "text",
		success: function(data){
			let passwordRespObj = JSON.parse(data);
			alert(passwordRespObj.message); 
			
			if(passwordRespObj.code == 200){
				location.replace('/logout'); 
				//redirect를 쓰면 뒤로가기해도 로그인이 안됌 302상테 
				//변경되면 다시 로그인하라고 로그아웃 시킴
				alert('다시 로그인 하세요');
			}
			
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}
 
 passwordSubmitBtn.onclick = () => {
	if(newPasswordInput.value != newRePasswordInput.value){
		alert('새 비밀번호가 일치하지 않습니다.');
		return;
	}
	passwordSubmit();
}