/**
 * 프로필 수정
 */
const principalUsername = document.querySelector('#principal-username');

const profileImg = document.querySelector('#profile-img');
const imgFile = document.querySelector('#file');
const profileImgChangeBtn = document.querySelector('.profile-img-change-btn');

const form = document.querySelector('form');
const submitBtn = document.querySelector('.edit-submit-btn');

const profilelabel = document.querySelectorAll('.edit-lb');
const profileInput = document.querySelectorAll('.profile-ip');


var usernameCheckResult = 'true';

var imgFileChangeFlag = false;

var profileImgFile = '';

imgFile.style.display = 'none';

profileImgChangeBtn.onclick = () => {
	imgFile.click();
}

imgFile.onchange = () => {  //변화가 생기면
	let reader = new FileReader();
	
	reader.onload = (e) => {
		imgFileChangeFlag = true; //이미지 변경된 상태
		profileImgFile = e.target.result;
		profileImg.src = profileImgFile;
	}
	
	reader.readAsDataURL(imgFile.files[0]);
}

function usernameCheck(username) {
	$.ajax({
		type: "get",
		url: "/accounts/username-check",
		data: {
			"username": username
		},
		dataType: "text",
		async: false, // 비동기처리가 아닌 동기처리방식으로 바꿈
		success: function(data){
			usernameCheckResult = data;
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

function inputIsEmpty(str, lb) {
	let result = false;
	
	if(typeof(str) == undefined || str == null || str == ''){
		alert(lb + '은(는) 빈값일 수 없습니다.');
		result = true;
	}
	
	return result;
}

function multipartSubmit() {
	let formData = new FormData(form);
	
	$.ajax({
		type: "put",
		url: "/accounts/edit",
		data: formData,
		dataType: "text",
		enctype: "multipart/form-data",
		processData: false,
		contentType: false,
		success: function(data){
			if(data == 'true'){
				alert('회원정보 수정 성공.');
				const navProfileImg = document.querySelector('#nav-profile-img');
				navProfileImg.src = profileImgFile;
			}
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

function editSubmit() {
	$.ajax({
		type: "put",
		url: "/accounts/edit",
		data: {
			"name": profileInput[0].value,
			"username": profileInput[1].value,
			"website": profileInput[2].value,
			"introduction": profileInput[3].value,
			"email": profileInput[4].value,
			"phone": profileInput[5].value,
			"gender": profileInput[6].value
		},
		dataType: "text",
		success: function(data) {
			if(data == 'true'){
				alert('회원정보 수정 성공.');
				principalUsername.textContent = profileInput[1].value;
			}
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

submitBtn.onclick = () => {
	
	let username = profileInput[1].value;
	let pUsername = principalUsername.textContent;
	
	if(inputIsEmpty(profileInput[0].value, profilelabel[0].textContent)){
		return;
	}
	if(inputIsEmpty(profileInput[1].value, profilelabel[1].textContent)){
		return;
	}
	if(inputIsEmpty(profileInput[4].value, profilelabel[4].textContent)){
		return;
	}
	
	if(username != pUsername){
		usernameCheckResult = false;
		usernameCheck(username);
	}
	
	if(usernameCheckResult == 'true'){
		//서브밋 실행
		if(imgFileChangeFlag == true){
			//파일업로드 필요 o
			multipartSubmit();
		}else {
			//파일업로드 필요 x
			editSubmit();
		}
	}else{
		alert(username + "은(는) 이미 사용중인 사용자 이름입니다.");
	}
}

 