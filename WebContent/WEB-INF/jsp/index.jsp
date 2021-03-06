<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<style>
<%@include file="../../css/nowuicss/bootstrap.min.css"%>
<%@include file="../../css/nowuicss/now-ui-kit.css"%>
</style>
<body>

<header>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">トップ画面</h2>
		<h3 class="col-md-8 offset-md-2 mx-auto text text-secondary">ようこそ<%=loginInfo.getUserName() %>さん</h3>
		<div class="col-md-3 offset-md-2">
			<table class="float-right" style="width:100%;">
				<tr><td><form action="DispDiaryListServlet" method="GET"><button type="submit" class="btn btn-neutral border border-danger" style="width:100%">日誌一覧表示</button></form></td>
				</tr>
				<tr><td><form action="InputDiaryResistServlet" method="GET"><button type="submit" class="btn btn-neutral border border-danger" style="width:100%">日誌作成</button></form></td></tr>
			</table>
		</div>
		<div class="col-md-3 offset-md-1">
			<table class="float-left" style="width:100%">
				<tr><td><form action="DelDiaryServlet" method="GET"><button type="submit" class="btn btn-neutral border border-danger" style="width:100%">日誌削除</button></form></td>
				</tr>
				<tr><td><form action="RevisionDiaryServlet" method="GET"><button type="submit" class="btn btn-neutral border border-danger" style="width:100%">日誌修正</button></form></td></tr>
			</table>
		</div>
	</div>
</div>

	<footer>
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
	</footer>
</body>
</html>