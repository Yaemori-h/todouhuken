<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.GameData,bean.QuizGameBean"%>
<%
String strGameType = request.getParameter("gameType");
GameData gameData = new GameData();
QuizGameBean QGB = new QuizGameBean();
int gameType = Integer.parseInt(strGameType);
String Qname = QGB.showQuizName(gameType);
gameData.setGameName(Qname);
%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>クイズ開始画面</title>
</head>
<body>
	<div id="main">
		
		<h2><%=Qname%></h2>
		<%
		if (gameType < 4) {
		%>
			<img src="map/regionAll.jpg">
		<%
		} else {
		%>
			<img src="map/region<%=gameType - 3%>.jpg">
		<%}%>

		<div class="initGame-btn">
			<form action="<%=request.getContextPath()%>/initGame" class="inline-block">
				<input type="submit" value="ゲーム開始"> 
				<input type="hidden" name="gameType" value=<%=gameType%>> 
				<input type="hidden" name="cmd" value="init">
			</form>
			<form action="<%=request.getContextPath()%>/view/menu.jsp" class="inline-block">
				<input type="submit" value="メニューに戻る">
			</form>
		</div>

	</div>

</body>
</html>