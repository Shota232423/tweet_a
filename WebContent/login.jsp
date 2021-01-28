<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Boolean b = (Boolean) request.getAttribute("login");
Boolean blank = (Boolean) request.getAttribute("blank");
if (b == null) {
	b = false;
}
if (blank == null) {
	blank = false;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="form.css">
</head>
<body>
	<div class="login">
		<h2>ログイン</h2>
		<form action="/tweet_a/login" method="post">
			<div class="name">
				<label for="name">お名前</label><br> <input type="text"
					name="name"><br>
			</div>
			<div class="password">
				<label for="password">パスワード</label><br> <input type="password"
					name="password"><br>
			</div>
			<input type="submit" value="ログイン">
		</form>
		<a href="/tweet_a/entry.jsp">新規登録はこちらから</a>
		<%
			if (b) {
		%>
		<p>
			<font color="red">ログインに失敗しました。</font>
		</p>
		<%
			}
		%>
		<%
			if (blank) {
		%>
		<p>未入力の項目があります。</p>
		<%
			}
		%>
	</div>

</body>
</html>