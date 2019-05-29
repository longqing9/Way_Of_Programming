<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示所有的备忘录</title>
		<style>
			.table-c table{border-right:1px solid dimgrey;border-bottom:1px solid dimgrey} 
			.table-c table th{border-left:1px solid dimgrey;border-top:1px solid dimgrey} 
			.table-c table td{border-left:1px solid dimgrey;border-top:1px solid dimgrey} 
		</style>
	</head>
	
	<body>
		<div class="table-c" >
			<c:if test="${tip==0 }">
				<h5 style="color: red;" >暂无备忘信息</h5>
			</c:if>
			<c:if test="${tip==1 }">
				<table style="width: 60%;text-align: center;" align="center">
					<tr>
						<th width="5%">序列号</th>
						<th width="10%">题目</th>
						<th width="10%">操作</th>
					</tr>
					<c:forEach items="${list }" var="memo" begin="0" varStatus="i">
						<tr>
							<td>${i.index+1 }</td>
							<td>${memo.title }</td>
							<td>
								<a href="${pageContext.request.contextPath }/Deletebwl?id=${memo.id}"><button>删除</button></a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath }/detailmemo?id=${memo.id}"><button>查看</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>	
		</div>
	</body>
</html>