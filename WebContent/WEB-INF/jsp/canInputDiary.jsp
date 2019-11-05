<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
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
	List<String> canInputDiary = (List<String>)request.getAttribute("canInputDiary");
	int i=0;
	String message = (String)request.getAttribute("message");
%>
<header>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">作成可能日誌一覧</h2>
		<div class="col-md-8 offset-md-2">

			<div id="accordion">
			<form action = "MultiInputDiaryResistServlet" method="POST">
			<% for(String diary : canInputDiary ){ %>
				<div class="card">
					<div class="card-header font-weight-bold" id="heading<%=i%>">
						<h5 class="text-danger">
						<button type="button" class="btn btn-link" data-toggle="collapse" data-target="#collapse<%=i %>" aria-expanded="false" aria-controls="collapse<%=i %>">
							本来の記入日：<%= diary %>　　　作成
							<input type="checkbox" name="chk" value=<%= i %>>
							<input type="hidden" name="hid<%=i%>" value=<%= diary %>>
						</button>
						</h5>
					</div>

					<div id="collapse<%=i %>" class="collapse" aria-labelledby="heading<%=i %>" data-parent="#accordion">
						<div class="card-body py-0">
							<div class="form-group">
								<label for="good<%=i%>">良かった点</label>
								<textarea id="good<%=i %>" class="form-control" name="good_com<%=i%>" maxlength="30" rows="2"></textarea>
							</div>
							<div class="form-group">
								<label for="bad<%=i%>">悪かった点</label>
								<textarea  id="bad<%=i%>" class="form-control" name="bad_com<%=i%>" maxlength="30" rows="2"></textarea>
							</div>
							<div class="form-group">
								<label for="stdCom<%=i%>">一言</label>
								<textarea  id="stdCom<%=i%>" class="form-control" name="std_com<%=i%>" maxlength="30" rows="2"></textarea>
							</div>
						</div>
					</div>
				</div>
			<% i++;} %>
			<div class="col-md-12 p-0">
			<a href="MenuServlet" class="m-0 col-md-6 btn btn-lg btn-neutral border border-danger text-center">戻る</a>
			<button class="float-right mx-0 col-md-6 btn-neutral btn-lg border border-danger" type="submit">作成</button>
			</div>
			</form>
			</div>
			</div>
	</div>
</div>"


</body>
</html>