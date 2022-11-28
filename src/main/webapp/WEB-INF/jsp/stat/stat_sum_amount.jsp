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
		<%@ include file = "stat_sum_menu.jsp" %>
		<div class ="jumbotron">
			<div class = "contanier">
				<h1 class = "display-4">
				통계[수량순]
				</h1>
			</div>
		</div>
		<div style ="padding-top: 50px">
		<table class = "table table-hover">
			<tr>
				<th></th>
				<th>판매시간</th>
				<th>제품ID</th>
				<th>가격</th>
				<th bgcolor ='skyblue'>수량</th> 
				<th>총액</th>
			</tr>
		
			<c:forEach var="sum" items="${sums}" varStatus="status">
				<tr>
					<th></th>
					<th>${sum.product_ID}</th>
					<th>[${sum.manufacturer}] ${sum.product_name}</th>
					<th>${sum.price}</th>
					<th bgcolor ='skyblue'>${sum.amount}</th> 
					<th>${sum.total}</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>