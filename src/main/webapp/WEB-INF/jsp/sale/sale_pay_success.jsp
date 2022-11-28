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
				결제완료
				</h1>
			</div>
		</div>
		<%
			String change = request.getParameter("change");
			if (change.equals("card"))
			{
				out.println("<div class='alert alert-primary'>");
				out.println("카드결제가 완료되었습니다.");
				out.println("</div>");
			}
			else
			{
				out.println("<div class='alert alert-primary'>");
				out.println("현금결제가 완료되었습니다. (거스름돈 : "+change+")");
				out.println("</div>");
			}
		%>
	</body>
</html>