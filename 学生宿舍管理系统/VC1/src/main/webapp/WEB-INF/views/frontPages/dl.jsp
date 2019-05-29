<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
	</head>
	<body>
		<h4>欢迎来到宿舍管理系统</h4>
		<h5>请登录</h5>
		<form action="${wh}/denglu" method="post">
			账号：<input type="text" name="account" /><br />
			密码：<input type="password" name="password" /><br />
			<input type="submit" value="提交" />
		</form>
	</body>
</html>