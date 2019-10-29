<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "beans.DiaryListBeans" %>
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
<script>
<%@include file="../../js/core/jquery.min.js"%>
<%@include file="../../js/core/bootstrap.min.js"%>
<%@include file="../../js/core/popper.min.js"%>
</script>
<body>
<%
List<DiaryListBeans> diaryList = (List<DiaryListBeans>)session.getAttribute("diaryList");
int i = 0;
%>
<header>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">日誌一覧</h2>
		<div class="col-md-8 offset-md-2">
			<div id="accordion">
			<% for(DiaryListBeans diary: diaryList ){%>
				<div class="card">
					<div class="card-header" id="heading<%=i%>">
						<h5>
							<button class="btn btn-link" data-toggle="collapse" data-target="#collapse<%=i %>" aria-expanded="false" aria-controls="collapse<%=i %>">
								作成日：<%= diary.getCreateDate() %>  作成者：<%= diary.getUserName() %>
							</button>
						</h5>
					</div>

					<div id="collapse<%=i %>" class="collapse" aria-labelledby="heading<%=i %>" data-parent="#accordion">
						<div class="card-body py-0">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">良かった点</th><th scope="col">悪かった点</th><th scope="col">学生コメント</th><th scope="col">担任コメント</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><%= diary.getGoodPoint() %></td><td><%= diary.getBadPoint() %></td><td><%= diary.getStdCom() %></td><td><%= diary.getTcrCom() %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<% i++;} %>
			</div>

		</div>
	</div>
</div>"

</body>
</html>