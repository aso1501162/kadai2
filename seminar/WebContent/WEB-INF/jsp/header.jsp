<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<<<<<<< HEAD
<body>
	<div class="header">
		<img alt="" height="24" src="img/user.png" width="24">
		<c:if test="${loginStudent != null}">
			<c:out value="${loginStudent.studentName}" />
		</c:if>
		<c:if test="${loginTeacher != null}">
			<c:out value="${loginTeacher.teacherName}" /> (管理者)
</c:if>
		<a href="/Logout">ログアウト</a>
	</div>
=======
<body>

<div id="header" class="col-sm-offset-2 col-sm-8" >
>>>>>>> branch 'master' of https://github.com/aso1501162/kadai2

</body>

</html>
