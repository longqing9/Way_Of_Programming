<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>消息通知</title>
	</head>
	<body>
	<h2>消息通知</h2>	
	<c:forEach items="${findList}" var="inform">
		<h4>${inform.title}</h4>
		<fmt:formatDate value="${inform.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
		<p>${inform.nr}</p>
		<br />
	</c:forEach>
	</body>
</html>