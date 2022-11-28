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
				제품 환불
				</h1>
			</div>
		</div>
		<div style ="padding-top: 50px">
		<form class="form-signin" method ="post">
		<table class = "table table-hover">
			<tr>
				<th></th>
				<th>판매시간</th>
				<th>제품ID</th>
				<th>제품</th>
				<th>수량</th>
				<th>개당가격</th> 
				<th>총액</th>
				<th></th>
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
					
					<c:choose>
						<c:when test="${recode.recode_type == 'normal'}">
							<th><button class="btn btn-danger" name="refund_id" value="${recode.recode_ID}" type="submit">환불</th>
						</c:when>
						<c:otherwise>
							<th></th>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
		</form>
		
		<form class="form-signin" method ="post">
			<c:forEach var="refund_recode" items="${refund_recodes}" varStatus="status">
			<table class = "table table-hover">
					<tr>
						<th></th>
						<th>판매시간</th>
						<th>제품ID</th>
						<th>제품</th>
						<th>수량</th>
						<th>개당가격</th> 
						<th>총액</th>
						<th></th>
					</tr>
					<tr>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${refund_recode.recode_type == 'normal'}">
								<th><span class="badge badge-primary">정상</span></th>
							</c:when>
							<c:when test="${refund_recode.recode_type == 'refund'}">
								<th><span class="badge badge-danger">환불</span></th>
							</c:when>
							<c:otherwise>
								<th></th>
								</c:otherwise>
						</c:choose>
						<th>${refund_recode.sellingTime}</th>
						<th>${refund_recode.product_ID}</th>
						<th>[${refund_recode.manufacturer}] ${refund_recode.product_name}</th>
						<th>${refund_recode.amount}</th>
						<th>${refund_recode.price}</th> 
						<th>${refund_recode.amount * refund_recode.price}</th>
						<th><button class="btn btn-danger" name="is_refund" value="true" type="submit">환불</button>
						<button class="btn btn-secondary" name="is_refund" value="false" type="submit">취소</button></th>
					</tr>
			</table>
			</c:forEach>
		</form>
	</div>
	</body>
</html>