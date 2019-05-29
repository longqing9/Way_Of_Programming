<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>留言板</title>
	</head>
	<body>
	<h2>留言板</h2>	
	<c:forEach items="${findList}" var="inform" varStatus="user">
	<div style="border: 1px solid #66ff00;width: 30%;height: auto;">
		<p>留言人${user.index+1}:</p>
		<p>内容：${inform.neir}</p>
	</div>
		<br />
	</c:forEach>
	</body>
</html>