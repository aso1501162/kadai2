<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>ゼミ受講システム-管理者ログイン-</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>

<body>
	<article>

	<ul class="nav nav-tabs">
		<li><a href="ToggleLoginPage?page=student">学生ログイン</a></li>
		<li class="active"><a href="ToggleLoginPage?page=teacher">管理者ログイン</a></li>
	</ul>

	<h2 class="center">管理者ログイン</h2>

	<form method="post" action="Login" class="form-horizontal">
		<div class="login form-group">
			<label class="col-sm-2 control-label" for="InputId"><i class="material-icons md-24">account_box</i></label>
			<div class="col-sm-10">
				<input type="text" name="teacherid" class="form-control" /><br>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="InputPassword"><i class="material-icons md-24">lock</i></label>
			<div class="col-sm-10">
				<input type="password" name="password" class="form-control" /><br>
		</div>
		</div>

		<div class="form-group">
		<div class="col-sm-12 text-danger text-center">
			<c:out value="${errorMessage}" />
		</div>
		</div>

		<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<dl class="loginbtn">
			<input type="submit" value="ログイン" class="btn btn-default"/>
			</dl>
			</div>
		</div>
	</form>

	</article>
</body>

</html>
