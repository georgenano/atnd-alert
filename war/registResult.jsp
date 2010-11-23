<%@ page language="java" contentType="text/html; charset=utf8"
		pageEncoding="utf8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%@ page import="com.appspot.atndalert.model.AtndEvent" %>
<%@ page import="com.appspot.atndalert.util.AtndDate" %>
<%@ page import="java.util.List" %>
<%
User user = (User)session.getAttribute("user");
String result = (String) request.getAttribute( "result" );
List<AtndEvent> aes = (List<AtndEvent>) request.getAttribute("searchResult");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"
		content="text/html; charset=utf-8">
	<title>ATNDアラート - キーワード登録結果画面</title>
</head>
<body>
	<h1>ATNDアラート キーワード登録結果</h1>
	<p>こんにちは！<%=user.getNickname() %>さん</p>
	<a href="/logout">ログアウト</a><br />

	<p>登録結果：<%=result %></p>
	
	<p>
		キーワードに合致する既登録のイベント一覧
		<table>
			<tr>
				<th>開催日</th>
				<th>場所</th>
				<th>タイトル</th>
			</tr>
		<% for(AtndEvent ae : aes){ %>
			<tr>
				<td><%=AtndDate.getDateString(ae.getStartedAt()) %></td>
				<td><%=ae.getPlace() %></td>
				<td><a href="<%=ae.getUrl() %>"><%=ae.getTitle() %></a></td>
			</tr>	
		<% } %>
		</table>
	</p>
	<a href="./regist.jsp">登録画面に戻る</a>

</body>
</html>
