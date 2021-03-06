<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "beans.DiaryListBeans" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教員削除可能日誌一覧</title>
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
	  $("#delbtn").prop("disabled", true);
	    // チェックボックスの状態が変わったら（クリックされたら）
	    $("input[type='checkbox']").on('change', function () {
	        // チェックされているチェックボックスの数
	        if ($(".chk:checked").length > 0) {
	          // ボタン有効
	          $("#delbtn").prop("disabled", false);
	        } else {
	          // ボタン無効
	          $("#delbtn").prop("disabled", true);
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
	<%@include file="/WEB-INF/jsp/tcrHeader.jsp" %>
</header>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">削除可能日誌一覧</h2>
		<div class="col-md-8 offset-md-2">
		<div id="accordion">
			<form action="TcrDelDiaryServlet" method="POST">
			<c:forEach var="diary" items="${diaryList }">
				<div class="card">
					<div class="card-header" id="heading<%=i%>">
						<h5>
							<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse<%=i %>" aria-expanded="false" aria-controls="collapse<%=i %>">
								作成日：<c:out value= "${diary.getInsertDate()}" />  　　作成者：<c:out value="${ diary.getUserName()}"/>
							<input class="chk" type="checkbox" name="chk" value="${diary.insertDate}">
							</button>
						</h5>
					</div>
					<div id="collapse<%=i %>" class="collapse" aria-labelledby="heading<%=i %>" data-parent="#accordion">
						<div class="card-body py-0">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">良かった点</th>
										<th scope="col">悪かった点</th>
										<th scope="col">学生コメント</th>
										<th scope="col">担任コメント</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><c:out value="${diary.getGoodPoint()}"/></td>
										<td><c:out value="${diary.getBadPoint()}"/></td>
										<td><c:out value="${diary.getStdCom()}"/></td>
										<td><c:out value="${diary.getTcrCom()}"/></td>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<% i++; %>
				</c:forEach>
			<div class="col-md-12 p-0">
			<a href="TcrMenuServlet" class="m-0 col-md-6 btn btn-lg btn-neutral border border-danger text-center">戻る</a>
			<button class="float-right m-0 col-md-6 btn btn-neutral btn-lg border border-danger" type="button" id="delbtn"  data-toggle="modal" data-target="#myModal">削除</button>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
    				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text text-danger" id="exampleModalLabel">日誌削除</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
       					   <span aria-hidden="true">&times;</span>
						</button>
      				</div>
      				<div class="modal-body">
      					<p class="text-danger text-center">削除する日誌には必ずチェックを付けてください。</p>
						<p class="text-center">チェックされた日付の日誌を削除します。<br>間違いありませんか？</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary px-4" data-dismiss="modal">戻る</button>
						<button type="submit" class="btn btn-primary float-right px-4">削除</button>
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
</body>
</html>