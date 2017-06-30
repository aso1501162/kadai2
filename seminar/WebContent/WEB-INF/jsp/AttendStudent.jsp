<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>受講学生一覧</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="list">
		<h4>受講学生一覧</h4>
		<br>
			<div class="listname">
				<c:out value="${listSubject.subjectName}" />
			</div>
			<table style="width: 100%" class="table table-bordered">
				<tr>
					<td>ID：<c:out value="${listSubject.subjectId}" /></td>
					<td>分類：<c:out value="${listSubject.categoryName}" /></td>
					<td>曜日：<c:out value="${listSubject.day}" /></td>
					<td>教師：<c:out value="${listSubject.teacherName}" /></td>
				</tr>
		</table>
		<br>
			<div class="text-right"><c:out value="${attendStudentList.size()}" />人</div>

			<br>

				<table class="table table-bordered">
					<tr class="active">
						<td>ID</td>
						<td>名前</td>
						<td width="30%">クラス名</td>
					</tr>
					<c:forEach var="attend" items="${attendStudentList}">
						<tr>
							<td><c:out value="${attend.studentId}" /></td>
							<td><c:out value="${attend.studentName}" /></td>
							<td><c:out value="${attend.className}" /></td>
						</tr>
					</c:forEach>
				</table>
				<button class="btn btn-default" onclick="javascript:window.print();" >印刷</button>
	</div>
</body>

</html>
