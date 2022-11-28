<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%
	String sessionId = (String) session.getAttribute("sessionId");
	String sessionrole = (String) session.getAttribute("sessionrole");
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
						<li style ="padding-top: 7px; color:white">[ <%=sessionrole %> ] <%=sessionId %> 님</li>
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/logout' />">로그아웃</a></li>
						
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/sale/home' />">판매</a></li>
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/product/home' />">재고</a></li>
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/stat/home' />">통계</a></li>
						<li class="nav-item"><a class="nav-link" 
						href ="<c:url value='/member/home' />">계정</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</div>
</nav>