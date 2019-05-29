<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>宿舍检查情况</title>
	</head>
	<body>
	<h2>宿舍检查情况</h2>	
	<c:forEach items="${findList}" var="inform">
		<h4>${inform.dormNumber}</h4>
		<fmt:formatDate value="${inform.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
		<p>${inform.qk}</p>
		<br />
	</c:forEach>
	</body>
</html>