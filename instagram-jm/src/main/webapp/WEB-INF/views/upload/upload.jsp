<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/upload.css">
    <script src="https://kit.fontawesome.com/fab8e6b94b.js" crossorigin="anqonymous"></script>
</head>

<body>
    <section>
        <nav class="nav-bar">
            <div class="nav-main">
                <div class="nav-logo">
                    <a href="#">
                        <img src="/images/instagram_logo.PNG">
                    </a>
                </div>
                <div class="nav-search">
                    <div class="nav-search-border">
                        <i class="fas fa-search"></i>
                        <input type="text" class="nav-search-ip" placeholder="검색">
                    </div>
                </div>
                <div class="nav-items">
                    <div class="nav-item">
                        <i class="fas fa-home" id="nav-home-icon"></i>
                    </div>
                    <div class="nav-item">
                        <i class="far fa-plus-square" id="nav-plus-icon"></i>
                    </div>
                    <div class="nav-item">
                        <div class="nav-items-profile">
                            <img src="/images/signin_title.JPG">
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <main>
            <form>
                <div class="container">
                    <section class="img-section">
                        <div class="img-preview">
                            <img src="images/signin_title.PNG" class="upload-img">
                            <i id="img-delete-btn" class="far fa-times-circle"></i>
                        </div>
                        <div class="img-add">
                            <i id="add-icon" class="fas fa-photo-video"></i>
                            <input type="file" class="upload-file" name="file" style="display: none;">
                            <p>사진과 동영상을 추가해주세요</p>
                            <button class="add-img-btn">컴퓨터에서 선택</button>
                        </div>
                    </section>
                    <article class="img-article">
                        <div class="profile-info">
                            <div class="profile-img-border">
                                <img src="/images/signin_title.JPG">
                            </div>
                            <div class="username-lb">
                                <h1>jongmin</h1>
                            </div>
                        </div>
                        <div class="upload-content-border">
                            <textarea class="upload-context" name=""></textarea>
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