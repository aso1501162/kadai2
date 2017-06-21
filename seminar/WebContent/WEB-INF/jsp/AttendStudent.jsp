<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>受講学生一覧</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="list">
		<h4>受講学生一覧</h4>
		<br>
			<div class="listname">講座名 〇人</div> <br>

				<table class="table table-bordered">
					<tr class="active">
						<td>名前</td>
						<td width="30%">クラス名</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="attend" items="${attendSubjectList}">
						<tr>
							<td><c:out value="${attend.day}" /></td>
							<td><c:out value="${attend.categoryName}" /></td>
							<td><c:out value="${attend.subjectName}" /></td>
							<td><c:out value="${attend.teacherName}" /></td>
							<td><input type="submit" value="削除" class="btn btn-default btn-xs" /></td>
						</tr>
					</c:forEach>
				</table> <input name="Button1" type="button" value="印刷" class="btn btn-info" />
	</div>
</body>

</html>
