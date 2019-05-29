<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>信箱表管理</title>
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
		<li class="active"><a href="${ctx}/emal/emal/">信箱表列表</a></li>
		<shiro:hasPermission name="emal:emal:edit"><li><a href="${ctx}/emal/emal/form">信箱表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="emal" action="${ctx}/emal/emal/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>发送时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="emal:emal:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="emal">
			<tr>
				<td><a href="${ctx}/emal/emal/form?id=${emal.id}">
					${emal.title}
				</a></td>
				<td>
					<fmt:formatDate value="${emal.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${emal.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${emal.remarks}
				</td>
				<shiro:hasPermission name="emal:emal:edit"><td>
    				<a href="${ctx}/emal/emal/form?id=${emal.id}">修改</a>
					<a href="${ctx}/emal/emal/delete?id=${emal.id}" onclick="return confirmx('确认要删除该信箱表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>