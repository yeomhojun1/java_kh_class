<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<meta charset="UTF-8">
<title>새글등록</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty bno }">

			<h2>${bno }의답글 등록</h2>
		</c:when>
		<c:otherwise>
			<h2>새글 등록</h2>
		</c:otherwise>
	</c:choose>
	<div>
	<!-- type="file"이 있다면 form method="post" enctype="multipart/form-data" 반드시 작성!!!--> 
		<form action="<%=request.getContextPath()%>/board/insert" method="post"
		enctype="multipart/form-data"
		>
		<c:if test="${not empty bno }">
			<input type="hidden" name="bno" value ="${bno }">
		</c:if>
			제목: <input type="text" name="btitle"> <br> 
			내용: <textarea type="textarea" name="bcontent" rows="10" cols="50"></textarea><br>
			<button type="button" id="btn-add-file">파일 추가</button>
			<div id="add-file">
		
			</div>
			<button type="submit">글 등록</button>

		</form>
	</div>
	<script>
		$("#btn-add-file").click(function()){
			htmlVal= '<div>파일첨부(name에 file명 작성하지 말자) : <input type="file" name="a1"><button type="button" class="btn-delete-file">파일삭제</button></div>';
			$("#add-file").append(htmlVal);
			$(".btn-delete-file").off('click');
			$(".btn-delete-file").on('click',function(){
				$(this).parent().remove();
				});
			
		}
	</script>
</body>
</html>