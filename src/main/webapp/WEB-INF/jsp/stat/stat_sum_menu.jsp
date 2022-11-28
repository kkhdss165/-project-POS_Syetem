<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<nav class = "navbar navbar-expand	navbar-dark bg-info">
	<div class = "contanier">
		<ul class="navbar-nav mr-auto" >
		
			<li class="nav-item"><a class="nav-link" 
			href ="<c:url value='/stat/sum_amount' />">수량순</a></li>
			
			<li class="nav-item"><a class="nav-link" 
			href ="<c:url value='/stat/sum_total' />">총액순</a></li>
		</ul>
	</div>
</nav>