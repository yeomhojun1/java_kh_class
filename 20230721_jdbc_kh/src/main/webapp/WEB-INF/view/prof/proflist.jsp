<%@page import="kh.test.jdbckh.professor.model.vo.ProfVo"%>
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
	List<ProfVo> volist = (List<ProfVo>) request.getAttribute("proflist");
	String a = (String)request.getAttribute("searchword");
	%>

<h2>교수 리스트</h2>
	<DIV>
		<form action="<%=request.getContextPath()%>/prof/list" method="get">
			<input type="search" name="searchword"> 
			<input type="submit" name="찾기">
		</form>
	</DIV>
	<% if(a !=null){ 
	%>
	<h3><%=a %> 검색결과</h3>
	<h3><a href="<%=request.getContextPath()%>/prof/list">전체 보기</a></h3>
	<%
	} 

	if(volist==null||volist.size()==0){
	%>
	<h3>결과물이 없습니다</h3>
	<%
	}else{
	%>
	<table border="1">
		<tr>
			<td>학과번호</td>
			<td>교수번호</td>
			<td>교수이름</td>
			<td>교수 주민번호</td>
			<td>교수 주소</td>
		</tr>
		<%
		for (int i = 0; i < volist.size(); i++) {
			ProfVo vo = volist.get(i);
		%>


		<tr>
			<td><%=vo.getDepartmentNo()%></td>
			<td><a href="<%=request.getContextPath()%>/prof/get?profno=<%=vo.getProfessorNo() %>">
			<%=vo.getProfessorNo()%>
			</a></td>
			<td><%=vo.getProfessorName()%></td>
			<td><%=vo.getProfessorSsn()%></td>
			<td><%=vo.getProfessorAddress()%></td>
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