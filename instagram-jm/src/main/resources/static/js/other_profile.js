const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalBtns = modalContainer.querySelectorAll('button');
const usernameObj = document.querySelector('#username');
const boardContainer = document.querySelector('.board-container');
const boardTotalCount = document.querySelector('#board-total-count');
const logoutFollowBtn = document.querySelector('.logout-follow-btn');
var boardItem = document.querySelectorAll('.board-item');
const loginFollowBtn = document.querySelector('.login-follow-btn');
const userIdObj = document.querySelector('#user-id');

var userId = userIdObj.value;

var page = 0;
var username = usernameObj.value;
var boardGroupItem = ``;
var boardTotal = boardTotalCount.value;

window.onscroll = () => {
	let checkNum = $(document).height()-$(window).height()-$(window).scrollTop();
	
	if(checkNum < 1 && checkNum > -1 && boardTotal > (page+1)*9) {
		page++;
		boardLoad();
	}
}

modalContainer.onclick = (event) => {
	if(event.target == modalContainer){
	    modalContainer.classList.toggle('show');
	
	    if (!modalContainer.classList.contains('show')) {
	        body.style.overflow = 'auto';
	    }
	}
}

boardLoad();

function boardLoad() {
	$.ajax({
		type: "get",
		url: `/${username}/board?page=${page}`,
		dataType: "text",
		success: function(data){
			let boardGroupObj = JSON.parse(data);
			boardGroupItem += getBoardGroup(boardGroupObj.boardGroup);
			boardContainer.innerHTML = boardGroupItem;
			boardItem = document.querySelectorAll('.board-item');
			boardItemClick();
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

function getBoardList(boardList) {
	let result = ``;
	
	for(let board of boardList) {
		result += `
			<div class="board-item">
				<input type="hidden" id="board_id" value="${board.id}">
                <img src="/image/${board.board_img}" alt="">
                <div class="board-item-hover">
                    <div class="board-item-like">
                        <i class="fas fa-heart"></i><span>0</span>
                    </div>
                    <div class="board-item-comment">
                        <i class="fas fa-comment"></i><span>0</span>
                    </div>
                </div>
            </div>
		`;
	}
	return result;
}

function getBoardGroup(boardGroup) {
	let boardGroupHtml = ``;
	
	for(let boardList of boardGroup){
		let boardListHtml = getBoardList(boardList);
		
		boardGroupHtml += `
			<div class="board-item-group">
            	${boardListHtml}
        	</div>
		`;
	}
	
	return boardGroupHtml;
}

if(typeof(logoutFollowBtn) != undefined && logoutFollowBtn != null){
	logoutFollowBtn.onclick = () => {
		location.href = '/';
	}
}

function getBoardItem(board){
	let result = `
		<div class="board-modal-img">
            <img class="board-modal-img-preview" src="/image/${board.boardImg }">
        </div>
        <div class="board-modal-section">
            <div class="board-modal-profile">
                <div class="profile-img-border">
                    <img src="/image/${board.profileImg }">
                </div>
                <div class="username-lb">
                    <a href="/${board.username }">
                        <h1>${board.username }</h1>
                    </a>
                </div>
            </div>
            <div class="board-modal-contents">
                <div class="board-modal-content">
                    <div class="profile-img-border">
                        <img src="/image/${board.profileImg }">
                    </div>
                    <pre><div class="username-lb"><a href="/${board.username }"><h1>${board.username }</h1></a></div>${board.boardContent}</pre>
                </div>
                <div class="board-modal-comment">
                </div>
            </div>
            <div class="board-modal-items">
                <i class="far fa-heart"></i>
                <i class="far fa-comment"></i>
                <i class="far fa-paper-plane"></i>
            </div>
            <div class="board-modal-like-info">
                <span>aaaa님 외 55명이 좋아합니다</span>
            </div>
            <div class="board-modal-comment-input">
                <input type="text">
                <button type="button">게시</button>
            </div>
        </div>
	`;
	return result;
}

function getBoard(i){
	let boardId = boardItem[i].querySelector('#board_id');
	$.ajax({
		type: "get",
		url: `/board/${boardId.value}`,
		dataType: "text",
		success: function(data){
			let board = JSON.parse(data);
			let boardModalBody = document.querySelector('.board-modal-body');
			boardModalBody.innerHTML = getBoardItem(board);
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

function boardItemClick() {
	for(let i = 0; i < boardItem.length; i++){
		boardItem[i].onclick = () => {
			modalContainer.classList.toggle('show');
		
		    if (modalContainer.classList.contains('show')) {
		        body.style.overflow = 'hidden';
		    }
		    getBoard(i);
		}
	}
}

function follow(){
	$.ajax({
		type: 'post',
		url: `/api/follow/${userId}`,
		dataType: 'text',
		success: function(data){
			if(data == '1'){
				loginFollowBtn.textContent = '팔로우 취소';
			}
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

function followCancel(){
	$.ajax({
		type: 'delete',
		url: `/api/follow/${userId}`,
		dataType: 'text',
		success: function(data){
			if(data == '1'){
				loginFollowBtn.textContent = '팔로우';
			}
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
	});
}

loginFollowBtn.onclick = () => {
	if(loginFollowBtn.textContent == '팔로우'){
		// Post -> /api/follow/userId
		follow();
	}else {
		// Delete -> /api/follow/userId
		followCancel();
	}
}