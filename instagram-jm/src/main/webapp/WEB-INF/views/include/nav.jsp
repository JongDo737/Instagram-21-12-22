<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/nav.css">
	<script src="https://kit.fontawesome.com/fab8e6b94b.js" crossorigin="anonymous"></script>
</head>
<body>
		<nav class="nav-bar">
            <div class="nav-main">
                <div class="nav-logo">
                    <a href="/">
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
                	<!-- else-if 라고 생각하면 됌 principal.user가 비어있으면 --> 
                	<c:choose>
                		<c:when test="${empty principal.user }"> 
                			<div class="nav-item">
                        		<button type="button" class="signin-btn" onclick="location.href = '/auth/signin'">로그인</button>
                    		</div>
                    		<div class="nav-item">
                        		<button type="button" class="signup-btn" onclick="location.href = '/auth/signup'">가입하기</button>                        		
                    		</div>
                		</c:when>
                		<c:otherwise>
                			<div class="nav-item">
                				<a href="/">                				
                        			<i class="fas fa-home" id="nav-home-icon"></i>
                				</a>
                    		</div>
                    		<div class="nav-item">
                    			<a href="/upload">
                      		  		<i class="far fa-plus-square" id="nav-plus-icon"></i>
                    			</a>
                    		</div>
                   		 	<div class="nav-item">
                   		 		<a href="/${principal.username}">
                    				<div class="nav-items-profile">
	                           			<img id="nav-profile-img" src="/image/${principal.userDtl.profile_img }">
	                        		</div>
                    			</a>
                    		</div>
                		</c:otherwise>                	
                	</c:choose>
                    
                </div>
                
            </div>
        </nav>
</body>
</html>