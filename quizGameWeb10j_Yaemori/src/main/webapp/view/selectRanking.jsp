<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>ランキング選択</title>
</head>
<body>
	<div id="main">
		<h2>～ランキング～</h2>
		<p>ランキングを選んでください</p>
		<div class="menu">
			<ul class="menu-ul">
				<li>●日本地図あてクイズ</li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=1">初級編</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=2">中級編</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=3">上級編</a></li>
				<br>
				<li>●地域別クイズ</li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=4">中国・四国地方編</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=5">九州・沖縄地方編</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=6">関東地方</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=7">北海道・東北地方編</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=8">近畿地方</a></li>
				<li><a href="<%=request.getContextPath()%>/record?cmd=show&gameType=9">中部地方</a></li>
			</ul>
		</div>

		<p>
			<a href="<%=request.getContextPath()%>/view/menu.jsp">メニューに戻る</a>
		</p>

	</div>

</body>
</html>