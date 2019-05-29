<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>发送邮件</title>
	</head>
	<body>
		
		<h4>请填写邮件</h4>
		<form action="${wh}/youjian" method="post">
			<input type="hidden" name="account" value="${account}"/>
			<input type="hidden" name="password" value="${password}"/>
			标题：<input type="text" name="title" /><br />
			内容:<textarea cols="20" rows="3" name="nr"></textarea><br />
			<input type="submit" value="提交" />
		</form>			
		
	</body>
</html>