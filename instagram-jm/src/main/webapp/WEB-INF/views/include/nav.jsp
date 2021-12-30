<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 인증이 되었을때 principal 변수명으로 프린시펄 데이터를 들고오는거임 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	
</sec:authorize>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://kit.fontawesome.com/fab8e6b94b.js" crossorigin="anqonymous"></script>
</head>
<body>
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
                 	<a href="/accounts/edit">
                     	<div class="nav-items-profile">
                         	<img src="/image/${principal.userDtl.profile_img }">
                         	
                     	</div>
                 	</a>
                 </div>
             </div>
         </div>
     </nav>
</body>
</html>