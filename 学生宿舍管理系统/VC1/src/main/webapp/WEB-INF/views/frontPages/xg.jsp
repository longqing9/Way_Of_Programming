<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>修改个人信息</title>
	</head>

	<body style="text-align:center;">
		<h4>请修改个人信息</h4>
		<form action="${wh}/xuigai" method="post">
			<input type="hidden" name="id" value="${tabAccount.id}" /><br>
			密码：
			<input type="password" name="password" value="${tabAccount.password}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			姓名：
			<input type="text" name="name" value="${tabAccount.name}" /><br /> <br>
			性别：
			<input type="text" name="sex" value="${tabAccount.sex}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			宿舍号：
			<input type="text" name="durmnumber" value="${tabAccount.durmnumber}" /><br /> <br>
			床号：
			<input type="text" name="bednumber" value="${tabAccount.bednumber}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			年龄：
			<input type="text" name="age" value="${tabAccount.age}" /><br /> <br>
			生日：
			<input type="text" name="birthday" value="${tabAccount.birthday}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			星座：
			<input type="text" name="constellation" value="${tabAccount.constellation}" /><br /> <br>
			家乡：
			<input type="text" name="hometown" value="${tabAccount.hometown}" />&nbsp;&nbsp;&nbsp;
			个性签名：
			<input type="text" name="signature" value="${tabAccount.signature}" /><br /><br><br>
			<input type="submit" value="提交" />
		</form>
	</body>

</html>