<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>填写留言</title>
	</head>
	<body style="text-align: center;">
		<div  style="margin:0 auto; width:400px; height:100px; ">
		<h2>填写留言</h2>
		<form action="${pageContext.request.contextPath }/SaveMess" method="post">
			内容：<!-- <input type="text" name="neir" /><br /><br /> --><br>
			<textarea rows="5" cols="30" name="neir"></textarea><br /><br />
			<input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重新填写" />
		</form>
		</div>
	</body>
