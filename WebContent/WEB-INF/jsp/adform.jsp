<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/form.css">
<title>set a theme</title>
</head>
<body>
	<section class="box">
		<form action="/tweet_a/settheme" method="post">
			<h3>set a theme</h3>
			<textarea name="tweet" rows="5" style="width: 485px"></textarea>
			<div class="botton">
				<input type="submit" value="tweet"
					style="width: 200px; height: 50px;">
			</div>
		</form>
	</section>
</body>
</html>