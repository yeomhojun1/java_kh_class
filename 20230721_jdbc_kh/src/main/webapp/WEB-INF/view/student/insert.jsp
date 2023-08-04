<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생등록</h2>
	<div class="container">
		<form action="<%=request.getContextPath()%>/student/insert.do" method="post">

			<table>
				<tr>
					<td>학생번호</td>
					<td><input type="text" name="studentNo"></td>
				</tr>
				<tr>
					<td>departmentNo</td>
					<td><select name="departmentNo">
					<option value=""></select>
				
				
				
				</tr>
				<tr>
					<td>studentName</td>
					<td><input type="text" name="studentName"></td>
				</tr>
				<tr>
					<td>studentSsn</td>
					<td><input type="text" name="studentSsn"></td>
				</tr>
				<tr>
					<td>studentAddress</td>
					<td><input type="text" name="studentAddress"></td>
				</tr>
				<tr>
					<td>entranceDate yyyy-mm-yy</td>
					<td><input type="text" name="entranceDate"></td>
				</tr>
				<tr>
					<td>absenceYn</td>
					<td><input type="text" name="absenceYn"></td>
				</tr>
				<tr>
					<td>coachProfessorNo</td>
					<td><input type="text" name="coachProfessorNo"></td>
				</tr>
				<tr>
					<td>departmentName</td>
					<td><input type="text" name="departmentName"></td>
				</tr>
				
	
			</table>
			<button type="submit">학생등록</button>
		</form>



	</div>
</body>
</html>