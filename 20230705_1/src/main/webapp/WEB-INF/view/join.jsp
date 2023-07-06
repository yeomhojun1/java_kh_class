<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-3.7.0.js"></script>
<style>
.hint {
	display: table-row;
	font-size: .7em;
	color: blue;
	visibility: hidden
}
</style>
<script>
	window.onload = loadedHandler;
	function loadedHandler() {
		$("[type=text]").click(inputClickHandler);
		$("[type=password]").click(inputClickHandler);
		$("[type=email]").click(inputClickHandler);

	}
	function inputClickHandler(e) {
		console.log("inputClickHandler");
		console.log($(this).parent().parent().next(".hint"));
		console.log($(this).parents("tr").next(".hint"));
		//$(".hint").hide();
		$(".hint").css("visibility", "hidden")
		var $hintElement = $(this).parents("tr").next(".hint");
		$hintElement.css("visibility", "visible");
		//$hintElement.show();
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
					<th><input type="text" name="mid"
						placeholder="(5-9, 영문자로 시작, 숫자, 특수기호_!만씀)"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-9, 영문자로 시작, 숫자, 특수기호_!만씀)</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<th><input type="text" name="mpwd"
						placeholder="(5-9,대문자, 소문자, 숫자, 특수문자(!_#) 최소 1개이상 포함)"></th>
				</tr>
				<tr class="hint">
					<td></td>
					<td>(5-9,대문자, 소문자, 숫자, 특수문자(!_#) 최소 1개이상 포함</td>
				</tr>
				<tr>
					<th>이름</th>
					<th><input placeholder="(2-10,한글)" type="text" name="mname"></th>
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
					<td>)</td>
					<td>(14,좀전)</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("#frmjoin [type=button]").click(submitHandler);
		function submitHandler() {
			var result = checkrEgularExpression1();
			if(result ==)
			
			
			
			
			
			
			
			
			
			
			//유효성 검사
			console.log("여기들어완?")
			var id = $("[name=mid]").val();
			var regex_id = /^[a-zA-Z][a-zA-Z0-9_!]{4,8}$/;
			if (!regex_id.test(id)) {
				console.log("정규식에 합당한 문자열")
				alert("아이디는 5-16자 영문자로 시작하고 영문자와 숫자를 입력해주세요");
				$("[name=mid]").focus();
				return;
			}
			/*
			if (id.length<5||id.length>16) {
				alert("비밀번호는 8-20자 입력해주세요");
				$("[name=mid]").focus();
				return;
			}
			 */
			//string 객체 메소드
			//includes("a")
			if (id.includes("a"))
				var pwd = $("[name=mpwd]").val();
			var regex_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#])[A-Za-z0-9!_#]{5,9}$/;
			if (!regex_pwd.test(pwd)) {
				//정상
				console.log("안돼")
				alert("비밀번호는 8-20자 입력해주세요");
				$("[name=mpwd]").focus();
				return;
			} else {
				console.log("돼")
			}
			var name = $("[name=mname]").val();
			var regex_name = /^[가-힣]{2,10}$/;
			if (!regex_name.test(name)) {
				alert("이름은 2-10자 한글을 입력해주세요");
				$("[name=mname]").focus();
				return;
			}
			var tel = $("[name=mtel]").val();
			var regex_tel = /^01[016789]$/;
			/^[0-9]{3-4}$/;
			/^[0-9]{4}$/;
			if (!regex_tel.test(tel)) {
				alert("전화번호는 숫자를 자리에 맞게 입력해주세요");
				$("[name=mtel]").focus();
				return;
			}
			var sno = $("[name=msno]").val();
			var regex_sno = /^[0-9]{6}$/;
			/^[1234][0-9]{6}$/;
			if (!regex_sno.test(sno)) {
				alert("주민번호는 숫자를 자리에 맞게 입력해주세요");
				$("[name=msno]").focus();
				return;
			}

		}
	</script>
</body>
</html>