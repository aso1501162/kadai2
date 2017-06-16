<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>教師科目登録画面</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

</head>

<body>
<div class="text">

<h4>科目登録</h4>


<form class="form-inline" id="subject" action="" method="post" >
  <div class="form-group">
    
<input name="subject_id" type="text" placeholder="科目ID" class="form-control"/> 　<input name="subject_name" type="text" placeholder="科目名" class="form-control"/>　<input name="teacher_name" type="text" placeholder="教師名" class="form-control"/>&nbsp;&nbsp;&nbsp;
曜日　<input name="Radio1" type="radio" class="radio" />火曜　<input name="Radio1" type="radio" class="radio" />木曜 
	  <br />
	  <dl class="submit">
<input name="submit" type="submit" value="登録" class="btn btn-default"/> <input name="reset" type="reset" value="取消" class="btn btn-default" />　　　
	</dl>
</div>
</form>

<h4>科目一覧</h4>

<table class="table table-bordered">
<thead>
	<tr class="active">
		<th>科目ID</td>
		<th>分類名</td>
		<th>科目名</td>
		<th>教師名</td>
		<th width="7%">一覧</td>
		<th width="7%">削除</td>
	</tr>
	</thead>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td><input name="Button1" type="button" value="一覧" class="btn btn-default btn-xs"/></td>
		<td><input name="Button2" type="button" value="削除" class="btn btn-default btn-xs"/></td>
	</tr>
</table>
</div>
</body>

</html>
