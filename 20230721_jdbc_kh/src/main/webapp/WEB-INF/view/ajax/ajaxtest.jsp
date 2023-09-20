<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax test</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
#modal {
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
	display: none;
}

.modal-content {
	background-color: #fefefe;
	margin: 15% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

.grid-wrap {
	display: grid;
	grid-template-columns: auto auto;
}
</style>
<link
	href="https://fonts.googleapis.com/css2?family=Lobster&display=swap"
	rel="stylesheet">
</head>
<body>
	<h2>ajax test</h2>
	<input type="text">
	<button id="btnajax1">ajax1</button>
	<button id="btnajax2">ajax2</button>
	<div class="grid-wrap">
		<div>학과이름</div>
		<div>계열</div>
	</div>
	<div>
		<h2>로그인</h2>
		<form id="frm-login">
			id: <input type="text" name="mid" required="required"><br>
			pw: <input type="password" name="mpwd" required="required"><br>
			<button type="button" id=btnajax3>로그인</button>
	</div>

	<div>
		<h2>여러회원가입(장바구니 선택)</h2>
		<div class="signup">
			id: <input type="text" name="mid" required="required"><br>
			pw: <input type="password" name="mpwd" required="required"><br>
			이름: <input type="text" name="mname" required="required"><br>
			이메일: <input type="text" name="memail" required="required"><br>
		</div>
		<div class="signup">
			id: <input type="text" name="mid" required="required"><br>
			pw: <input type="password" name="mpwd" required="required"><br>
			이름: <input type="text" name="mname" required="required"><br>
			이메일: <input type="text" name="memail" required="required"><br>
		</div>
		<div class="signup">
			id: <input type="text" name="mid" required="required"><br>
			pw: <input type="password" name="mpwd" required="required"><br>
			이름: <input type="text" name="mname" required="required"><br>
			이메일: <input type="text" name="memail" required="required"><br>
		</div>
		<button type="button" id=btnajax4>회원가입</button>


	</div>
	<div id="modal">
		<div class="modal-content">
			<h2>모달창 제목</h2>
			<p>모달창 내용</p>
			<button id="close-modal">닫기</button>
		</div>
	</div>

	<script>
		$("#btnajax1").click(ajax1ClickHandler);
		$("#btnajax2").click(ajax2ClickHandler);
		$("#btnajax3").click(ajax3ClickHandler);
		$("#btnajax4").click(ajax4ClickHandler);
		const modal = document.getElementById("modal");
		const openModalBtn = document.getElementById("open-modal");
		const closeModalBtn = document.getElementById("close-modal");
		// 모달창 열기

		function ajax4ClickHandler() {
			var dataArr = [];
			$(".signup").each(function(idx) {
				var dataObj = {
					mid : $(this).find("[name=mid]").val(),
					mpwd : $(this).find("[name=mpwd]").val(),
					mname : $(this).find("[name=mname]").val(),
					memail : $(this).find("[name=memail]").val()
				};
				dataArr.push(dataObj);
			});

			console.log(dataArr);
			console.log(JSON.stringify(dataArr));//json으로 변형 string형
			$.ajax({
				url : "${pageContext.request.contextPath}/ajax4",
				type : "post",
				data : JSON.stringify(dataArr),
				success : function(result) {
					console.log("success: ");
					console.log(result);
				},
				error : function() {
					console.log("error: ");
					console.log(result);
				}
			})
		}
		function ajax3ClickHandler() {
			console.log("ajax3ClickHandler");
			//form엘리먼트객체.serialize()
			var dataQuery = $("#frm-login").serialize();
			console.log(dataQuery);
			$.ajax({
				url : "${pageContext.request.contextPath}/ajax3",
				type : "post",
				data : dataQuery
				//,data:{mid: $("[name=mid]").val(), mpwd: $("[name=mpwd]").val()}//mid에서 입력된 값임
				,
				success : function(result) {
					console.log("success: ");
					console.log(result);

				},
				error : function() {
					console.log("error: ");
					console.log(result);
				}
			})

		}
		function ajaxSuccess(result) {
			console.log("ctrl로부터 전달받은 데이터 :");
			console.log(result);
			alert(result);
		}
		function ajax1ClickHandler() {
			console.log("btnajax1 click");
			//$.ajax(ojbect형태로매개인자전달해야함);
			//var obj = {k1:12, k2:'dskfjsdf', k3:function(){}};
			console.log("ajax로 데이터 전달 전-0");
			$.ajax({
				url : "${pageContext.request.contextPath}/ajax1",
				type : "get",
				data : {
					n1 : '값도가나?',
					n2 : 123
				},
				success : ajaxSuccess
			});
			console.log("ajax로 데이터 전달 중-1");
		}
		function ajax2ClickHandler() {
			console.log("btnajax2 click");
			$.ajax({
				url : "${pageContext.request.contextPath}/ajax2",
				type : "post",
				success : ajaxSuccess2,
				dataType : "json"
			});
		}
		function ajaxSuccess2(result) {
			console.log("2 ctrl로부터 전달받은 데이터 :");
			console.log(result);
			<!--
			console.log(result.deptList);
			console.log(result.profList);
			console.log(result.endPage);
			console.log(result.startPage);
			-->
			if (result) {
				for (var i = 0; i < result.deptList.length; i++) {
					var dvo = result.deptList[i];
					console.log(dvo.departmentName);
				}
			}
			displayDepartment(result.deptList);
		}
		function displayDepartment(deptList) {
			htmlVal = "	<div>학과이름</div><div>계열</div>";
			for (var i = 0; i < deptList.length; i++) {
				var dvo = deptList[i];
				htmlVal += "<div>" + dvo.departmentName + "</div>";
				htmlVal += "<div>" + dvo.category + "</div>";
			}
			$('.grid-wrap').html(htmlVal);
		}
	</script>
</body>
</html>