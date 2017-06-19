﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>ゼミ受講システム-受講登録-</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="header.jsp" />
	<br>
	<div class="text">
	
	<h4>申込済み</h4>
	<form method="post" action="">
		<table class="table table-bordered">
			<tr class="active">
				<th width="10%">曜日</th><th width="15%">分類名</th>
				<th width="35%">科目名</th><th width="25%">教師名</th><th>削除</th>
			</tr>
			<tr>
				<td style="width: 109px"></td><td style="width: 231px"></td>
				<td style="width: 363px"></td><td style="width: 285px"></td>
				<td><input type="submit" value="削除" class="btn btn-default btn-xs"/></td>
			</tr>
		</table>
	<br>
		<h4>科目一覧</h4>
		<table class="table table-bordered">
			<tr class="active">
				<th width="10%">科目ID</th><th width="15%">分類名</th><th width="35%">科目名</th><th width="25%">教師名</th><th width="7%">火曜</th><th width="7%">木曜</th>
			</tr>
			<tr>
				<td></td><td></td><td></td><td></td>
				<td><input type="radio" name="tue" /></td>
				<td><input type="radio" name="thu" /></td>
			</tr>
		</table>
		<p class="right">
		<input type="submit" value="確定" class="btn btn-default" />
		</p>
	</form>

</div>
</body>

</html>
