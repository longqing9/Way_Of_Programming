<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招聘信息管理</title>
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
		<li class="active"><a href="${ctx}/cjob/tbCjob/">招聘信息列表</a></li>
		<shiro:hasPermission name="cjob:tbCjob:edit"><li><a href="${ctx}/cjob/tbCjob/form">招聘信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbCjob" action="${ctx}/cjob/tbCjob/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>公司账号：</label>
				<form:input path="companyid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>公司名称：</label>
				<form:input path="comname" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>招聘工作名称：</label>
				<form:input path="job" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>工作地点：</label>
				<form:input path="place" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>招聘工作名称</th>
				<th>所属部门</th>
				<th>招聘人数</th>
				<th>诚招薪水</th>
				<th>工作经验</th>
				<th>学历要求</th>
				<th>专业要求</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="cjob:tbCjob:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbCjob">
			<tr>
				<td><a href="${ctx}/cjob/tbCjob/form?id=${tbCjob.id}">
					${tbCjob.comname}
				</a></td>
				<td>
					${tbCjob.job}
				</td>
				<td>
					${tbCjob.department}
				</td>
				<td>
					${tbCjob.number}
				</td>
				<td>
					${tbCjob.emolument}
				</td>
				<td>
					${tbCjob.experience}
				</td>
				<td>
					${tbCjob.educational}
				</td>
				<td>
					${tbCjob.specialty}
				</td>
				<td>
					<fmt:formatDate value="${tbCjob.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbCjob.remarks}
				</td>
				<shiro:hasPermission name="cjob:tbCjob:edit"><td>
    				<a href="${ctx}/cjob/tbCjob/form?id=${tbCjob.id}">修改</a>
					<a href="${ctx}/cjob/tbCjob/delete?id=${tbCjob.id}" onclick="return confirmx('确认要删除该招聘信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>