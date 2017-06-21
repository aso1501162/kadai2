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
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
	<jsp:include page="header.jsp" />
	<br>
	<div class="text">

	<h4>科目登録</h4>


<form class="form-inline" id="subject" action="" method="post">
	<div class="form-group">

		<input name="subject_id" type="text" placeholder="科目ID" class="form-control" />
		<input name="subject_name" type="text" placeholder="科目名" class="form-control" />
		<input name="teacher_name" type="text" placeholder="教師名" class="form-control" />&nbsp;&nbsp;&nbsp; 曜日
		<input name="Radio1" type="radio" class="radio" />火曜
		<input name="Radio1" type="radio" class="radio" />木曜 <br>
		<dl class="submit">
			<button type="submit" name="action" value="insert" class="btn btn-default">登録</button>
			<button type="reset" class="btn btn-default">取消</button>
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

<<<<<<< HEAD
	<c:forEach var="tueSub" items="${tuesdaySubjectList}">
=======
	<c:forEach var="tuesdaySubject" items="${tuesdaySubjectList}">
>>>>>>> branch 'master' of https://github.com/aso1501162/kadai2.git
		<tr>
<<<<<<< HEAD
			<td><c:out value="${tueSub.subjectId}" /></td>
			<td><c:out value="${tueSub.categoryId}" /></td>
			<td><c:out value="${tueSub.subjectName}" /></td>
			<td><c:out value="${tueSub.teacherName}" /></td>
			<td><input name="Button1" type="button" value="一覧" class="btn btn-default btn-xs" /></td>
			<td><input name="Button2" type="button" value="削除" class="btn btn-default btn-xs" /></td>
=======
			<td><c:out value="${tuesdaySubject.subjectId}" /></td>
			<td><c:out value="${tuesdaySubject.categoryId}" /></td>
			<td><c:out value="${tuesdaySubject.subjectName}" /></td>
			<td><c:out value="${tuesdaySubject.teacherName}" /></td>
			<td><button type="submit" name="action" value="list" class="btn btn-default">一覧</button></td>
			<td><button type="submit" name="action" value="delete" class="btn btn-default">削除</button></td>
>>>>>>> branch 'master' of https://github.com/aso1501162/kadai2.git
		</tr>
	</c:forEach>
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

<<<<<<< HEAD
	<c:forEach var="thuSub" items="${thursdaySubjectList}">
=======
	<c:forEach var="thursdaySubject" items="${thursdaySubjectList}">
>>>>>>> branch 'master' of https://github.com/aso1501162/kadai2.git
		<tr>
<<<<<<< HEAD
			<td><c:out value="${thuSub.subjectId}" /></td>
			<td><c:out value="${thuSub.categoryId}" /></td>
			<td><c:out value="${thuSub.subjectName}" /></td>
			<td><c:out value="${thuSub.teacherName}" /></td>
			<td><input name="Button1" type="button" value="一覧" class="btn btn-default btn-xs" /></td>
			<td><input name="Button2" type="button" value="削除" class="btn btn-default btn-xs" /></td>
=======
			<td><c:out value="${thursdaySubject.subjectId}" /></td>
			<td><c:out value="${thursdaySubject.categoryId}" /></td>
			<td><c:out value="${thursdaySubject.subjectName}" /></td>
			<td><c:out value="${thursdaySubject.teacherName}" /></td>
			<td><button type="submit" name="action" value="list" class="btn btn-default">一覧</button></td>
			<td><button type="submit" name="action" value="delete" class="btn btn-default">削除</button></td>
>>>>>>> branch 'master' of https://github.com/aso1501162/kadai2.git
		</tr>
	</c:forEach>
</table>

</body>

</html>
