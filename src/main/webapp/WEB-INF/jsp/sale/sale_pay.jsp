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
				제품 계산
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
				<th>Total</th>
				<th></th>
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
					<th></th>
					<c:set var= "total" value="${total + cart.amount * cart.price}"/>
				</tr>
			</c:forEach>
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th>합 계</th> 
				<th><c:out value="${total}"/></th>
				<th></th>
			</tr>
			</form>
		</table>
		<table class = "table table-hover">
		<form class="form-signin" method ="post">

			<tr>
				<th>카드 결제</th>
				<th>총액</th>
				<th><c:out value="${total}"/></th>
				<th></th>
				<th></th>
				<th><button class="btn btn-success" name="payment" value="card" type="submit">카드결제</button></th>
			</tr>
			
			<tr>
				<th>현금 결제</th>
				<th>총액</th>
				<th><c:out value="${total}"/></th>
				<th>현금</th>
				<th><input type ='text' name = 'money' value = '0'/></th>
				<th><button class="btn btn-success" name="payment" value="cash" type="submit">현금결제</button></th>
			</tr>
			<%
				String error = request.getParameter("error");
				if (error != null)
				{
					out.println("<div class='alert alert-danger'>");
					out.println("현금이 부족합니다.");
					out.println("</div>");
				}
			%>
			</form>
		</table>
	</body>
</html>