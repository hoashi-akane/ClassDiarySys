<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>紹介</title>
</head>
<style>
<%@include file="../../css/nowuicss/bootstrap.min.css"%>
<%@include file="../../css/nowuicss/now-ui-kit.css"%>
</style>
<body>
<div class="container">
	<div class="row mt-5">
		<h2 class="col-md-10 mb-4 text text-secondary">こちらはクラスの日誌を管理するシステムです。</h2>
	</div>
	<div class="col-md-12">
		<a href="LoginServlet" class="border border-danger btn btn-neutral btn-lg">クラス日誌管理システムへ</a>
	</div>

	<div class="row">
		<h3 class="col-md-12 mb-2 text text-secondary">機能</h3>
		<div class="mx-4 text text-secondary">
			<p>クラス別に日誌閲覧、作成、修正、削除機能があります。<br>
				ー　自分のクラスのみ閲覧可能です。<br>
				ー　作成は当日又は過去31(30?)日まで可能です。<br>
				ー　修正は以前自分が作成した日誌のみ可能です。<br>
				ー　削除は以前自分が作成した日誌のみ可能です。<br>
			</p>
		</div>
		<h3 class="col-md-12 mb-2 text text-secondary">ログイン用アカウント</h3>
		<div class="mx-4 text text-secondary">
			<table class="table">
				<thead>
				<tr>
					<th scope="col">所属クラス</th><th scope="col">学籍番号</th><th scope="col">Password</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<th scope="row">A</th><th scope="row">1801182</th><th scope="row">password</th>
				</tr>
				<tr>
					<th scope="row">B</th><th scope="row">2019111</th><th scope="row">AAAXXXX</th>
				</tr>

				</tbody>
			</table>
		</div>
		<h3 class ="col-md-12 mb-2 text text-secondary">構成</h3>
		<div class="mx-4 border border-primary">
			<img src="./img/imggg.png" width="500px" height="400px">
		</div>
		<h3 class ="col-md-12 mb-2 text text-secondary">データベース</h3>
		<div class="mx-4 border border-primary">
			<img src="./img/dbbb.PNG" width="500px" height="400px">
		</div>
</div>
</body>
</html>