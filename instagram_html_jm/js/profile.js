const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalBtns = modalContainer.querySelectorAll('button');
// modalContainer의 자식요소 중에 데리고와라
const settingBtn = document.querySelector('#setting-btn');

settingBtn.onclick = () => {
    modalContainer.classList.toggle('show');

    if (modalContainer.classList.contains('show')) {    //show 상태면 ?
        body.style.overflow = 'hidden'; // 스크롤 해제
    }
}
modalContainer.onclick = () => {    // 바깥쪽 클릭했을 때
    modalContainer.classList.toggle('show');

    if (!modalContainer.classList.contains('show')) { //show 가 없으면
        body.style.overflow = 'auto';
    }
}
modalBtns[0].onclick = () => {
    location.href = '/accounts/password/change';
}

modalBtns[1].onclick = () => {
    location.replace('/logout');
}
modalBtns[2].onclick = () => {

}