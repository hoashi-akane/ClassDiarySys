<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
<%@include file="../../css/bootstrap.min.css"%>
<%@include file="../../css/now-ui-kit.css"%>
</style>
<body>
<header>
		<%@include file="/WEB-INF/jsp/header.jsp" %>
	</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">日誌登録完了</h2>
		<div class="col-md-8 offset-md-2 mx-auto text text-secondary">
			<p>日誌登録が完了しました！</p>
			<a href="MenuServlet" class="mt-3 col-md-12  btn btn-lg btn-neutral border border-danger text-center float-left">メニューへ</a>
		</div>
	</div>
</div>
	<footer>
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
	</footer>
</body>
</html>