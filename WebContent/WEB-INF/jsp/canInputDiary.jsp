<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> canInputDiary = (List<String>)request.getAttribute("canInputDiary");
	int i=0;
%>
<header>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">作成可能日誌一覧</h2>
		<div class="col-md-8 offset-md-2">
			<div id="accordion">
			<form action = "MultiInputDiaryResistServlet">
			<% for(String diary : canInputDiary ){%>
				<div class="card">
					<div class="card-header" id="heading<%=i%>">
						<h5>
							本来の記入日：<%= diary %>
						</h5>
						<input type="checkbox" name="checkDiary" value="<%=i %>">
					</div>
				</div>
			<% i++;} %>
			</form>
			</div>
			<a href="MenuServlet" class="col-md-12  btn btn-lg btn-neutral border border-danger text-center float-left">戻る</a>
		</div>
	</div>
</div>"


</body>
</html>