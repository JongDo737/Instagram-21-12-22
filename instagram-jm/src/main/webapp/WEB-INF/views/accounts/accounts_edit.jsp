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
    <link rel="stylesheet" href="/css/accounts_menu.css">
    <link rel="stylesheet" href="/css/accounts_edit.css">
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
            <div class="container">
                <ul class="menu-list">
                    <li class="menu-li">
                        <a href="#" class="menu-li-a-select">프로필 편집</a>
                    </li>
                    <li class="menu-li">
                        <a href="#" class="menu-li-a">비밀번호 변경</a>
                    </li>
                </ul>
                <article>
                    <div class="edit-profile-img">
                        <div class="edit-profile-img-border">
                            <img src="/images/signin_title.JPG">
                        </div>
                        <div class="username-lb">
                            <h1>jongmin</h1>
                            <div class="profile-img-change-btn">프로필 사진 바꾸기</div>
                        </div>
                    </div>
                    <form action="">
                        <div class="edit-items">
                            <aside>
                                <label for="name-ip" class="edit-lb">이름</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="name-ip" name="name">
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="username-ip" class="edit-lb">사용자 이름</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="username-ip" class="edit-ip" name="username">
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="website-ip" class="edit-lb">웹사이트</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="website-ip" class="edit-ip" name="website">
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="introduction-ip" class="edit-lb">소개</label>
                            </aside>
                            <div class="edit-ip">
                                <textarea id="introduction-ip" class="edit-ip" name="introduction"></textarea>
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="email-ip" class="edit-lb">이메일</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="email-ip" class="edit-ip" name="email">
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="phone-ip" class="edit-lb">전화번호</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="phone-ip" class="edit-ip" name="phone">
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="gender-ip" class="edit-lb">성별</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" list="gender-ip" name="gender">
                                <datalist id="gender-ip">
                                    <option value="1">남성</option>
                                    <option value="2">여성</option>
                                    <option value="3">맞춤성별</option>
                                    <option value="4">밝히고 싶지 않음</option>
                                </datalist>
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                            </aside>
                            <div class="edit-ip">
                                <button type="button" class="edit-submit-btn">제출</button>
                            </div>
                        </div>


                    </form>
                </article>
            </div>
        </main>
    </section>
</body>

</html>