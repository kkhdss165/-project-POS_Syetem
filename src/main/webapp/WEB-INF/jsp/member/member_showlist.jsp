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
				계정 목록
				</h1>
			</div>
		</div>
		<div style ="padding-top: 50px">
			<table class = "table table-hover">
				<tr>
					<th>직위</th>
					<th>이름</th>
					<th>ID</th>
					<th>연락처</th>
					<th>주소</th>
					<th>입사일</th> 
				</tr>
			
				<c:forEach var="member" items="${members}" varStatus="status">
					<tr>
						<c:choose>
							<c:when test="${member.role == 'admin'}">
								<th><span class="badge badge-danger">관리자</span></th>
							</c:when>
							<c:when test="${member.role == 'manager'}">
								<th><span class="badge badge-primary">관리자</span></th>
							</c:when>
							<c:when test="${member.role == 'parttimer'}">
								<th><span class="badge badge-secondary">직원</span></th>
							</c:when>
							<c:otherwise>
								<th></th>
							</c:otherwise>
						</c:choose>
						<th>${member.name}</th>
						<th>${member.ID}</th>
						<th>${member.phone}</th>
						<th>${member.address}</th>
						<th>${member.createDate}</th> 
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>