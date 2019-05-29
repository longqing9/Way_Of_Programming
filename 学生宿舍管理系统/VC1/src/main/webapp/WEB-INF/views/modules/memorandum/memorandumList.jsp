<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>备忘录管理</title>
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
		<li class="active"><a href="${ctx}/memorandum/memorandum/">备忘录列表</a></li>
		<shiro:hasPermission name="memorandum:memorandum:edit"><li><a href="${ctx}/memorandum/memorandum/form">备忘录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="memorandum" action="${ctx}/memorandum/memorandum/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>账号：</label>
				<form:input path="account" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>题目：</label>
				<form:input path="title" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>题目</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="memorandum:memorandum:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="memorandum">
			<tr>
				<td><a href="${ctx}/memorandum/memorandum/form?id=${memorandum.id}">
					${memorandum.title}
				</a></td>
				<td>
					<fmt:formatDate value="${memorandum.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${memorandum.remarks}
				</td>
				<shiro:hasPermission name="memorandum:memorandum:edit"><td>
    				<a href="${ctx}/memorandum/memorandum/form?id=${memorandum.id}">修改</a>
					<a href="${ctx}/memorandum/memorandum/delete?id=${memorandum.id}" onclick="return confirmx('确认要删除该备忘录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>