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
		<%@ include file = "stat_menu.jsp" %>
		<div class ="jumbotron">
			<div class = "contanier">
				<h1 class = "display-4">
				판매 기록
				</h1>
			</div>
		</div>
		<div style ="padding-top: 50px">
		<table class = "table table-hover">
			<tr>
				<th></th>
				<th>판매시간</th>
				<th>제품ID</th>
				<th>제품</th>
				<th>수량</th>
				<th>개당가격</th> 
				<th>총액</th>
			</tr>
		
			<c:forEach var="recode" items="${recodes}" varStatus="status">
				<tr>
					<c:choose>
						<c:when test="${recode.recode_type == 'normal'}">
							<th><span class="badge badge-primary">정상</span></th>
						</c:when>
						<c:when test="${recode.recode_type == 'refund'}">
							<th><span class="badge badge-danger">환불</span></th>
						</c:when>
						<c:otherwise>
							<th></th>
						</c:otherwise>
					</c:choose>
					<th>${recode.sellingTime}</th>
					<th>${recode.product_ID}</th>
					<th>[${recode.manufacturer}] ${recode.product_name}</th>
					<th>${recode.amount}</th>
					<th>${recode.price}</th> 
					<th>${recode.amount * recode.price}</th>
				</tr>
			</c:forEach>

		</table>
	</div>
	</body>
</html>