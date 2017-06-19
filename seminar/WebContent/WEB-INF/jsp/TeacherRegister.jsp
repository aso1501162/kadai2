<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>

<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>教師科目登録画面</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>

<body>
		<jsp:include page="header.jsp" />
		<br>
		<div class="text">

			<h4>科目登録</h4>


<<<<<<< HEAD
<form class="form-inline" id="subject" action="" method="post" >
  <div class="form-group">

<input name="subject_id" type="text" placeholder="科目ID" class="form-control"/>
<input name="subject_name" type="text" placeholder="科目名" class="form-control"/>
<input name="teacher_name" type="text" placeholder="教師名" class="form-control"/>&nbsp;&nbsp;&nbsp;
曜日　<input name="Radio1" type="radio" class="radio" />火曜　<input name="Radio1" type="radio" class="radio" />木曜
	  <br>
	<dl class="submit">
		<button name="submit" type="submit" value="登録" class="btn btn-default"/> <input name="reset" type="reset" value="取消" class="btn btn-default" />　　　
	</dl>
</div>
</form>
=======
			<form class="form-inline" id="subject" action="" method="post">
				<div class="form-group">
>>>>>>> branch 'master' of https://github.com/aso1501162/kadai2.git

					<input name="subject_id" type="text" placeholder="科目ID"
						class="form-control" /> <input name="subject_name" type="text"
						placeholder="科目名" class="form-control" /> <input
						name="teacher_name" type="text" placeholder="教師名"
						class="form-control" />&nbsp;&nbsp;&nbsp; 曜日 <input name="Radio1"
						type="radio" class="radio" />火曜 <input name="Radio1" type="radio"
						class="radio" />木曜 <br>
					<dl class="submit">
						<button type="submit" name="action" value="delete" class="btn btn-default">登録</button>
						<button type="reset" class="btn btn-default">取消</button>
						<input name="submit" type="submit" value="登録" class="btn btn-default" />
						<input name="reset" type="reset" value="取消" class="btn btn-default" />
					</dl>
				</div>
			</form>


			<h4>科目一覧</h4>
			<h5>火 曜</h5>
			<table class="table table-bordered">
				<thead>
					<tr class="active">
						<th>科目ID</th>
						<th>分類名</th>
						<th>科目名</th>
						<th>教師名</th>
						<th width="7%">一覧</th>
						<th width="7%">削除</th>
					</tr>
				</thead>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input name="Button1" type="button" value="一覧"
						class="btn btn-default btn-xs" /></td>
					<td><input name="Button2" type="button" value="削除"
						class="btn btn-default btn-xs" /></td>
				</tr>
			</table>
			<br>
			<h5>木 曜</h5>
			<table class="table table-bordered">
				<thead>
					<tr class="active">
						<th>科目ID</th>
						<th>分類名</th>
						<th>科目名</th>
						<th>教師名</th>
						<th width="7%">一覧</th>
						<th width="7%">削除</th>
					</tr>
				</thead>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input name="Button1" type="button" value="一覧"
						class="btn btn-default btn-xs" /></td>
					<td><input name="Button2" type="button" value="削除"
						class="btn btn-default btn-xs" /></td>
				</tr>
	</table>
	</div>
</body>

</html>
