<%@page import="kh.test.jdbckh.professor.model.vo.ProfVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ProfVo vo = (ProfVo) request.getAttribute("profno"); %>
	<table border="1">
		<tr>
			<td>학과번호</td>
			<td><%=vo.getDepartmentNo()%></td>
		</tr>
		<tr>
			<td>교수번호</td>
			<td><%=vo.getProfessorNo()%></td>
		</tr>
		<tr>
			<td>교수이름</td>
			<td><%=vo.getProfessorName()%></td>
		</tr>
		<tr>
			<td>교수 주민번호 </td>
			<td><%=vo.getProfessorSsn()%></td>
		</tr>
		<tr>
			<td>교수 주소 </td>
			<td><%=vo.getProfessorAddress()%></td>

		</tr>
		<tr></tr>

	</table>
</body>
</html>