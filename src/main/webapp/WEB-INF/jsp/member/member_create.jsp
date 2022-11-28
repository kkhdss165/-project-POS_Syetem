<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<html>
<head>
<link rel = "stylesheet"	
	href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type = "text/javascript">
function CheckAddProduct()
{
	var ID = document.getElementById("member_ID");
	var name = document.getElementById("member_name");
	var password = document.getElementById("member_PW");
	var password_check = document.getElementById("member_PW_check");

	if(ID.value.length == 0)
	{
		alert("아이디를 입력하세요");
		member_ID.select();
		member_ID.focus();
		return false;
	}
	
	if(name.value.length == 0)
	{
		alert("성함을 입력하세요");
		member_name.select();
		member_name.focus();
		return false;
	}
	
	if(password.value.length == 0)
	{
		alert("비밀번호를 입력하세요");
		member_PW.select();
		member_PW.focus();
		return false;
	}
	if(password.value != password_check.value)
	{
		alert("비밀번호를 다시 확인 해주세요");
		member_PW.select();
		member_PW.focus();
		return false;
	}
	
	document.memberData.submit();
}
</script>	
<title>POS</title>
</head>
	<body>
		<%@ include file = "member_menu.jsp" %>
		<div class ="jumbotron">
			<div class = "contanier">
				<h1 class = "display-4">
				계정 생성
				</h1>
			</div>
		</div>
		<form name ="memberData" class="form-signin" method ="post">
			<div class ="form-group row">
				<label class = "col-sm-2">아이디</label>
				<div class = "col-sm-3">
					<input type="text" id="member_ID" name = "member_ID" value ="">
				</div>
			</div>
			<%
				String error = request.getParameter("error");
				if (error != null)
				{
					out.println("<div class='alert alert-danger'>");
					out.println("아이디가 중복 되었습니다 다른 아이디를 입력해 주세요");
					out.println("</div>");
				}
			%>
			<div class ="form-group row">
				<label class = "col-sm-2">비밀번호</label>
				<div class = "col-sm-3">
					<input type="password" id="member_PW" name = "member_PW" value ="">
				</div>
			</div>
			<div class ="form-group row">
				<label class = "col-sm-2">비밀번호 확인</label>
				<div class = "col-sm-3">
					<input type="password" id="member_PW_check" name = "member_PW_check" value ="">
				</div>
			</div>
			<div class ="form-group row">
				<label class = "col-sm-2">직 책</label>
				<div class = "col-sm-3">
					<input type="radio" name="member_role" value="manager">
					<span class="badge badge-primary">관리자</span>
					<input type="radio" name="member_role" value="parttimer" checked>
					<span class="badge badge-secondary">직원</span>
				</div>
			</div>
			<div class ="form-group row">
				<label class = "col-sm-2">성 함</label>
				<div class = "col-sm-3">
					<input type="text" id="member_name" name = "member_name" value ="">
				</div>
			</div>
			<div class ="form-group row">
				<label class = "col-sm-2">주 소</label>
				<div class = "col-sm-3">
					<input type="text" id="member_address" name = "member_address" value ="">
				</div>
			</div>
			<div class ="form-group row">
				<label class = "col-sm-2">연락처</label>
				<div class = "col-sm-3">
					<input type="text" id="member_phone" name = "member_phone" value ="">
				</div>
			</div>
			<div class ="form-group row">
				<div class = "col-sm-offer-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="계정 생성하기" onclick="CheckAddProduct()">
				</div>
			</div>
		</form>
	</body>
</html>