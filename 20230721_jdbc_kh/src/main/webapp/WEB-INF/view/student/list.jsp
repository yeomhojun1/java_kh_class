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
	<DIV>
		<form action="<%=request.getContextPath()%>/student/list" method="get">
			<input type="search" name="searchword"> 
			<input type="submit" name="찾기">
		</form>
	</DIV>
	<%
	//jsp tag - java문법
	String a = (String) request.getAttribute("aaa");
	String b = (String) request.getAttribute("bbb");
	int c = (Integer) request.getAttribute("ccc");
	List<StudentVo> volist = (List<StudentVo>) request.getAttribute("studentlist");
	String searchword = (String) request.getAttribute("searchword");
	String pageNo = (String) request.getAttribute("pageNo");
	if (searchword != null) {
	%>
	<h3>
		<%=searchword%>
		검색결과
	</h3>
	<h3>
		<a href="<%=request.getContextPath()%>/student/list">전체보기</a>
	</h3>
	<%
	}
	//if(volist.size()==0 || volist ==null){이거는 오류남
	if(volist ==null || volist.size()==0){
	//if(volist == null){
	//if (volist.size() ==0 ) {
	%>
	<h2>결과물이 없습니다</h3>
	
	<%
	} else {
	%>

	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>주민번호</td>
			<td>주소</td>
			<td>입학년도</td>
			<td>학과번호</td>

		</tr>
		<%
		for (int i = 0; i < volist.size(); i++) {
			StudentVo vo = volist.get(i);
		%>
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo()%>">
					<%=vo.getStudentNo()%></a></td>
			<td><a
				href="<%=request.getContextPath()%>/student/get2?sname=<%=vo.getStudentName()%>">
					<%=vo.getStudentName()%></a></td>
			<td><%=vo.getStudentSsn()%></td>
			<td><%=vo.getStudentAddress()%></td>
			<td><%=vo.getEntranceDate()%></td>
			<td><%=vo.getDepartmentNo()%></td>

		</tr>
		<%
		}
		%>
	</table>
	<div>
	<%
		for(int i=1;i<11;i++){
			
		
	%>
	<a name="pageNo" href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
	
	,
	<%
	} //for
	%>
	</div>
	<%
	}//else
	%>
</body>
</html>