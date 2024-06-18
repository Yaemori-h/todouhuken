<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String error = (String) request.getAttribute("error");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>エラー</title>
</head>
<body>
	<div id="main">
	
		<h2>■エラー■</h2>
		<%
		if (error.equals("db_error")) {
		%>
			<h2>データベース接続エラーが発生しました。</h2>
		<%
		} else if (error.equals("sess_error")) {
		%>
			<h2>セッションタイムアウトが発生しました。</h2>
		<%
		}
		%>
		<br><br> 
		<a href="<%=request.getContextPath()%>/view/start.jsp">スタート画面に戻る</a>

	</div>

</body>
</html>