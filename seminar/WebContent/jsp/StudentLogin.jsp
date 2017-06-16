<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<title>ゼミ受講システム-ログイン-</title>
</head>
<body>
	<article>

	<ul class="nav nav-tabs">
		<li class="active"><a href="StudentLogin.html">学生ログイン</a></li>
		<li><a href="TeacherLogin.html">管理者ログイン</a></li>
	</ul>

	<h2 class="center">学生ログイン</h2>

	<form method="post" action="<%= request.getContextPath() %>/Login" class="form-horizontal">
		<div class="login form-group">
			<label class="col-sm-2 control-label" for="InputId">学生ID</label>
			<div class="col-sm-10">
				<input type="text" name="studentId" class="form-control" /><br>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="InputPassword">パスワード</label>
			<div class="col-sm-10">
				<input type="password" name="studentId" class="form-control" /><br>
		</div>
		</div>
		<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<dl class="loginbtn">
			<input type="submit" value="ログイン" class="btn btn-default"/></div>
			</p>
		</div>
	</form>

	</article>
</body>
</html>