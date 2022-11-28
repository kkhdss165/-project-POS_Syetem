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
				제품 수정
				</h1>
			</div>
		</div>
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
			<form class="form-signin" method ="post">
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
				<th>${product.product_ID}</th>
				<th>${product.manufacturer}</th>
				<th>${product.product_name}</th>
				<th>${product.price}</th>
				<th>${product.productInStock}</th> 
				<th>${product.restockDate}</th>
				<th><button class="btn btn-warning" name="edit_ID" value="${product.product_ID}" type="submit">제품수정</button></th>
			</tr>
			</c:forEach>
			</form>
		</table>
		<form class="form-signin" method ="post">
		<c:forEach var="edit_product" items="${edit_products}" varStatus="status">
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
					<th>${edit_product.product_ID}</th>
					<th>${edit_product.manufacturer}</th>
					<th>${edit_product.product_name}</th>
					<th>${edit_product.price}</th>
					<th>${edit_product.productInStock}</th> 
					<th>${edit_product.restockDate}</th>
					<th><button class="btn btn-secondary" name="is_update" value="false" type="submit">수정취소</button></th>
				</tr>
				<tr>
					<th></th>
					<th><input type ='text' name = 'newproduct_ID' value = '${edit_product.product_ID}'/></th>
					<th><input type ='text' name = 'newManufacturer' value = '${edit_product.manufacturer}'/></th>
					<th><input type ='text' name = 'newProduct_name' value = '${edit_product.product_name}'/></th>
					<th><input type ='text' name = 'newPrice' value = '${edit_product.price}'/></th>
					<th><input type ='text' name = 'newProductInStock' value = '${edit_product.productInStock}'/></th> 
					<th><input type ='text' name = 'newRestockDate' value = '${edit_product.restockDate}'/></th>
					<th><button class="btn btn-warning" name="is_update" value="true" type="submit">수정하기</button></th>
				</tr>

		</table>
		</c:forEach>
		</form>
	</body>
</html>