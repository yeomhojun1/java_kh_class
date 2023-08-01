<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학과 리스트</h2>
<div>
	<form action="<%=request.getContextPath() %>/dept/get" method="get">
	학과번호<input type="text" name="departmentNo">
	<input type="submit" value="찾기">
	
	</form>
</div>
[[${deptList }]]
</body>
</html>