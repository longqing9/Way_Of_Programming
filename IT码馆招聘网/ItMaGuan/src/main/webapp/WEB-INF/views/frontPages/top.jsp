<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		
		<meta charset="UTF-8">
		<title>浏览招聘信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<link href="https://fonts.googleapis.com/css?family=Raleway:200,400" rel="stylesheet">
      <link rel="stylesheet" href="${ctxStatic}/frontLayout/css/style.css">
	</head>
	<body>
		<div id="look">
			<div id="header">
				<!--头部导航栏-->
				<img src="${ctxStatic}/frontLayout/images/logo.png" />
				<p>&nbsp;&nbsp;
					<font face="微软雅黑" size="6">|</font>&nbsp;&nbsp;
					<font face="微软雅黑" size="6">招聘信息</font>
				</p>
				<ul>
					<li>
						<p>
							<font face="微软雅黑" size="3">客户服务热线：</font>&nbsp;
							<font face="微软雅黑" size="3">400-855-9626</font>
						</p>
					</li>
				</ul>
			</div>
			<hr color="#BBBBBB" style="height: 5px;" width="100%">
			<br />
			<div id="gll">
				<nav>
			     <h4>个人信息</h4>
			      <input id="toggle" type="checkbox" checked="checked" >
			   <ul style="z-index: 1000;">
			     <li><a href="#">修改个人信息</a></li>
			     <li><a href="#">完善简历</a></li>
			     <li><a href="#">修改密码</a></li>
			     <li><a href="#">没有</a></li>
			   </ul>
			</nav>
				<!--
				<a href="login.html">退出</a>
				<a href="#">帮助</a>
				<a href="我的简历.html">我的简历</a>
				<a href="个人档案.html">个人信息</a>
				<a href="login.html">首页</a>-->
			</div>
	</body>
</html>
