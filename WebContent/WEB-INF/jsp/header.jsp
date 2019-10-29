<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import = "java.util.*" %>
   <%@page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日誌管理システム</title>
</head>

<body>
<% String headname =((LoginInfoBeans)session.getAttribute("loginInfo")).getUserName();
	if(headname == null){
		headname = "ゲスト";
	}
%>
<div class="container">
	<div class="row mt-3">
		<div class="col-md-10 offset-md-1"><p class="text-left float-left"><%= headname%></p><a href="LogoutServlet" class="text text-primary float-right">ログアウト</a></div>
	</div>
</div>
<div class="container-fluid border-bottom border-primary"></div>
</body>
</html>