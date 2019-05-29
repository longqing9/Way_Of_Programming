<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>个人信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/personalfiles.css" />
	</head>

	<body>
		<div class="tit" align="center">
			<h1>个人信息</h1>
		</div>
		<div id="main">
			<!-- 一条记录 开始 -->
				<table class="myInfo" align="center">
					<tr>
						<th>姓名：</th>
						<td>${stud.name }</td>
					</tr>
					<tr>
						<th>性别：</th>
						<td>${stud.sex }</td>
					</tr>
					<tr>
						<th>年龄：</th>
						<td>${stud.age } </td>
					</tr>
					<tr>
						<th>出生日期：</th>
						<td><fmt:formatDate value="${stud.birthday }" pattern="yyyy年MM月dd日" /></td>
					</tr>
					<tr>
						<th>参加工作时间：</th>
						<td><fmt:formatDate value="${stud.worktime }" pattern="yyyy年MM月dd日"  /></td>
					</tr>
					<tr>
						<th>户籍：</th>
						<td>${stud.huji }</td>
					</tr>
					<tr>
						<th>现居地：</th>
						<td>${stud.nowadress }</td>
					</tr>
					<tr>
						<th>学历：</th>
						<td>${stud.knowledge }</td>
					</tr>
					<tr>
						<th>联系方式：</th>
						<td>${stud.tell }</td>
					</tr>
					<tr>
						<th>电子邮箱：</th>
						<td>${stud.email }</td>
					</tr>

				</table>
				<!-- 一条记录 结束 -->
		</div>
		<div id="f1">Copyright 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</body>

</html>