<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.GameData"%>
<%
GameData gameData=(GameData)session.getAttribute("gameData");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>ランキング登録</title>
</head>
<body>
	<div id="main">
		<strong>ランキング登録</strong>
		<h2><%=gameData.getGameName() %></h2>

		<strong><p>順位<span class="orange"><%=gameData.getOrder() %></span>位</p></strong> 
		<strong><p>得点:<span class="red"><%=gameData.getCorrectAnswersCnt() %></span>/<%=gameData.getTotalProblemCnt() %></p></strong>

		<form action="<%=request.getContextPath() %>/record">
			名前:<input type="text" name="name">
			<br><br>
			<input type="submit" value="登録"> 
			<input type="hidden" name="cmd" value="insert">
		</form>

	</div>

</body>
</html>