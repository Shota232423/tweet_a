<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Boolean b = (Boolean) request.getAttribute("blank");
if (b == null) {
	b = false;
}
Boolean h = (Boolean) request.getAttribute("count");
if (h == null) {
	h = true;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/form.css">
<title>新規登録</title>
</head>
<body>

	<div class="entry">
		<h2>新規登録</h2>
		<form action="/tweet_a/entry" method="post">
			<div class="name">
				<label for="name">お名前</label><br> <input type="text"
					name="name"><br>
			</div>
			<div class="password">
				<label for="password">パスワード</label><br> <input type="password"
					name="password"><br>
			</div>
			<input type="submit" value="登録">
		</form>
		<a href="/tweet_a/login.jsp">ログインはこちらから</a>
		<%
			if (b) {
		%>
		<p>未入力の項目があります。</p>
		<%
			}
		%>
		<%
			if (!h) {
		%>
		<p>そのユーザーはすでに存在します。</p>
		<%
			}
		%>

	</div>
</body>
</html>