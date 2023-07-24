<%@page import="kh.test.jdbckh.department.model.vo.DeptVo"%>
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
	<%
	List<DeptVo> volist = (List<DeptVo>) request.getAttribute("deptlist");
	%>
	<table border="1">
		<tr>
			<td>학과번호</td>
			<td>학과이름</td>
			<td>계열</td>
			<td>개설여부</td>
			<td>정원</td>
		</tr>
		<% 
			for(int i = 0; i<volist.size();i++){
				DeptVo vo = volist.get(i);
			
			%>
		<tr>
		<td><a href="<%=request.getContextPath()%>/dept/get?deptno=<%=vo.getDepartmentNo() %>"> <%=vo.getDepartmentNo() %></a></td>
		<td> <%=vo.getDepartmentName() %></td>
		<td> <%=vo.getCategory() %></td>
		<td> <%=vo.getOpenYn() %></td>
		<td> <%=vo.getCapacity() %></td>
		
		</tr>
<% } %>
	</table>
</body>
</html>