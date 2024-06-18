<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.GameData,bean.RecordData,bean.QuizGameBean,java.util.*"%>
<%
GameData gameData=(GameData) session.getAttribute("gameData");
ArrayList<RecordData> rankingList= (ArrayList<RecordData>)request.getAttribute("rankingList");
int gameType =(int) request.getAttribute("gameType");
String cmd =(String) request.getAttribute("cmd");
QuizGameBean QGB =new QuizGameBean();
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>ランキング</title>
</head>
<body>
	<div id="main">
		<p>ランキング確認</p>

		<h2><%=QGB.showQuizName(gameType) %></h2>

		<table class="ranking-table">
			<tr>
				<th>順位</th>
				<th>名前</th>
				<th>得点</th>
			</tr>
			<%for(int i=0;i<rankingList.size();i++){ %>
				<%if(i+1==gameData.getOrder()){ %>
					<tr class="rank_in">
						<td><%=QGB.showResultOrder(i,rankingList) %>位</td>
						<td><%=rankingList.get(i).getName()%></td>
						<td><%=rankingList.get(i).getScore() %>点</td>
					</tr>
				<%}else{ %>
					<tr>
						<td><%=QGB.showResultOrder(i,rankingList) %>位</td>
						<td><%=rankingList.get(i).getName()%></td>
						<td><%=rankingList.get(i).getScore() %>点</td>
					</tr>
				<%} %>
			<%} %>

		</table>

		<%
		if(cmd.equals("insert")){
		%>
			<br>
			<a href="<%=request.getContextPath()%>/view/menu.jsp">メニューへ戻る</a>
	
		<% 
		}else if(cmd.equals("show")){
		%>
			<br>
			 <a href="<%=request.getContextPath()%>/view/selectRanking.jsp">ランキング選択画面へ戻る</a>
		<% 
		}
		%>

	</div>

</body>
</html>