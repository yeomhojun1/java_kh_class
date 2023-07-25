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
	<h2>학과 리스트</h2>
	<DIV>
		<form action="<%=request.getContextPath()%>/dept/list" method="get">
			<input type="search" name="searchword"> 
			<input type="submit"
				name="찾기">
		</form>
	</DIV>
	<%
	String searchword = (String) request.getAttribute("searchword");
	List<DeptVo> volist = (List<DeptVo>) request.getAttribute("deptlist");
	if (searchword != null) {
	%>
	<h3>
		<%=searchword%>
		검색결과
	</h3>
	<h3>
		<a href="<%=request.getContextPath()%>/dept/list">전체보기</a>
	</h3>
	<%
	}
	if (volist == null || volist.size() == 0) {
	%>
	<h2>
		결과물이 없습니다
		</h3>

		<%
		} else {
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
			for (int i = 0; i < volist.size(); i++) {
				DeptVo vo = volist.get(i);
			%>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/dept/get?deptno=<%=vo.getDepartmentNo()%>">
						<%=vo.getDepartmentNo()%></a></td>
				<td><%=vo.getDepartmentName()%></td>
				<td><%=vo.getCategory()%></td>
				<td><%=vo.getOpenYn()%></td>
				<td><%=vo.getCapacity()%></td>

			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	
	
</body>
</html>