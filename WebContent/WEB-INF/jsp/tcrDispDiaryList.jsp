<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "beans.DiaryListBeans" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教員日誌一覧</title>
</head>
<style>
<%@include file="../../css/nowuicss/bootstrap.min.css"%>
<%@include file="../../css/nowuicss/now-ui-kit.css"%>
</style>
<script>
<%@include file="../../js/core/jquery.min.js"%>
<%@include file="../../js/core/bootstrap.min.js"%>
<%@include file="../../js/core/popper.min.js"%>
</script>
<body>
<%
List<DiaryListBeans> diaryList = (List<DiaryListBeans>)request.getAttribute("diaryList");
int i = 0;
%>

<header>
	<%@include file="/WEB-INF/jsp/tcrHeader.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">日誌一覧</h2>
		<div class="col-md-8 offset-md-2">
			<div id="accordion">
			<c:forEach var="diary" items="${diaryList }">

				<div class="card">
					<div class="card-header" id="heading<%=i%>">
						<h5>
							<button class="btn btn-link" data-toggle="collapse" data-target="#collapse<%=i %>" aria-expanded="false" aria-controls="collapse<%=i %>">
								作成日：<c:out value="${diary.insertDate}"/>  　　作成者：<c:out value="${diary.userName }"/>
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
										<td><c:out value="${diary.getGoodPoint()}"/></td><td><c:out value="${diary.getBadPoint()}"/></td><td><c:out value= "${diary.getStdCom()}" /></td><td><c:out value="${diary.getTcrCom()}"/></td>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<% i++; %>
				</c:forEach>
			</div>
			<a href="TcrMenuServlet" class="col-md-12  btn btn-lg btn-neutral border border-danger text-center float-left">戻る</a>
		</div>
	</div>
</div>

</body>
</html>