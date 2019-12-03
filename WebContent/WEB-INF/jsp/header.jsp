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
<%
	LoginInfoBeans loginInfo =(LoginInfoBeans)session.getAttribute("loginInfo");
%>
<div class="container">
	<div class="row mt-3">
		<div class="col-md-10 offset-md-1"><p class="text-left float-left"><%= loginInfo.getCourseName() %>  <%=loginInfo.getClassName() %>クラス  <%= loginInfo.getUserName() %></p><a href="LogoutServlet" class="text text-primary float-right">ログアウト</a></div>
	</div>
</div>
<div class="container-fluid border-bottom border-danger"></div>
</body>
</html>