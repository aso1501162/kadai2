<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>写真コンテスト</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<link href="modal.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<!--ここから　投票フォーム-->
	<div class="modal-content-form center">
		<form action="Vote" method="post">
			学籍番号<input type="text" name="number" /><br>
			生年月日<input type="text" name="birthday" /><br>
			<input type="hidden" name="postid" value="<c:out value="${post.postId}" />"/>
			コメント<textarea name="comment" rows="5" cols="25"></textarea>
			<p class="center">
				<button class="modal-close">やめる</button>
				<input type="submit" value="投票" />
			</p>
		</form>
	</div>
	<!--ここまで　投票フォーム-->

	<!--JavaScriptの読み込み-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="modal.js"></script>

<div id="header"></div>

<br>
<div class="tb">
	<div class="tb-inn">
		<img alt="" height="46" src="img/title2.jpg" width="156" class="title2"/><br>

		<c:forEach var="post" items="${postList}">
			<div id="<c:out value="${post.postId}" />" class="photoframe">
				<p class="photo"><img src="img/post/<c:out value="${post.postId}" />/thumbnail/<c:out value="${post.fileName}" />"/></p>
				<c:out value="${post.title}" /><br>
				<p class="inl">
					<span class="inl-1 modal-open"><img alt="" src="img/vote.png" /></span>
					<span class="inl-2"><a href="https://twitter.com/share" class="twitter-share-button" data-size="large">Tweet</a>
					<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script></span>
				</p>
			</div>
		<!--ここから　拡大表示-->
			<div id="modal-content-<c:out value="${post.fileName}" />" class="center modal-content-pic">
				<img alt="" height="400" src="img/post/<c:out value="${post.postId}" />/<c:out value="${post.fileName}" />" width="600" />
				<p class="center"><a class="modal-close button-link">閉じる</a></p>
			</div>
		</c:forEach>

	<!--ここまで　拡大表示-->

	</div>
</div>

</body>

</html>
