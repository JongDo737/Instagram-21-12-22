<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/my_profile.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <section>
        <jsp:include page="../include/nav.jsp"></jsp:include>
        <main>
            <div class="container">
                <header class="profile-header">
                    <div class="profile-img">
                        <img src="/image/${profileRespDto.profile_img }">
                    </div>
                    <div class="profile-info">
                        <div class="profile-info-top">
                            <h1 class="profile-username">${profileRespDto.username }</h1>
                            <button type="button" class="profile-edit-btn" onclick="location.href='/accounts/edit'">프로필 편집</button>
                            <i id="setting-btn" class="fas fa-cog"></i>
                        </div>
                        <div class="profile-info-middle">
                            <div class="profile-info-middle-item">게시물 <span>${profileRespDto.boardTotalCount }</span></div>
                            <div class="profile-info-middle-item cursor-pointer">팔로워 <span>${profileRespDto.followerCount }</span></div>
                            <div class="profile-info-middle-item cursor-pointer">팔로우 <span>${profileRespDto.followingCount }</span></div>
                        </div>
                        <div class="profile-info-bottom">
                            <pre>${profileRespDto.introduction }</pre>
                        </div>
                    </div>
                </header>
                <section>
                    <div class="board-menu">
                        <div class="board-menu-item">
                            <i class="fas fa-table"></i> <span>게시물</span>
                        </div>
                    </div>
                    <div class="board-container">
                        
                    </div>
                </section>
            </div>
        </main>
    </section>
    <div class="modal-container">
        <div class="setting-modal">
            <button type="button">비밀번호 변경</button>
            <button type="button">로그아웃</button>
            <button type="button">취소</button>
        </div>
    </div>
    
    <input type="hidden" id="username" value="${profileRespDto.username }">
    <input type="hidden" id="board-total-count" value="${profileRespDto.boardTotalCount }">
    <script src="/js/my_profile.js"></script>
</body>

</html>