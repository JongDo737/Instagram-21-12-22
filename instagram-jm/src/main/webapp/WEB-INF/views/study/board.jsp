<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="board" items="${b }">
			<tr>
				<td style="border:1px solid #000">${board.board_id }</td>
				<td style="border:1px solid #000">${board.board_img }</td>
				<td style="border:1px solid #000">${board.board_content }</td>
				<td style="border:1px solid #000">${board.user_id }</td>
				<td style="border:1px solid #000">${board.username }</td>
				<td style="border:1px solid #000">${board.profile_img }</td>
				<td style="border:1px solid #000">${board.update_date }</td>
			</tr>
		
		</c:forEach>
	</table>
	<a href="/study/board?page=0">0</a>
	<a href="/study/board?page=1">1</a>
	<a href="/study/board?page=2">2</a>
	<a href="/study/board?page=3">3</a>
	<a href="/study/board?page=4">4</a>
	<a href="/study/board?page=5">5</a>
</body>
</html>