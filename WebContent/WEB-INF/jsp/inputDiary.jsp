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
<script>
<%@include file="../../js/core/jquery.min.js"%>
<%@include file="../../js/core/bootstrap.min.js"%>
<%@include file="../../js/core/popper.min.js"%>
</script>
<body>
<% String day = (String)request.getAttribute("day"); %>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary" id="inputDiary">日誌登録</h2>

		<form action="DiaryResistServlet" method="POST" class="col-md-8 offset-md-2 mx-auto text text-secondary">
			<div class="form-group">
				<div class="text text-danger"></div>
				<p id="Holiday">登録日  <%= day %></p>
				<input type="hidden" name="day" value="<%=day %>"></input>
				<label for="Holiday"><a href="CanInputResistListServlet">過去の日誌を登録したい方はこちら</a></label>
			</div>
			<div class="form-group">
				<div class="text text-danger"></div>
				<label for="good">良かったこと</label>
				<textarea class="form-control" id="good" class="form-control" name="good_com" maxlength="30" rows="2"></textarea>
		  	</div>
			<div class="form-group">
				<label for="bad">気になったこと</label>
				<textarea class="form-control" id="bad" class="form-control" name="bad_com" maxlength="30" rows="2"></textarea>
		  	</div>

			<div class="form-group">
				<label for="com">一言</label>
				<textarea class="form-control" id="com" class="form-control" name="std_com" maxlength="30" rows="2"></textarea>
		  	</div>
		  	<div class="col-md-12 p-0">
				<a href="MenuServlet" class="m-0 col-md-6  btn btn-lg btn-neutral border border-danger text-center float-left">戻る</a>
				<button type="button" class="mx-0 col-md-6 btn btn-lg btn-neutral border border-danger text-center float-right" data-toggle="modal" data-target="#myModal">登録</button>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
	    			<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text text-danger" id="exampleModalLabel">公欠登録</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
	    					   <span aria-hidden="true">&times;</span>
							</button>
	   				</div>
	  				<div class="modal-body">
						<p class="text-center">入力された情報で登録してもよろしいですか？</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary px-4" data-dismiss="modal">戻る</button>
						<button type="submit" class="btn btn-primary float-right px-4">登録</button>
					</div><!-- /.modal-footer -->
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
		</form>
	</div>
</div>
	<footer>
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
	</footer>
</body>
</html>