<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>宿舍检查情况管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/examine/examine/">宿舍检查情况列表</a></li>
		<shiro:hasPermission name="examine:examine:edit"><li><a href="${ctx}/examine/examine/form">宿舍检查情况添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="examine" action="${ctx}/examine/examine/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>宿舍号：</label>
				<form:input path="dormNumber" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>宿舍号</th>
				<th>检查日期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="examine:examine:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="examine">
			<tr>
				<td><a href="${ctx}/examine/examine/form?id=${examine.id}">
					${examine.dormNumber}
				</a></td>
				<td>
					<fmt:formatDate value="${examine.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${examine.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${examine.remarks}
				</td>
				<shiro:hasPermission name="examine:examine:edit"><td>
    				<a href="${ctx}/examine/examine/form?id=${examine.id}">修改</a>
					<a href="${ctx}/examine/examine/delete?id=${examine.id}" onclick="return confirmx('确认要删除该宿舍检查情况吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>