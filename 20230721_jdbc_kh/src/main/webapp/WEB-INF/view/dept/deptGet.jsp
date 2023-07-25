<%@page import="kh.test.jdbckh.department.model.vo.DeptVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	DeptVo vo = (DeptVo) request.getAttribute("deptno");
	%>
	<table border="1">
		<tr>
			<td>학과이름</td>
			<td><%=vo.getDepartmentName()%></td>
		</tr>
		<tr>
			<td>학과번호</td>
			<td><%=vo.getDepartmentNo()%></td>
		</tr>
		<tr>
			<td>정원</td>
			<td><%=vo.getCapacity()%></td>
		</tr>
		<tr>
			<td>계열</td>
			<td><%=vo.getCategory()%></td>
		</tr>
		<tr>
			<td>개방여부</td>
			<td><%=vo.getOpenYn()%></td>

		</tr>
		<tr></tr>

	</table>
</body>
</html>