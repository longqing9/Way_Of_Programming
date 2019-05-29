<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>结束报修</title>
		<style type="text/css">
			.table-c table{border-right:2px solid blue;border-bottom:2px solid blue} 
			.table-c table th{border-left:2px solid blue;border-top:2px solid blue} 
			.table-c table td{border-left:2px solid blue;border-top:2px solid blue} 
		</style>
	</head>
	<body style="text-align: center;">
		
		<c:if test="${tip==1 }">
			<h1>暂无报修订单</h1>
		</c:if>
		<c:if test="${tip==0 }">
		<div class="table-c">
			<table style="width: 99%;text-align: center;">
				<tr>
					<th width="10%">序列号</th>
					<th width="10%">宿舍号</th>
					<th width="10%">处理人</th>
					<th width="10%">订单时间</th>
					<th width="50%">报修内容</th>
					<th width="10%">操作</th>
				</tr>
			<c:forEach items="${bx }" var="Abxiu"  varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${Abxiu.numb }</td>
					<td>${Abxiu.acceptid }</td>
					<td>
					${Abxiu.time }
					</td>
					<td>${Abxiu.content }</td>
					<td>
					<c:if test="${Abxiu.isok=='ok' }">
					报修已完成
					</c:if>
					<c:if test="${Abxiu.isok!='ok' }">
					<a href="${pageContext.request.contextPath }/Savebxiuend?id=${Abxiu.id}"><button>报修结束</button></a>
					</c:if>
					</td>
				</tr>
			</c:forEach>
				
			</table>	
		</div>
		</c:if>
	</body>
</html>
