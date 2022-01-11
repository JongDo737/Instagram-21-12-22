<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/other_profile.css">
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
                        		<input type="hidden" id="user-id" value="${profileRespDto.userId }"> 
                            <h1 class="profile-username">${profileRespDto.username }</h1>
                            <!-- 로그인 됐을때 안됐을 때  팔로우버튼 -->
                            <c:choose>
                            	<c:when test="${empty principal.user }">
                            		<button type="button" class="logout-follow-btn" onclick="location.href = '/follow/'">팔로우</button>
                            	</c:when>
                            	<c:otherwise>
                            		<button type="button" class="login-follow-btn">${profileRespDto.follow }</button>                            		
                            	</c:otherwise>
                            </c:choose>
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
            <button type="button" class="setting-modal-btn">비밀번호 변경</button>
            <button type="button" class="setting-modal-btn">로그아웃</button>
            <button type="button" class="setting-modal-btn">취소</button>
        </div>
    </div>
    
    <div class="modal-container">
        <i id="close-btn" class="fas fa-times"></i>
        <div class="board-modal-body">
            
        </div>
    </div>
    <input type="hidden" id="username" value="${profileRespDto.username }">
    <input type="hidden" id="board-total-count" value="${profileRespDto.boardTotalCount }">
    <script src="/js/my_profile.js"></script>
</body>

</html>