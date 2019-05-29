<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>填写报修订单</title>
	</head>
	<body style="text-align: center;">
		<div  style="margin:0 auto; width:400px; height:100px; ">
		<h2>填写报修内容</h2>
		<form action="${pageContext.request.contextPath }/Savebaoxiu" method="post">
			宿舍号：<input type="text" name="numb" /><br /><br />
			<h2>报修内容：</h2>
			<textarea name="content" cols="50" rows="10">
			</textarea>
			<input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重新填写" />
		</form>
		</div>
	</body>
