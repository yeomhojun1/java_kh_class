<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/index" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="mid"></th>
			</tr>
			<tr>
				<th>패스워드</th>
				<th><input type="password" name="mpwd"></th>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
		</table>
</body>
</html>