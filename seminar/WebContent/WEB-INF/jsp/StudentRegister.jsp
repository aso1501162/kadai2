<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<th width="10%">曜日</th>
					<th width="15%">分類名</th>
					<th width="35%">科目名</th>
					<th width="25%">教師名</th>
					<th>削除</th>
				</tr>

				<c:forEach var="attendSubject" items="${attendSubjectList }">
					<tr>
						<td><c:out value="${attendSubject.day}" /></td>
						<td><c:out value="${attendSubject.categoryName}" /></td>
						<td><c:out value="${attendSubject.subjectName}" /></td>
						<td><c:out value="${attendSubject.teacherName}" /></td>
						<td><button type="submit" name="action" value="delete" class="btn btn-default">削除</button></td>
					</tr>
				</c:forEach>

				<tr>
					<td style="width: 109px"></td>
					<td style="width: 231px"></td>
					<td style="width: 363px"></td>
					<td style="width: 285px"></td>
					<td><button type="submit" name="action" value="delete" class="btn btn-default">削除</button></td>
				</tr>
			</table>

			<br>

			<h4>科目一覧</h4>

			<h5>火 曜</h5>
			<table class="table table-bordered">
				<tr class="active">
					<th width="10%">科目ID</th>
					<th width="15%">分類名</th>
					<th width="35%">科目名</th>
					<th width="25%">教師名</th>
					<th width="7%">申込</th>
				</tr>

				<c:forEach var="tuesdaySubject" items="${tuesdaySubjectList}">
					<tr>
						<td><c:out value="${tuesdaySubject.subjectId}" /></td>
						<td><c:out value="${tuesdaySubject.categoryId}" /></td>
						<td><c:out value="${tuesdaySubject.subjectName}" /></td>
						<td><c:out value="${tuesdaySubject.teacherName}" /></td>
						<td><input type="radio" name="tue" /></td>
						<td><input type="radio" name="thu" /></td>
					</tr>
				</c:forEach>
			</table>

			<br>

			<h5>木 曜</h5>
			<table class="table table-bordered">
				<tr class="active">
					<th width="10%">科目ID</th>
					<th width="15%">分類名</th>
					<th width="35%">科目名</th>
					<th width="25%">教師名</th>
					<th width="7%">申込</th>
				</tr>

				<c:forEach var="thursdaySubject" items="${thursdaySubjectList}">
					<tr>
						<td><c:out value="${thursdaySubject.subjectId}" /></td>
						<td><c:out value="${thursdaySubject.categoryId}" /></td>
						<td><c:out value="${thursdaySubject.subjectName}" /></td>
						<td><c:out value="${thursdaySubject.teacherName}" /></td>
						<td><input type="radio" name="tue" /></td>
						<td><input type="radio" name="thu" /></td>
					</tr>
				</c:forEach>
			</table>


			<p class="right">
				<button type="submit" name="action" value="insert" class="btn btn-default">確定</button>
			</p>
		</form>

	</div>
</body>

</html>
