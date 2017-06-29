<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>

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
		
			<table class="table table-bordered">
				<tr class="active">
					<th width="10%">曜日</th>
					<th width="15%">分類名</th>
					<th width="35%">科目名</th>
					<th width="25%">教師名</th>
					<th>削除</th>
				</tr>


				<c:if test="${attendSubjectList != null}">
					<c:forEach var="attend" items="${attendSubjectList}">
						<tr>
							<td><c:out value="${attend.day}" /></td>
							<td><c:out value="${attend.categoryName}" /></td>
							<td><c:out value="${attend.subjectName}" /></td>
							<td><c:out value="${attend.teacherName}" /></td>
							<td><button class="btn btn-default" onclick="location.href='DeleteAttendance?id=<c:out value="${attend.subjectId}" />'" >削除</button></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>

			<br>

			<h4>科目一覧</h4>
			
			<form method="post" action="AttendSubject">

			<h5>火 曜</h5>
			<table class="table table-bordered">
				<tr class="active">
					<th width="10%">科目ID</th>
					<th width="15%">分類名</th>
					<th width="35%">科目名</th>
					<th width="25%">教師名</th>
					<th width="7%">申込</th>
				</tr>

				<c:forEach var="tueSub" items="${tuesdaySubjectList}">
					<tr>
						<td><c:out value="${tueSub.subjectId}" /></td>
						<td><c:out value="${tueSub.categoryName}" /></td>
						<td><c:out value="${tueSub.subjectName}" /></td>
						<td><c:out value="${tueSub.teacherName}" /></td>
						<td><input type="radio" name="tue" value="<c:out value="${tueSub.subjectId}" />" /></td>
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

				<c:forEach var="thuSub" items="${thursdaySubjectList}">
					<tr>
						<td><c:out value="${thuSub.subjectId}" /></td>
						<td><c:out value="${thuSub.categoryName}" /></td>
						<td><c:out value="${thuSub.subjectName}" /></td>
						<td><c:out value="${thuSub.teacherName}" /></td>
						<td><input type="radio" name="thu" value="<c:out value="${thuSub.subjectId}" />" /></td>
					</tr>
				</c:forEach>
			</table>


			<p class="right">
				<button type="submit" class="btn btn-default">確定</button>
			</p>
		</form>

	</div>
</body>

</html>
