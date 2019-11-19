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
<%@include file="../../css/nowuicss/bootstrap.min.css"%>
<%@include file="../../css/nowuicss/now-ui-kit.css"%>
</style>
<script>
<%@include file="../../js/core/jquery.min.js"%>
<%@include file="../../js/core/bootstrap.min.js"%>
<%@include file="../../js/core/popper.min.js"%>
$(function(){
	  // 初期状態のボタンは無効
	  $("#revbtn").prop("disabled", true);
	    // チェックボックスの状態が変わったら（クリックされたら）
	    $("input[type='checkbox']").on('change', function () {
	        // チェックされているチェックボックスの数
	        if ($(".chk:checked").length > 0) {
	          // ボタン有効
	          $("#revbtn").prop("disabled", false);
	        } else {
	          // ボタン無効
	          $("#revtbtn").prop("disabled", true);
	        }
	    });
});
</script>
<body>
<body>
<%
List<DiaryListBeans> diaryList = (List<DiaryListBeans>)request.getAttribute("diaryList");
int i = 0;
%>
<header>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">修正可能日誌一覧</h2>
		<div class="col-md-8 offset-md-2">
		<div id="accordion">
			<form action="RevisionDiaryServlet" method="POST">
			<% for(DiaryListBeans diary: diaryList ){%>
				<div class="card">
					<div class="card-header" id="heading<%=i%>">
						<h5>
							<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse<%=i %>" aria-expanded="false" aria-controls="collapse<%=i %>">
								作成日：<%= diary.getInsertDate() %>  　　作成者：<%= diary.getUserName() %>
							<input class="chk" type="checkbox" name="chk" value="<%=i%>">
							<input type="hidden" name="day<%=i%>" value="<%= diary.getInsertDate() %>">
							</button>
						</h5>
					</div>
					<div id="collapse<%=i %>" class="collapse" aria-labelledby="heading<%=i %>" data-parent="#accordion">
						<div class="card-body py-0">
							<div class="form-group">
								<label for="good<%=i%>">良かった点</label>
								<textarea id="good<%=i %>" class="form-control" name="good_com<%=i%>" maxlength="30" rows="2"><%=diary.getGoodPoint()%></textarea>
							</div>
							<div class="form-group">
								<label for="bad<%=i%>">悪かった点</label>
								<textarea  id="bad<%=i%>" class="form-control" name="bad_com<%=i%>" maxlength="30" rows="2"><%=diary.getBadPoint()%></textarea>
							</div>
							<div class="form-group">
								<label for="stdCom<%=i%>">一言</label>
								<textarea  id="stdCom<%=i%>" class="form-control" name="std_com<%=i%>" maxlength="30" rows="2"><%=diary.getStdCom()%></textarea>
							</div>
						</div>
					</div>
				</div>
				<% i++;} %>

			<div class="col-md-12 p-0">
			<a href="MenuServlet" class="m-0 col-md-6 btn btn-lg btn-neutral border border-danger text-center">戻る</a>
			<button class="float-right m-0 col-md-6 btn btn-neutral btn-lg border border-danger" type="button" id="revbtn"  data-toggle="modal" data-target="#myModal">修正</button>
			</div>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
    				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text text-danger" id="exampleModalLabel">日誌修正</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
       					   <span aria-hidden="true">&times;</span>
						</button>
      				</div>
      				<div class="modal-body">
      					<p class="text-danger text-center">修正する日誌には必ずチェックを付けてください。</p>
						<p class="text-center">チェックされた日付の日誌を修正します。<br>間違いありませんか？</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary px-4" data-dismiss="modal">戻る</button>
						<button type="submit" class="btn btn-primary float-right px-4">修正</button>
					</div><!-- /.modal-footer -->
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>