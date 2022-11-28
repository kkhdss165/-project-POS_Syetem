<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<div style ="padding-top: 50px">
	<table class = "table table-hover">
		<tr>
			<th></th>
			<th>제품 ID</th>
			<th>제조사</th>
			<th>제품명</th>
			<th>가격</th>
			<th>수량</th> 
			<th>최근 재입고 날짜</th>
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
			</tr>
		</c:forEach>

		
	</table>
</div>