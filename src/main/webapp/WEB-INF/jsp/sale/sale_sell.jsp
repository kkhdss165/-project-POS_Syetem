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
		<%@ include file = "sale_menu.jsp" %>
		<div class ="jumbotron">
			<div class = "contanier">
				<h1 class = "display-4">
				상품 판매
				</h1>
			</div>
		</div>
		<div style ="padding-top: 50px">
		<table class = "table table-hover">
			<tr>
				<th></th>
				<th>제품 ID</th>
				<th>제조사</th>
				<th>제품명</th>
				<th>가격</th>
				<th>수량</th> 
				<th></th>
			</tr>
		
			<c:forEach var="product" items="${products}" varStatus="status">
				<tr>
					<c:choose>
						<c:when test="${product.productInStock <= 5 and product.productInStock > 0}">
							<th><span class="badge badge-warning">품절 임박</span></th>
						</c:when>
						<c:when test="${product.productInStock <= 0}">
							<th><span class="badge badge-danger">품절</span></th>
						</c:when>
						<c:otherwise>
							<th></th>
						</c:otherwise>
					</c:choose>
					<th> ${product.product_ID}</th>
					<th>[${product.manufacturer}]</th>
					<th>${product.product_name}</th>
					<th>${product.price}</th>
					<th>${product.productInStock}</th>
					<form class="form-signin" method ="post">
					<c:choose>
						<c:when test="${product.productInStock <= 0}">
							<th><a class="btn btn-danger">품절</a></th>
						</c:when>
						<c:otherwise>
							<th><button class="btn btn-primary" name="product_ID" value="${product.product_ID}" type="submit">제품 추가</button></th>
					</c:otherwise>
					</c:choose>
					</form>
				</tr>
				
			</c:forEach>
		</table>
		<c:import url = "/cart">
		</c:import>
	</div>
	</body>
</html>