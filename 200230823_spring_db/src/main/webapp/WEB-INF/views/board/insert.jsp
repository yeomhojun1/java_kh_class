<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/board/insert" method="post">
		제목 : <input type="text" name="btitle"><br>
		내용 : <input type="text" name="bcontent"><br>
	<input type="submit" value="등록">
	</form>
</body>
</html>