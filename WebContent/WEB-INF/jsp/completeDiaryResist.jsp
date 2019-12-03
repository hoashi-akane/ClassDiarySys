<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作業完了画面</title>
</head>
<style>
<%@include file="../../css/nowuicss/bootstrap.min.css"%>
<%@include file="../../css/nowuicss/now-ui-kit.css"%>
</style>
<body>
<%
	String[] message = (String[])request.getAttribute("message");
%>
<header>
		<%@include file="/WEB-INF/jsp/header.jsp" %>
	</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">日誌<%=message[0] %>完了</h2>
		<div class="col-md-8 offset-md-2 mx-auto text text-secondary">
			<p><%= message[1] %></p>
			<a href="MenuServlet" class="mt-3 col-md-12  btn btn-lg btn-neutral border border-danger text-center float-left">メニューへ</a>
		</div>
	</div>
</div>
	<footer>
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
	</footer>
</body>
</html>