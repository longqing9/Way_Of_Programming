<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>个人简历管理</title>
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
		<li class="active"><a href="${ctx}/sob/tbSob/">个人简历列表</a></li>
		<shiro:hasPermission name="sob:tbSob:edit"><li><a href="${ctx}/sob/tbSob/form">个人简历添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbSob" action="${ctx}/sob/tbSob/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户注册ID：</label>
				<form:input path="studentid" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>用户注册ID</th>
				<th>期望职业</th>
				<th>求职地点</th>
				<th>学校名称</th>
				<th>就读时间</th>
				<th>所学专业</th>
				<th>学位学历</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sob:tbSob:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbSob">
			<tr>
				<td><a href="${ctx}/sob/tbSob/form?id=${tbSob.id}">
					${tbSob.studentid}
				</a></td>
				<td>
					${tbSob.job}
				</td>
				<td>
					${tbSob.worknow}
				</td>
				<td>
					${tbSob.schName}
				</td>
				<td>
					${tbSob.schTime}
				</td>
				<td>
					${tbSob.schProfe}
				</td>
				<td>
					${tbSob.degree}
				</td>
				<td>
					<fmt:formatDate value="${tbSob.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbSob.remarks}
				</td>
				<shiro:hasPermission name="sob:tbSob:edit"><td>
    				<a href="${ctx}/sob/tbSob/form?id=${tbSob.id}">修改</a>
					<a href="${ctx}/sob/tbSob/delete?id=${tbSob.id}" onclick="return confirmx('确认要删除该个人简历吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>