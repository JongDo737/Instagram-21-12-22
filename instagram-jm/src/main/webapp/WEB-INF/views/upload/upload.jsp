<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/upload.css">
    <script src="https://kit.fontawesome.com/fab8e6b94b.js" crossorigin="anqonymous"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <section>
        <jsp:include page="../include/nav.jsp"></jsp:include>
        <main>
            <form>
                <div class="container">
                    <section class="img-section">
                        <div class="img-preview">
                            <img src="" class="upload-img">
                            <i id="img-delete-btn" class="far fa-times-circle"></i>
                        </div>
                        <div class="img-add">
                            <i id="add-icon" class="fas fa-photo-video"></i>
                            <input type="file" class="upload-file" name="file" style="display: none;">
                            <p>사진과 동영상을 추가해주세요</p>
                            <button type="button" class="add-img-btn">컴퓨터에서 선택</button>
                        </div>
                    </section>
                    <article class="img-article">
                        <div class="profile-info">
                            <div class="profile-img-border">
                                <img src="/image/${principal.userDtl.profile_img }">
                            </div>
                            <div class="username-lb">
                                <h1>${principal.user.username }</h1>
                            </div>
                        </div>
                        <div class="upload-content-border">
                            <textarea class="upload-content" name="boardContent"></textarea>
                        </div>
                        <div class="upload-submit-btn">공유하기</div>
                    </article>
                </div>
            </form>
        </main>
    </section>
    <script src="/js/upload.js"></script>
</body>

</html>