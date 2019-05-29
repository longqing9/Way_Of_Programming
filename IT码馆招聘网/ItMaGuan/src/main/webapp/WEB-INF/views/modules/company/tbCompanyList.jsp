<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>企业信息管理</title>
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
		<li class="active"><a href="${ctx}/company/tbCompany/">企业信息列表</a></li>
		<shiro:hasPermission name="company:tbCompany:edit"><li><a href="${ctx}/company/tbCompany/form">企业信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbCompany" action="${ctx}/company/tbCompany/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>注册名称id：</label>
				<form:input path="companyid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>注册密码：</label>
				<form:input path="password" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>公司名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>所属行业：</label>
				<form:input path="manage" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>公司地址：</label>
				<form:input path="address" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>公司名称</th>
				<th>公司email</th>
				<th>公司电话</th>
				<th>所属行业</th>
				<th>公司性质</th>
				<th>公司规模</th>
				<th>公司地址</th>
				<th>更新时间</th>
				<shiro:hasPermission name="company:tbCompany:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbCompany">
			<tr>
				<td><a href="${ctx}/company/tbCompany/form?id=${tbCompany.id}">
					${tbCompany.name}
				</a></td>
				<td>
					${tbCompany.email}
				</td>
				<td>
					${tbCompany.tel}
				</td>
				<td>
					${tbCompany.manage}
				</td>
				<td>
					${tbCompany.property}
				</td>
				<td>
					${tbCompany.scale}
				</td>
				<td>
					${tbCompany.address}
				</td>
				<td>
					<fmt:formatDate value="${tbCompany.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="company:tbCompany:edit"><td>
    				<a href="${ctx}/company/tbCompany/form?id=${tbCompany.id}">修改</a>
					<a href="${ctx}/company/tbCompany/delete?id=${tbCompany.id}" onclick="return confirmx('确认要删除该企业信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>