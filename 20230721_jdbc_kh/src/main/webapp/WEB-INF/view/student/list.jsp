<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<%
	//jsp tag - java문법
	String a= 	(String)request.getAttribute("aaa");
	String b= 	(String)request.getAttribute("bbb");
	int c = (Integer)request.getAttribute("ccc");
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentlist");
	
	%>

	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>주민번호</td>
			<td>주소</td>
			<td>입학년도</td>
			<td>학과번호</td>
			<td>학과이름</td>
		
		</tr>
		<% 
		for(int i =0; i<volist.size();i++){
			StudentVo vo = volist.get(i);
		
	%>
	<tr>
			<td><%= vo.getStudentNo() %></td>
			<td><%= vo.getStudentName() %></td>
		<td><%= vo.getStudentSsn() %></td>
		<td><%= vo.getStudentAddress() %></td>
		<td><%= vo.getEntranceDate() %></td>
		<td><%= vo.getDepartmentNo() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>