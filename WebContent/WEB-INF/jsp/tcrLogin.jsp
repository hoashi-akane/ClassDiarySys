<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ログイン</title>
</head>
<style>
<%@include file="../../css/nowuicss/bootstrap.min.css"%>
<%@include file="../../css/nowuicss/now-ui-kit.css"%>
</style>
<body>
<%
String password = (String)session.getAttribute("password");
String msg = (String)request.getAttribute("msg");
if(password == null){
	password = "";
}
if(msg == null){
	msg ="";
}
%>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">Login</h2>
		<form action="TcrAuthServlet" method="POST" class="col-md-8 offset-md-2 mx-auto text text-secondary">
			<p class="text-primary"><%=msg %></p>
			<div class="form-group">
					<label for="UserID">教員ID</label>
					<input type="text" class="form-control" id="UserID" placeholder="例:サンプル太郎" name="userId">
				</div>
			<div class="form-group">
    				<label for="Password">Password <input class="ml-3 mr-1" type="checkbox" name="pwdkeep" value="1">Keep Password</label>
				    <input type="password" class="form-control" id="Password" placeholder="Password" name="password" value="<%=password%>">
			</div>
			<input type="submit" value="Enter" class="mt-3 mt-3 col-md-10 offset-md-1 btn-lg btn-neutral border border-danger text-center">
		</form>
	</div>
</div>

	<footer>
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
	</footer>
</body>
</html>