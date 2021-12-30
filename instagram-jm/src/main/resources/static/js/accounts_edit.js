/**
 * 프로필 수정
 */
 const profileImg = document.querySelector('#profile_img');
 const imgFile = document.querySelector('#file');
 const profileImgChangeBtn = document.querySelector('.profile-img-change-btn')
 const form = document.querySelector('form');
 const submitBtn = document.querySelector('.edit-submit-btn');
 
 
 imgFile.style.display = 'none';
 profileImgChangeBtn.onclick = () => {
	imgFile.click();
}
// 단순히 보이는 이미지를 바꾼것 (db x)
imgFile.onchange = () => {	 //변화가 생기면
	let reader = new FileReader();
	
	reader.onload = (e) => {
		profileImg.src = e.target.result;
	}
	
	reader.readAsDataURL(imgFile.files[0]);
}

function usernameCheck(){
	const usernameInput = document.querySelector('#username-ip');
	
	$.ajax({
		type: "get",
		url: "/accounts/username-check",
		data: {
			username: usernameInput.value
		},
		dataType: "text",
		success: function(data){
			
		},
		error: function(){
			alert('비동기 처리오류');
		}
	});
	
	
}

submitBtn.onclick = () => {
	
}




