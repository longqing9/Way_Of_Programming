<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
	</head>

	<body>
		<h2>欢迎进入宿舍管理系统</h2>

		<dl>
			<dt>功能</dt>
			<dd>
				<form action="${wh}/xg" method="post">			
					<input type="hidden" name="account" value="${account.account}" />
					<input type="hidden" name="password" value="${account.password}" />
					<input type="submit" value="修改个人信息" />
				</form>
			</dd>
			<dd>
				<a href="${wh}/tz">消息通知</a>
			</dd>
			<dd>
				<a href="${wh}/qk">宿舍检查情况</a>
			</dd>
			<dd>
				<form action="${wh}/yj" method="post">			
					<input type="hidden" name="account" value="${account.account}" />
					<input type="hidden" name="password" value="${account.password}" />
					<input type="submit" value="写邮件" />
				</form>
			</dd>
			<dd>
				<a href="${pageContext.request.contextPath }/Addbaoxiu">添加报修订单</a>
				<a href="${pageContext.request.contextPath }/Endbaoxiu">结束报修</a>
				<a href="#">添加报修</a> 
			</dd>
		</dl>

	</body>

</html>