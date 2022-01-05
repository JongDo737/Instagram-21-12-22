const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalBtns = modalContainer.querySelectorAll('button');
// modalContainer의 자식요소 중에 데리고와라
const settingBtn = document.querySelector('#setting-btn');
const usernameObj = document.querySelector('#username');

var page = 0;
var username = usernameObj.value;

window.onscroll = () => {
	console.log('window_scrollTop : ' + $(window).scrollTop());
	console.log('window_height : ' + $(window).height());		// 한 화면이 보여질수 있는 높이
	console.log('document_height : ' + $(document).height()); //문서 전체 높이
	console.log($(document).height() - $(window).height() - $(window).scrollTop()); // 바닥 닿으면 0 이됌

}

function boardLoad() {
	$.ajax({
		type: "get",
		url: `/${username}?page=${page}`,
		dataType: "text",
		success: function(data) {
			let boardList = JSON.parse(data);
			getBoardItem(boardList)
		},
		error: function() {

		}

	})
}

function getBoardGroup(boardList) {
	let boardGroup =	`
		<div class="board-item-group">
			<div class="board-item">
				<img src="/images/signin_title.PNG" alt="">
					<div class="board-item-hover">
						<div class="board-item-like">
							<i class="fas fa-heart"></i><span>91</span>
						</div>
						<div class="board-item-comment">
							<i class="fas fa-comments"></i><span>30</span>
						</div>
					</div>
                            </div>
				<div class="board-item">
					<img src="" alt="">
						<div class="board-item-hover">
							<div class="board-item-like">
								<i class="fas fa-heart"></i><span>91</span>
							</div>
							<div class="board-item-comment">
								<i class="fas fa-comments"></i><span>30</span>
							</div>
						</div>
                  	</div>
					<div class="board-item">
						<img src="" alt="">
							<div class="board-item-hover">
								<div class="board-item-like">
									<i class="fas fa-heart"></i><span>91</span>
								</div>
								<div class="board-item-comment">
									<i class="fas fa-comments"></i><span>30</span>
								</div>
							</div>
                        </div>
					</div>
		`;
}

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