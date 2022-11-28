<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<div style ="padding-top: 50px">
	<table class = "table table-hover">
		<form class="form-signin" method ="post">
		<tr>
			<th></th>
			<th>제품 ID</th>
			<th>제조사</th>
			<th>제품명</th>
			<th>가격</th>
			<th>수량</th> 
			<th>Total</th>
			<th><button class="btn btn-dark" name="delete_ID" value="all_delete" type="submit">전체 삭제</button></th>
		</tr>
		<c:set var = "total" value = "0" />
		<c:forEach var="cart" items="${carts}" varStatus="status">
			<tr>
				<th></th>
				<th>${cart.product_ID}</th>
				<th>${cart.manufacturer}</th>
				<th>${cart.product_name}</th>
				<th>${cart.price}</th>
				<th>${cart.amount}</th> 
				<th>${cart.amount * cart.price}</th>
				<th><button class="btn btn-danger" name="delete_ID" value="${cart.product_ID}" type="submit">제품 삭제</button></th>
				<c:set var= "total" value="${total + cart.amount * cart.price}"/>
			</tr>
		</c:forEach>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th> 
			<th><c:out value="${total}"/></th>
			<th><button class="btn btn-success" name="is_pay" value="true" type="submit">계산하기</button></th>
		</tr>
		</form>
		
	</table>
</div>