<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.GameData,bean.QuizGameBean,jakarta.servlet.http.HttpSession"%>
<%
String error="";
QuizGameBean QGB = new QuizGameBean();
GameData gameData=(GameData)session.getAttribute("gameData");
if (QGB.checkSession(gameData) == false) {
	error = "sess_error";
	request.setAttribute("error", error);
	request.getRequestDispatcher("/view/error.jsp").forward(request, response);
}
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>ゲーム結果</title>
</head>
<body>
	<div id="main">
		<h2><%=gameData.getGameName() %></h2>

		<!-- ランクインかどうかの表示 -->

		<% 
		int order=gameData.getOrder();
		if(order<21){
		%>
			<Strong class="red">☆Rank In☆</Strong>
		<%} %>

		<Strong><p>
			正解数：
			<%=gameData.getCorrectAnswersCnt() %>
			/
			<%=gameData.getTotalProblemCnt() %>
		</p></Strong> 
		
		<Strong><p>答え合わせ</p></Strong>

		<table class="result-table">
			<tr>
				<th>問題の解答</th>
				<th>選択した解答</th>
				<th>結果</th>
			</tr>

			<% for(int i=0;i<gameData.getTotalProblemCnt();i++){ %>
			<tr>
				<!-- 画像リンクを埋め込み -->
				<td><a href="<%=request.getContextPath() %>/view/map/<%=gameData.getFileName().get(i) %>"><%=gameData.getAnswer().get(i) %></a></td>
				<td><%=gameData.getSelectAnswer().get(i) %></td>
				<%if(gameData.getResult().get(i).equals("正解")){ %>
				<td class="red"><%=gameData.getResult().get(i) %></td>
				<%}else{ %>
				<td class="blue"><%=gameData.getResult().get(i) %></td>
				<%} %>
			</tr>

			<% } %>

		</table>

		<% 
		if(order<21){
		%>
			<br> <a
				href="<%=request.getContextPath() %>/view/insertRanking.jsp">ランキング登録画面へ</a>
		<%}else {%>
			<br> <a href="<%=request.getContextPath() %>/view/menu.jsp">メニューへ戻る</a>

		<% } %>

	</div>

</body>
</html>