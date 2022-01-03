const uploadFile = document.querySelector('.upload-file');
const addImgBtn = document.querySelector('.add-img-btn');
const uploadImg = document.querySelector('.upload-img');
const imgPreview = document.querySelector('.img-preview');
const imgDeleteBtn = document.querySelector('#img-delete-btn');
const imgAdd = document.querySelector('.img-add');

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