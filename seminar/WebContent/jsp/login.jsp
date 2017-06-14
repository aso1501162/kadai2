<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>ログイン - 週間スケジュール</title>
</head>

<body>

<div class="container">
	
	<h1>週間スケジュール</h1>
	
	<section>
		<p class="text-center"><c:out value="${logout}" /></p>
	</section>
	
	<article>
	<form class="form-horizontal col-sm-offset-2 col-sm-8" method="post" action="Login">
	
		<div class="form-group">
			<h2 class="col-sm-offset-2">ログイン</h2>
		</div>		
		
		<!-- ユーザID -->
		<div class="form-group">
			<label class="col-sm-4 control-label" for="userid">ユーザID</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="userid" name="userid" placeholder="ユーザID">
			</div>
		</div>
		<!-- パスワード -->
		<div class="form-group">
			<label class="col-sm-4 control-label" for="password">パスワード</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="password" name="password" placeholder="パスワード">
			</div>
		</div>
		
		<!-- エラーメッセージ -->
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<p class="text-danger text-left"><c:out value="${error}" /></p>
			</div>
		</div>
		
		<!-- ログインボタン -->
		<div class="form-group">
			<div class="text-center">
				<button type="submit" class="btn btn-primary">ログイン</button>
			</div>
		</div>
	</form>
	</article>

</div>

</body>
</html>