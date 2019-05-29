<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>管理员信息管理</title>
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
		<li class="active"><a href="${ctx}/admin/tbAdmin/">管理员信息列表</a></li>
		<shiro:hasPermission name="admin:tbAdmin:edit"><li><a href="${ctx}/admin/tbAdmin/form">管理员信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbAdmin" action="${ctx}/admin/tbAdmin/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>管理员ID：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>管理员ID</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="admin:tbAdmin:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbAdmin">
			<tr>
				<td><a href="${ctx}/admin/tbAdmin/form?id=${tbAdmin.id}">
					${tbAdmin.name}
				</a></td>
				<td>
					<fmt:formatDate value="${tbAdmin.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbAdmin.remarks}
				</td>
				<shiro:hasPermission name="admin:tbAdmin:edit"><td>
    				<a href="${ctx}/admin/tbAdmin/form?id=${tbAdmin.id}">修改</a>
					<a href="${ctx}/admin/tbAdmin/delete?id=${tbAdmin.id}" onclick="return confirmx('确认要删除该管理员信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>