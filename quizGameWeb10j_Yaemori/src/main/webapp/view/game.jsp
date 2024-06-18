<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.GameData,java.util.*"%>
<%
GameData gameData = (GameData) session.getAttribute("gameData");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>ゲーム</title>
</head>
<body>
	<div id="main">

		<h2><%=gameData.getGameName()%></h2>
		<p>
			第<%=gameData.getProblemCnt()%>問
		</p>
		<h4>この都道府県は何？</h4>
		<img
			src="view/map/<%=gameData.getFileName().get(gameData.getProblemCnt() - 1)%>">
		<p></p>
		<form name="game" onSubmit="return check()"
			action="<%=request.getContextPath()%>/result">
			<input type="radio" name="answer" value="0" id="radio1"><label for="radio1"><%=gameData.getChoices(gameData.getProblemCnt() - 1).get(0)%></label>
			<input type="radio" name="answer" value="1" id="radio2"><label for="radio2"><%=gameData.getChoices(gameData.getProblemCnt() - 1).get(1)%></label>
			<input type="radio" name="answer" value="2" id="radio3"><label for="radio3"><%=gameData.getChoices(gameData.getProblemCnt() - 1).get(2)%></label>
			<input type="radio" name="answer" value="3" id="radio4"><label for="radio4"><%=gameData.getChoices(gameData.getProblemCnt() - 1).get(3)%></label>
			<br><br>
			<input type="submit" value="回答">
			<input type="hidden" name="cmd" value="game">
		</form>
		
		<script type="text/javascript">
			function check() {
				var answer = document.game.answer.value;
				if (answer == "") {
					alert("選択肢を選択してください");
					return false;
				} else {
					return true;
				}
			}
		</script>

	</div>

</body>
</html>