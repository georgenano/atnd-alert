<%@ page language="java" contentType="text/html; charset=utf8"
		pageEncoding="utf8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%@ page import="com.appspot.atndalert.model.AlertWord" %>
<%@ page import="java.util.List" %>
<%@ page import="org.slim3.datastore.Datastore" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%
User user = (User)session.getAttribute("user");
String result = (String) request.getAttribute("result");
List<AlertWord> aws = (List<AlertWord>) request.getAttribute("alertWords");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"
		content="text/html; charset=utf-8">
	<title>ATNDアラート - キーワード登録状態画面</title>
</head>
<body>
	<h1>ATNDアラート キーワード登録状態</h1>
	<p>こんにちは！<%=user.getNickname() %>さん<br />
	<a href="/logout">ログアウト</a></p>

	登録結果：
	<form method="post" action="/delete">
		<ol>
		<% for(AlertWord aw : aws){ %>
			<li><input type="checkbox" name="key" value="<%=Datastore.keyToString(aw.getKey()) %>"><%=aw.getAlertWord() %></li>	
		<% } %>
		</ol>
		<input type="submit" value="キーワード削除" />
	</form>
	
	<p><a href="./regist.jsp">登録画面に戻る</a></p>

</body>
</html>
