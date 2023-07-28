<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty bno }">

			<h2>${bno }의답글 등록</h2>
		</c:when>
		<c:otherwise>
			<h2>새글 등록</h2>
		</c:otherwise>
	</c:choose>
	<div>
		<form action="<%=request.getContextPath()%>/board/insert" method="post">
		<c:if test="${not empty bno }">
			<input type="hidden" name="bno" value ="${bno }">
		</c:if>
			제목: <input type="text" name="btitle"> <br> 내용:
			<textarea type="textarea" name="bcontent" rows="10" cols="50"></textarea>
			<button type="submit">글 등록</button>

		</form>
	</div>
</body>
</html>