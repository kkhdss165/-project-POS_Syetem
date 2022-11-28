<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%
	String sessionId = (String) session.getAttribute("sessionId");
%>
<nav class = "navbar navbar-expand	navbar-dark bg-dark">
	<div class = "contanier">
		<div class = "navbar-header">
			<a class = "navbar-brand" href="/home">POS</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto" >
				<c:choose>
					<c:when test="${empty sessionId}">
						<li class="nav-item"><a class="nav-link" 
						href = "<c:url value='/login' />">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li style ="padding-top: 7px; color:white">[<%=sessionId %>님]</li>
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/member/logoutMember.jsp' />">로그아웃</a></li>
						
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/stat/home' />">판매 기록</a></li>
						
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/stat/date_year' />">기간 순</a></li>
						
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/stat/sum_amount' />">수량 순</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</div>
</nav>