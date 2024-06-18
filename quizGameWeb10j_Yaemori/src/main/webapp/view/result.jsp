<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.GameData,java.util.*"%>
<%
GameData gameData=(GameData)session.getAttribute("gameData");
String state=(String)request.getAttribute("state");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>結果</title>
</head>
<body>
	<div id="main">
		<h2><%=gameData.getGameName() %></h2>

		<%if (gameData.getResult(gameData.getProblemCnt()-1).equals("正解")){%>
			<Strong>判定:<span class="red"><%=gameData.getResult(gameData.getProblemCnt()-1) %></span></Strong>
		<% }else{%>
		<Strong>判定:<span class="blue"><%=gameData.getResult(gameData.getProblemCnt()-1) %></span></Strong>
		<%} %>

		<p>
			正解数：
			<%=gameData.getCorrectAnswersCnt() %>
			/
			<%=gameData.getTotalProblemCnt() %>
		</p>

		<% if(state.equals("nextGame")){ %>
			<br>
			<form action="<%=request.getContextPath()%>/initGame">
				<input type="submit" value="次の問題">
				<input type="hidden" name="cmd" value="game">
			</form>
		<%}else if(state.equals("gameResult")){ %>
			<br>
			<strong><div class="red">◆全問回答終了◆</div></strong>
			<br>
			<form action="<%=request.getContextPath()%>/view/gameResult.jsp">
				<input type="submit" value="最終結果へ">
			</form>

		<%} %>

	</div>
</body>
</html>