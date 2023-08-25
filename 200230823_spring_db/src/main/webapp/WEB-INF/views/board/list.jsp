<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
<script >
var msg='${msg}';
if(msg){
alert(msg);
}
</script>
</head>
<body>
	<h2>board list</h2>
	${boardList}
	<script >
var msg='${msg}';
if(msg){
alert(msg);
}
</script>
</body>
</html>