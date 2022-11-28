<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<html>
<head>
<link rel = "stylesheet"	
	href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
<title>POS</title>
</head>
	<body>
		<%@ include file = "member_menu.jsp" %>
		<div class ="jumbotron">
			<div class = "contanier">
				<h1 class = "display-4">
				개인정보수정
				</h1>
			</div>
		</div>
		<form class="form-signin" method ="post">
		<div style ="padding-top: 50px">
			<table class = "table table-hover">
				<tr>
					<th></th>
					<th>비밀번호</th>
					<th><input type ='password' name = 'password' value = ''/></th>
					<th><button class="btn btn-warning" name="is_update" value="true" type="submit">개인정보수정</button></th>
					<th></th> 
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>개인정보 수정을 원하시면 비밀번호를 입력하세요</th>
					<th></th>
					<th></th> 
				</tr>
				<%
					String error = request.getParameter("error");
					if (error != null)
					{
						out.println("<div class='alert alert-danger'>");
						out.println("비밀번호를 확인해주세요");
						out.println("</div>");
					}
				%>
			</table>
		</div>
		</form>
	</body>
</html>