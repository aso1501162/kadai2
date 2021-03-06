﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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

	<div class="col-sm-12 text-danger text-center">
		<c:out value="${message}" />
	</div>

	<div class="text">


	<h4>科目登録</h4>
	<form class="form-inline" class="subject" action="RegistSubject" method="post">
		<div class="center">
			<div class="form-group">

					<!-- 科目ID -->
					<i class="material-icons md-18">mode_edit</i> <input
						name="subject_id" type="text" placeholder="科目ID"
						class="form-control" />

					<!-- 分類 -->
					<select class="form-control" name="category_id"
						style="width: 200px">
						<option value="" disabled selected>-------分類-------</option>
						<c:forEach var="cat" items="${categoryList}">
							<option value="<c:out value="${cat.categoryId}" />"><c:out value="${cat.categoryName}" /></option>
						</c:forEach>
					</select>
		</div>
		<br>
		<br>
		<div class="form-group">
		<i class="material-icons md-18">mode_edit</i>
		<!-- 科目名 -->
		<input name="subject_name" type="text" placeholder="科目名" class="form-control" />

		<!-- 教師ID -->
		<select class="form-control" name="teacher_id" style="width:200px">
			<option value="" disabled selected>-------教師-------</option>
			<c:forEach var="tea" items="${teacherList}">
				<option value="<c:out value="${tea.teacherId}" />"><c:out value="${tea.teacherName}" /></option>
			</c:forEach>
		</select>
		</div>
		<br>
		<br>
		<div class="form-group">
		<i class="material-icons md-18">mode_edit</i>　曜日　
		<input name="day" type="radio" class="radio" value="火" /> 火曜　
		<input name="day" type="radio" class="radio" value="木" /> 木曜 <br>
		</div>
		<br>
		<br>
		<div class="form-group">
		<dl class="submit">
			<div class="radio">
				<label>
					<button type="submit" name="action" value="insert" class="btn btn-default">登録</button>
				</label>
			</div>
			<div class="radio">
				<label>
					<button type="reset" class="btn btn-default">取消</button>
				</label>
			</div>
		</dl>
		</div>
		
	</div>
</form>

<h4>科目一覧</h4>
<br>
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

	<c:forEach var="tueSub" items="${tuesdaySubjectList}">
		<tr>
			<td><c:out value="${tueSub.subjectId}" /></td>
			<td><c:out value="${tueSub.categoryName}" /></td>
			<td><c:out value="${tueSub.subjectName}" /></td>
			<td><c:out value="${tueSub.teacherName}" /></td>
			<td><button class="btn btn-default" onclick="location.href='ListAttendance?id=<c:out value="${tueSub.subjectId}" />'" >一覧</button></td>
			<td><button class="btn btn-default" onclick="location.href='DeleteSubject?id=<c:out value="${tueSub.subjectId}" />'" >削除</button></td>
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

	<c:forEach var="thuSub" items="${thursdaySubjectList}">
		<tr>
			<td><c:out value="${thuSub.subjectId}" /></td>
			<td><c:out value="${thuSub.categoryName}" /></td>
			<td><c:out value="${thuSub.subjectName}" /></td>
			<td><c:out value="${thuSub.teacherName}" /></td>
			<td><button class="btn btn-default" onclick="location.href='ListAttendance?id=<c:out value="${thuSub.subjectId}" />'" >一覧</button></td>
			<td><button class="btn btn-default" onclick="location.href='DeleteSubject?id=<c:out value="${thuSub.subjectId}" />'" >削除</button></td>
		</tr>
	</c:forEach>
</table>

</div>
<br>

</body>
</html>
