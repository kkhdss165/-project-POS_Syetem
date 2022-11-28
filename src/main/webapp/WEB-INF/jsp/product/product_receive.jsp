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
		<%@ include file = "product_menu.jsp" %>
		<div class ="jumbotron">
			<div class = "contanier">
				<h1 class = "display-4">
				제품 입고
				</h1>
			</div>
		</div>
		<table class = "table table-hover">
			<form class="form-signin" method ="post">
				<tr>
					<th></th>
					<th>제품 ID</th>
					<th>제조사</th>
					<th>제품명</th>
					<th>가격</th>
					<th>수량</th> 
					<th>최근 재입고 날짜</th>
					<th><button class="btn btn-primary" name="restock_ID" value="new_product" type="submit">새제품입고</button></th>
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
						<th>${product.manufacturer}</th>
						<th>${product.product_name}</th>
						<th>${product.price}</th>
						<th>${product.productInStock}</th> 
						<th>${product.restockDate}</th>
						<th><button class="btn btn-primary" name="restock_ID" value="${product.product_ID}" type="submit">재입고</button></th>
					</tr>
				</c:forEach>
			</form>
			<form class="form-signin" method ="post">
				<c:forEach var="new_product" items="${new_products}" varStatus="status">
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
							<tr>
							</tr>
							<tr>
								<th></th>
								<th><input type ='text' name = 'newproduct_ID' value = ''/></th>
								<th><input type ='text' name = 'newManufacturer' value = ''/></th>
								<th><input type ='text' name = 'newProduct_name' value = ''/></th>
								<th><input type ='text' name = 'newPrice' value = ''/></th>
								<th><input type ='text' name = 'newProductInStock' value = ''/></th> 
								<th><button class="btn btn-success" name="new_receive" value="true" type="submit">입고하기</button></th>
							</tr>
		
					</table>
				</c:forEach>
			</form>
			<form class="form-signin" method ="post">
				<c:forEach var="old_product" items="${old_products}" varStatus="status">
					<table class = "table table-hover">
							<tr>
								<th></th>
								<th>제품 ID</th>
								<th>제조사</th>
								<th>제품명</th>
								<th>가격</th>
								<th>수량</th> 
								<th>최근 재입고 날짜</th>
								<th></th>
							</tr>
							<tr>
							</tr>
							<tr>
								<th></th>
								<th>${old_product.product_ID}</th>
								<th>${old_product.manufacturer}</th>
								<th>${old_product.product_name}</th>
								<th>${old_product.price}</th>
								<th><input type ='text' name = 'newProductInStock' value = ''/></th> 
								<th>${old_product.restockDate}</th>
								<th><button class="btn btn-success" name="old_receive" value="true" type="submit">입고하기</button></th>
							</tr>
		
					</table>
				</c:forEach>
			</form>
		</table>
	</body>
</html>