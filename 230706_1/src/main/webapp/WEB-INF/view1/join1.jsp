<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.0.js"></script>
<style>
.hint {
		display: table-row;
	font-size: .7em;
	color: blue;
	
	visibility: hidden
}</style>
<script>
	window.onload = loadedHandler;
	function loadedHandler() {
		$("[type=password]").click(inputClickHandler);
		$("[type=text]").click(inputClickHandler);
		$("[type=email]").click(inputClickHandler);
	}
	function inputClickHandler(e) {
		$(".hint").css("visibility", "hidden");
		var $hintElement = $(this).parents("tr").next(".hint");
		$hintElement.css("visibility", "visible");

	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<%--  <form action="<%=request.getContextPath()%>/join" method="post">--%>
		<form id="frmjoin">
			<table>
				<tr>
					<th>아이디</th>
					<th><input type="text" name="mid"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-9, 영문자로 시작, 숫자, 특수기호_!만씀)</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<th><input type="text" name="mpwd"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-9,대문자, 소문자, 숫자, 특수문자(!_#) 최소 1개이상 포함</td>
				</tr>
				<tr>
					<th>이름</th>
					<th><input type="text" name="mname"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(2-10,한글)</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<th><input type="tel" name="mtel"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(7,좀전...)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<th><input type="text" name="memail"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-100,일단 생략)</td>
				</tr>
				<tr>
					<th>주민번호</th>
					<th><input type="text" name="msno"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(14,좀전)</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("frmjoin [type=button]").click(submitHandler);
		function submitHanlder() {
			var id = $("[name=mid]").val();
			var regex_id = /^[a-zA-Z][a-zA-Z0-9_!]{4,8}&/;
			if (!regex_id.test(id)) {
				alert("아이디는 5-16자 영문자로 시작하고 영문자와 숫자를 입력해주세요");
				$("[name=mid]").focus();
				return;
			}
		}
	</script>
</body>
</html>