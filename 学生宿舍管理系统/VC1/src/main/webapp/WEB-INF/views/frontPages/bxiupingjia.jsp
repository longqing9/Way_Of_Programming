<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>评分</title>
	</head>
	<body>
		<div style="margin:0 auto; width:500px; height:100px; ">
			<h3>请对本次报修处理进行评价</h3>
			处理人：<br /><br />
			满意度评价：<form action="${pageContext.request.contextPath }/Savepingjia?id=${id}" method="post">
				<select name="score">
					<option selected="selected" value="优">优</option>
					<option  value="好">好</option>
					<option  value="良">良</option>
					<option  value="差">差</option>
					<option  value="极差">极差</option>
				</select>
				<input type="submit" value="提交">
			</form>
		</div>
		
		
		
	</body>
</html>
