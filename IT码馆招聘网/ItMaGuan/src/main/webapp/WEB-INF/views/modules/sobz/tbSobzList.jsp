<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>转储简历信息管理</title>
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
		<li class="active"><a href="${ctx}/sobz/tbSobz/">转储简历信息列表</a></li>
		<shiro:hasPermission name="sobz:tbSobz:edit"><li><a href="${ctx}/sobz/tbSobz/form">转储简历信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbSobz" action="${ctx}/sobz/tbSobz/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户注册ID：</label>
				<form:input path="studentid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>公司注册|ID：</label>
				<form:input path="companyid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>招聘的ID：</label>
				<form:input path="jobid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>期望职业：</label>
				<form:input path="job" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sobz:tbSobz:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbSobz">
			<tr>
				<td><a href="${ctx}/sobz/tbSobz/form?id=${tbSobz.id}">
					<fmt:formatDate value="${tbSobz.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${tbSobz.remarks}
				</td>
				<shiro:hasPermission name="sobz:tbSobz:edit"><td>
    				<a href="${ctx}/sobz/tbSobz/form?id=${tbSobz.id}">修改</a>
					<a href="${ctx}/sobz/tbSobz/delete?id=${tbSobz.id}" onclick="return confirmx('确认要删除该转储简历信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>