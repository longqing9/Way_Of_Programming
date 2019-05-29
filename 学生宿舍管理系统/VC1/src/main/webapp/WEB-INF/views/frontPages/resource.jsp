<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>资源链接</title>
		<style>
			.table-c table{border-right:1px solid dimgrey;border-bottom:1px solid dimgrey} 
			.table-c table th{border-left:1px solid dimgrey;border-top:1px solid dimgrey} 
			.table-c table td{border-left:1px solid dimgrey;border-top:1px solid dimgrey} 
		</style>
	</head>
	<body>
		<div class="table-c" style="color: black;">
			<table style="width: 80%;text-align: center;" align="center">
				<tr>
					<th width="5%">序列号</th>
					<th width="5%">名称</th>
					<th width="10%">链接</th>
					<th width="10%">简介</th>
				</tr>
				 <c:forEach items="${list }" var="resource" begin="0" varStatus="i">
					<tr>
						<td>${i.index+1 }</td>
						<td>${resource.name }</td>
						<td>${resource.sexplain }</td>
						<td>${resource.slink }</td>
					</tr>
				</c:forEach> 
			</table>	
		</div>
	</body>
</html>