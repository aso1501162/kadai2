<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>写真コンテスト</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="header">
	<img alt="" height="70" src="img/title.png" width="350" /></div>

<br>
<div class="tb">
<div class="tb-inn">

	<img alt="" height="46" src="img/title2.jpg" width="156" class="title2"/><br>

<c:forEach var="post" items="${postList}">
	<div id="<c:out value="${post.postId}" />" class="photoframe">
 <p class="photo"><img src="img/post/<c:out value="${post.postId}" />/thumbnail/<c:out value="${post.fileName}" />"/></p>
  <c:out value="${post.title}" /><br>
  	<p class="inl">
  	<span class="inl-1"><img alt="" src="img/vote.png" /></span>
	<span class="inl-2"><a href="https://twitter.com/share" class="twitter-share-button" data-size="large">Tweet</a> <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script></span>
	</p>
</div>
</c:forEach>

</div>
</div>

</body>

</html>

