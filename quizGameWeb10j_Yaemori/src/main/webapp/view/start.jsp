<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<title>スタート画面</title>
</head>
<body>
	<div id="main">
		<div class="game-title">
			<h2>日本地図あてクイズ</h2>
		</div>
		<img src="map/japan.jpg" alt="menu">
		<p>
			<a href="<%=request.getContextPath()%>/view/menu.jsp">ゲーム開始</a>
		</p>
	</div>
</body>
</html>