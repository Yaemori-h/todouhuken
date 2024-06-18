<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>メニュー</title>
</head>
<body>
	<div id="main">
		<h2>～メニュー～</h2>

		<div class="menu">
			<ul class="menu-ul">
				<li>●日本地図あてクイズ</li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=1">初級編（全10問）</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=2">中級編（全25問）</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=3">上級編（全47問）</a></li>
				<br>
				<li>●地域別クイズ</li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=4">中国・四国地方編</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=5">九州・沖縄地方編</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=6">関東地方</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=7">北海道・東北地方編</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=8">近畿地方</a></li>
				<li><a href="<%=request.getContextPath()%>/view/initGame.jsp?gameType=9">中部地方</a></li>
			</ul>
		</div>

		<p>
			<a href="<%=request.getContextPath()%>/view/selectRanking.jsp">ランキング</a>
		</p>

		<p>
			<a href="<%=request.getContextPath()%>/view/start.jsp">ゲーム終了</a>
		</p>

	</div>
</body>
</html>