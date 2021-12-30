/**
 * 
 */
 
 const passwordSubmitBtn = document.querySelector('.password-submit-btn');
 const prePasswordInput = document.querySelector('#pre-password-ip');
 const newPasswordInput = document.querySelector('#new-password-ip');
 const newRePasswordInput = document.querySelector('#new-repassword-ip');
 
 function passwordSubmit(){
	
	$({
		
	});
}
 
 passwordSubmitBtn.onclick = () => {
	if(newPasswordInput.value != newRePasswordInput.value){
		alert('새 비밀번호가 일치하지 않습니다.');
		return;
	}
}