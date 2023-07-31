<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<div>
		<a href="<%=request.getContextPath()%>/student/insert">학생등록</a>
	</div>
	<div>
		<form action="<%=request.getContextPath()%>/student/list" method="get">
			<input type="search" name="searchWord"> <input type="submit"
				value="찾기">
		</form>
	</div>
	<c:if test="${not empty searchWord }">
		<h3>${searchWord }검색결과</h3>
		<h5>
			<a href="/student/list">전체보기</a>
		</h5>
	</c:if>
	<c:if test="${ not empty studentList}">

		<c:forEach items="${studentList}" var="item">
					${item } <br>
		</c:forEach>


	</c:if>
	// JSP Tag - java문법 [[ ${studentList} ]] [ ${searchWord } ]
	<c:if test="${ not empty searchWord }">
		<h3>${searchWord }검색결과</h3>
		<h5>
			<a href="<%=request.getContextPath()%>/student/list">전체보기</a>
		</h5>
	</c:if>

	<c:if test="${ not empty volist }">
		<h2>결과물이 없습니다.</h2>
	</c:if>
	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>입학일</td>
			<td>주소</td>
		</tr>
		<c:forEach items="${ volist }" var="item">
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/student/get?sno=${item.studentNo }">
						${item.studentNo } </a></td>
				<td><a
					href="<%=request.getContextPath()%>/student/get?sno=${item.studentNo }">
						${item.studentNo } </a></td>
				<td>${item.entranceDate }</td>
				<td>${item.studentAddress }</td>
			</tr>


		</c:forEach>
	</table>
	<div>
		${startPageNum } ${endPageNum } ${currentPage } ${totalPageNum }
		<c:if test="${ not empty startPageNum }">
			<a
				href="<%=request.getContextPath()%>/student/list?pageNo=${startPageNum -1}&searchWord=${searchWord }"><span>이전</span></a>
		,
		</c:if>
		<c:if test="${ startPageNum != 1 && empty searchWord }">
			<a
				href="<%=request.getContextPath()%>/student/list?pageNo=${startPageNum -1}"><span>이전</span></a>
		</c:if>

		<c:forEach begin="${    startPageNum    }" end="${   endPageNum    }" step="2" var="i">
			<c:choose>
				<c:when test="${ not empty searchWord }">
					<a href="<%=request.getContextPath()%>/student/list?pageNo=${i}&searchWord=${searchWord }"><span>${i}</span></a>
				</c:when>
				<c:otherwise>
					<a href="<%=request.getContextPath()%>/student/list?pageNo=${i}"><span>${i}</span></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when
					test="${ endPageNum < totalPageNum && not empty searchWord }">
					<a
						href="<%=request.getContextPath()%>/student/list?pageNo=${endPageNum +1}&searchWord=${searchWord }"><span>다음</span></a>
				</c:when>
				<c:when
					test="${ endPageNum < totalPageNum && not empty searchWord }">
					<a
						href="<%=request.getContextPath()%>/student/list?pageNo=${endPageNum +1}"><span>다음</span></a>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>


</body>
</html>