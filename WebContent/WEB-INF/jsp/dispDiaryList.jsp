<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "beans.DiaryBeans" %>
<%@page import = "java.util.*" %>
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
<% List<DiaryBeans> diaryList = (List<DiaryBeans>)session.getAttribute("diaryList"); %>
<header>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">日誌一覧</h2>
		<div class="col-md-8 offset-md-2">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">日誌日付</th>
						<th scope="col">作成者</th>
						<th scope="col">一言</th>
						<th scope="col">詳細確認</th>
					</tr>
				</thead>
				<tbody>
					<%for(DiaryBeans diary: diaryList){ %>
					<tr>
						<td><%= diary.getCreateDate() %></td>
						<td><%= diary.getUser %>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>"

</body>
</html>