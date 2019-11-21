<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "beans.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
List<TcrClassInfoBeans> tcrClassList = (ArrayList<TcrClassInfoBeans>)request.getAttribute("tcrClassList");
String actionPath = (String)request.getAttribute("actionPath");
%>
<header>
	<%@include file="/WEB-INF/jsp/tcrHeader.jsp" %>
</header>

<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">クラス名を選択してください</h2>
			<form action="<%= actionPath %>" method="POST" class="col-md-8 offset-md-2 mx-auto text text-secondary">
				<%for(TcrClassInfoBeans tcrClass : tcrClassList){ %>
				<button type="submit" class="card" name="classCode" value="<%= tcrClass.getClassCode()%>">
					<div class="card-body">
						<p>学科・学年・クラス：<%=tcrClass.getCourseName() %> <%=tcrClass.getGrade() %><%=tcrClass.getClassName() %></p>
					</div>
				</button>
				<%}%>
				<a href="TcrMenuServlet" class="col-md-12  btn btn-lg btn-neutral border border-danger text-center float-left">戻る</a>
			</form>
		</h2>
	</div>
</div>
</body>
</html>