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
				계정 삭제
				</h1>
			</div>
		</div>
		<div style ="padding-top: 50px">
		<form class="form-signin" method ="post">
			<table class = "table table-hover">
				<tr>
					<th>직위</th>
					<th>이름</th>
					<th>ID</th>
					<th>연락처</th>
					<th>주소</th>
					<th>입사일</th> 
					<th></th>
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
						<c:choose>
							<c:when test="${member.role == 'admin'}">
								<th></th>
							</c:when>
							<c:otherwise>
								<th><button class="btn btn-danger" name="remove_ID" value="${member.ID}" type="submit">계정삭제</button></th>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
				</form>
			</table>
			
			<form class="form-signin" method ="post">
			<c:forEach var="remove_member" items="${remove_members}" varStatus="status">
				<table class = "table table-hover">
						<tr>
							<th>직위</th>
							<th>이름</th>
							<th>ID</th>
							<th>연락처</th>
							<th>주소</th>
							<th>입사일</th> 
							<th></th>
						</tr>
						<tr>
						</tr>

						<tr>
							<c:choose>
								<c:when test="${remove_member.role == 'admin'}">
									<th><span class="badge badge-danger">관리자</span></th>
								</c:when>
								<c:when test="${remove_member.role == 'manager'}">
									<th><span class="badge badge-primary">관리자</span></th>
								</c:when>
								<c:when test="${remove_member.role == 'parttimer'}">
									<th><span class="badge badge-secondary">직원</span></th>
								</c:when>
								<c:otherwise>
									<th></th>
								</c:otherwise>
							</c:choose>
							<th>${remove_member.name}</th>
							<th>${remove_member.ID}</th>
							<th>${remove_member.phone}</th>
							<th>${remove_member.address}</th>
							<th>${remove_member.createDate}</th> 
							<th></th>
						</tr>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th><button class="btn btn-danger" name="is_remove" value="true" type="submit">계정삭제</button>
							<button class="btn btn-secondary" name="is_remove" value="false" type="submit">삭제취소</button></th>
						</tr>
	
				</table>
			</c:forEach>
			</form>
		</div>
	</body>
</html>