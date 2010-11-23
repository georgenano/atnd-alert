<%@ page language="java" contentType="text/html; charset=utf8"
		pageEncoding="utf8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%
User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"
		content="text/html; charset=utf-8">
	<title>ATNDアラート - キーワード登録画面</title>
</head>
<body>
	<h1>ATNDアラート キーワード登録</h1>
	<p>こんにちは！<%=user.getNickname() %>さん</p>
	<a href="/logout">ログアウト</a><br />

	<p>チェックしたいイベントのキーワードを登録してください.</p>
	<p>キーワードに合致する新着ATND情報（イベント）をEmail（<%=user.getEmail() %>）にお届けします.</p>
	<form action="/regist" method="post">
		<table>
			<tr>
				<td>Alert word:</td><td><textarea name="alertWord" rows="1" cols="50"></textarea></td>				
			</tr>
		</table>
		<input type="submit" value="キーワード登録" />
	</form>
	
	<p><a href="/refer">キーワード管理</a></p>
</body>
</html>
