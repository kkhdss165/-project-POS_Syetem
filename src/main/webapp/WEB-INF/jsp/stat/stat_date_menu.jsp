<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<nav class = "navbar navbar-expand	navbar-dark bg-info">
	<div class = "contanier">
		<ul class="navbar-nav mr-auto" >
		
			<li class="nav-item"><a class="nav-link" 
			href ="<c:url value='/stat/date_year' />">연간</a></li>
			
			<li class="nav-item"><a class="nav-link" 
			href ="<c:url value='/stat/date_month' />">월간</a></li>
			
			<li class="nav-item"><a class="nav-link" 
			href ="<c:url value='/stat/date_week' />">주간</a></li>
			
			<li class="nav-item"><a class="nav-link" 
			href ="<c:url value='/stat/date_day' />">일간</a></li>
		</ul>
	</div>
</nav>