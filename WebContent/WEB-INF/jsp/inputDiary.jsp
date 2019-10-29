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
<% String day = (String)request.getAttribute("day"); %>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary" id="inputDiary">公欠登録</h2>

		<form action="ConfirmAbsenceResistServlet" method="POST" class="col-md-8 offset-md-2 mx-auto text text-secondary">
			<div class="form-group">
				<div class="text text-danger"></div>
				<p id="Holiday">登録日  <%= day %></p>
				<label for="Holiday"><a href="">過去の日誌を登録したい方はこちら</a></label>
			</div>
			<div class="form-group">
				<div class="text text-danger"></div>
				<label for="good">良かったこと</label>
				<input type="date" class="form-control" id="good"  name="good_point"  required>
			</div>
			<div class="form-group">
				<label for="bad">気になったこと</label>
				<input type="text" class="form-control" id="bad"  name="bad_point" required>
			</div>

			<div class="form-group">
   				<label for="com">一言</label>
   				<textarea class="form-control" id="com" class="form-control" name="std_com" rows="4" required></textarea>
		  	</div>
				<a href="MenuServlet" class="mt-3 ml-5 col-md-5  btn btn-lg btn-neutral border border-danger text-center float-left">戻る</a>
				<button type="submit" class="mt-3 mr-5 col-md-5 btn btn-lg btn-neutral border border-danger text-center float-right">登録確認</button>
			</form>

	</div>
</div>
	<footer>
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
	</footer>
</body>
</html>