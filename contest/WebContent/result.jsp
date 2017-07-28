<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="ja" http-equiv="Content-Language">
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>写真コンテスト-最終結果-</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="header"></div>

<br>
	<div class="tb_l">
		<div class="tb-linn">
		<img alt="" height="46" src="img/kekka.jpg" width="225" class="title2"><br>
			
		<% int rankNum = 1;%>
		<c:forEach var="rankPost" items="${rankPostList}">
			<br class="clear"><br>
			<table style="width: 45%">
					<tr>
						<td style="width: 100px"><img alt="" src="img/0<%= rankNum %>b.jpg"></td>
		<% rankNum = rankNum++;%>
						<td><c:out value="${rankPost.title }" /></td>
					</tr>
			</table>
			
			<br class="clear">
			
			<figure>
				<img alt="" height="200" src="img/post/<c:out value="${rankPost.postId}" />/thumbnail/<c:out value="${rankPost.fileName}" />" width="300" class="photo">
			</figure>

			<div class="evaluate">
				<p class="coupon"><c:out value="${rankPost.votes }" /></p>
				<c:forEach var="comment" items="${rankPost }">
					<p class="comments"><c:out value="${comment.commentList }" /></p>
				</c:forEach>
			</div>

			<br class="clear"><br>

		</c:forEach>
			
	</div>
	

</body>

</html>
