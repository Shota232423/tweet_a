<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.tweet_info,model.theme"%>

<%
	List<tweet_info> t = (List<tweet_info>) application.getAttribute("tweet");
    String name = (String) session.getAttribute("name");
    theme theme = new theme();
    String ourtheme = theme.themedata();
    System.out.println(ourtheme);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/form.css">
<title>ツイート画面</title>
</head>
<body>
<div class="nowinfo">
      <p><%=name%>でログイン中</p>
      <a href="<%=request.getContextPath()%>/logout">ログアウト</a>
      </div>
<div class="ourdata">
<h2>今日のテーマ</h2>
 <p><%=ourtheme%></p>
</div>
	<section class="box">
		<form action="/tweet_a/tweet" method="post">
			<h3>What do you think?</h3>
			<textarea name="tweet" rows="5" style="width: 485px"></textarea>
			<div class="botton">
				<input type="submit" value="tweet"
					style="width: 200px; height: 50px;">
			</div>
		</form>
	</section>


	<%
		if (t != null) {
	%>

	<%
		for (tweet_info a : t) {
	%>
	<div class="tweet">
		<p>
			<strong><%=a.name%></strong>
		</p>
		<%=a.time%>

		<p><%=a.tweet%></p>
	</div>
	<%
		}
	}
	%>

</body>
</html>