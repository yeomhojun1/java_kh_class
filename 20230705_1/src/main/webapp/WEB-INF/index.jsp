<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/join"><h1>회원가입-절대위치-context path 누락됨. 사용불가</h1></a>
<a href="./join"><h1>회원가입 -상대위치 - 고민..불편함</h1></a>
<a href="<%=request.getContextPath()%>/join"><h1>회원가입-권장방법</h1></a>
<a href="<%=request.getContextPath()%>/login"><h1>로그인-권장방법</h1></a>
<h1><%=request.getContextPath()%></h1>
<%
for(int i=0;i<10;i++){
	%>
<h1>hello dynamic web project</h1>
	<%
	
}
	%>

</body>
</html>