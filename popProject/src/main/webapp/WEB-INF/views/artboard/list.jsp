<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<article>
	<div>
		<h1>
			<a href="main">MOHAJIPOP!</a>
		</h1>
		<h3>서울 팝업 전시 모두 모여라</h3>
	</div>
</article>
<article>
	<table>
		<c:forEach var="list" items="${artlist}">
			<tr onclick="window.location.href='/view?popCode=${list.popCode}';"
				style="cursor: pointer;">
				<th><img src="<c:url value='${list.rink}' />" alt="콘텐츠 이미지"></th>
				<td>${list.popName}</td>
				<td>${list.startDay}</td>
				<td>${list.endDay}</td>
			</tr>
		</c:forEach>
	</table>

</article>
</body>
</html>