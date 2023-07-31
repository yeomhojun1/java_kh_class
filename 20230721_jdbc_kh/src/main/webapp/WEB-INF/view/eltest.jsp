<%@page import="kh.test.jdbckh.board.model.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <% String ctxtPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL -</title>
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.0.js"></script>

</head>
<body>

<img alt="jpg 테스트" src="resources/images/다현.jpg">
<img alt="jpg 테스트" src="<%=request.getContextPath()%>/resources/images/pngwing.com.png">



<h2> EL - EXPRESSION LANGUAGE <BR>단점 : JAVA FOR/IF/변수 사용 불가 <BR>보안 JSTL의 FOREACH/IF/SET변수를 사용 </h2>









<br>
true/false만 인지할 수있음,그리고 else없음

<c:if test="${not empty vo.studentNo }">
<br><h3>여기 이렇게 보임</h3>
</c:if> 
<c:if test="${1==1}">
<br><h3>여기 이렇게 보임2</h3>
</c:if> 
<h4>else를 쓰고 싶다면 choose- when/otherwise </h4>
<c:choose>
	<c:when test="${1!=1 }">
	<br>여기 이렇게 보임,-when
	</c:when>
<c:otherwise><br>
여기 이렇게 보임,-otherwise</c:otherwise>
</c:choose>
<br>
<c:forEach begin = "3" end="9" step="2" var="i">
	${i }, <br>

</c:forEach>

<c:forEach items="${ volist}" var="vo" varStatus="cnt">
	${cnt.index }, ${cnt.count },${vo.btitle } <br>

</c:forEach>


<HR>
${vo.studentNo }
<br>
${volist.get(2).bwriteDate }
<br>
이렇게도 나옴
<br>
${volist[2] }
<hr>
<h3> ${a1}  : <%=request.getAttribute("a1") %> </h3>
<h3> ${a2}  : <%=request.getAttribute("a2") %> </h3>
${volist} <hr> <%=request.getAttribute("volist") %> 
<% List<BoardVo> list= (List<BoardVo>) request.getAttribute("volist");%> 
${volist2} <hr> <%=request.getAttribute("volist2") %> 
<% List<BoardVo> list2= (List<BoardVo>) request.getAttribute("volist2");%> 
<%--<%= list2.size() --%>
${volist2.size()}<br>









</body>
</html>