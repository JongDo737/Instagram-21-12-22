/**
 * 
 */
const uploadFile = document.querySelector('.upload-file');
const addImgBtn = document.querySelector('.add-img-btn');
const uploadImg = document.querySelector('.upload-img');
const imgPreview = document.querySelector('.img-preview');
const imgDeleteBtn = document.querySelector('#img-delete-btn');
const imgAdd = document.querySelector('.img-add');
const uploadContent = document.querySelector('.upload-content');
const uploadSubmitBtn = document.querySelector('.upload-submit-btn');
const form = document.querySelector('form');

imgPreview.style.display = 'none';

var uploadImgFile = '';

uploadFile.onchange = () => {
    let reader = new FileReader();

    reader.onload = (e) => {
        imgPreview.style.display = 'flex';
        imgAdd.style.display = 'none';
        uploadImgFile = e.target.result;
        uploadImg.src = uploadImgFile;
    }

    reader.readAsDataURL(uploadFile.files[0]);
}

addImgBtn.onclick = () => {
    uploadFile.click();
}

imgDeleteBtn.onclick = () => {
    uploadFile.value = '';
    uploadFile.files[0] = null;
    uploadFile.src = '';
    imgPreview.style.display = 'none';
    imgAdd.style.display = 'flex';
}
function isEmpty(str){
	if(typeof(str)== undefined || str == null || str== 'null' || str == ''){
		return true;	
	}else{
		return false;
	}
}
function uploadSubmit(){
	let formData = new FormData(form);
	$.ajax({
		type: "post",
		url: "/upload",
		data: formData,
		dataType: "text",
		enctype: "multipart/form-data", // 이거
		processData: false,				// 이거
		contentType: false,				// 이게 세가지 해줘야 폼데이터 넘김
		success: function(data){
			
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

uploadSubmitBtn.onclick = () => {
	if(isEmpty(uploadFile.value)){
		alert('이미지를 추가해 주세요');
	}
	else if(isEmpty(uploadContent.value)){
		alert('내용을 입력해주세요');
	}else{
		// submit 통과
		uploadSubmit();
	}
	
	
	
	
	
	
	
	
	
}