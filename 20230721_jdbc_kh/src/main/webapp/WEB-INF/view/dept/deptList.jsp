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
			}//for
			%>
		</table>
		<%
		}
		%>
		<div>
		<% 
		int startPageNum = (Integer) request.getAttribute("startPageNum");
		int endPageNum = (Integer) request.getAttribute("endPageNum");
		int currentPage = (Integer) request.getAttribute("currentPage");
		int totalPageNum = (Integer) request.getAttribute("totalPageNum");
		if(startPageNum != 1 && searchword != null){
		%>	
		<a href="<%=request.getContextPath()%>/dept/list/pageNo=<%=startPageNum-1%>&searchWord=<%=searchword%>"><span>이전</span></a>
		,
		<%
		} else if (startPageNum !=1 && searchword==null){
		%>
		<a
			href="<%=request.getContextPath()%>/dept/list?pageNo=<%=startPageNum - 1%>"><span>이전</span></a>
		,
		<%
		}
		for (int i = startPageNum; i<=endPageNum;i++) {
			if(searchword != null){
		
		%>
		<a
			href="<%=request.getContextPath()%>/dept/list?pageNo=<%=i%>&searchWord=<%=searchword%>"><span><%=i%></span></a>
		,
		<%
			}else{
				%>
		<a href="<%=request.getContextPath()%>/dept/list?pageNo=<%=i%>"><span><%=i%></span></a>
		,
		<%
			}
		}
		if(endPageNum < totalPageNum && searchword != null){
			%>
				<a
			href="<%=request.getContextPath()%>/student/list?pageNo=<%=endPageNum + 1%>&searchWord=<%=searchword%>"><span>다음</span></a>
		,
		<%
		} else if (endPageNum < totalPageNum && searchword == null) {
			%>	
		<a
			href="<%=request.getContextPath()%>/student/list?pageNo=<%=endPageNum + 1%>"><span>다음</span></a>
		,
		<%
		}
		%>
		
		
		</div>
	
	
</body>
</html>