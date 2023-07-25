<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
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
 StudentVo vo = (StudentVo)request.getAttribute("sno");
%>
	<table border="1">
		<tr>
		<td>이름</td>
		<td><%=  vo.getStudentName()%>
		</tr>
	<tr>
	<td> 학과번호</td>
	<td><%= vo.getDepartmentNo() %></td>
	<td> 학과이름</td>
	<td><%= vo.getDepartmentName() %></td>
	</tr>
	<tr></tr>
	
	</table>

</body>
</html>