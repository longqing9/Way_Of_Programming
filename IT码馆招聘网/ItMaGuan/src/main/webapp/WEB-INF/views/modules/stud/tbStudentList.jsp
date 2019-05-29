<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>基本信息管理</title>
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
		<li class="active"><a href="${ctx}/stud/tbStudent/">基本信息列表</a></li>
		<shiro:hasPermission name="stud:tbStudent:edit"><li><a href="${ctx}/stud/tbStudent/form">基本信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbStudent" action="${ctx}/stud/tbStudent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户注册ID：</label>
				<form:input path="studentid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户注册密码：</label>
				<form:input path="password" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>学历</th>
				<th>邮箱</th>
				<th>联系电话</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="stud:tbStudent:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbStudent">
			<tr>
				<td><a href="${ctx}/stud/tbStudent/form?id=${tbStudent.id}">
					${tbStudent.name}
				</a></td>
				<td>
					${tbStudent.age}
				</td>
				<td>
					${tbStudent.sex}
				</td>
				<td>
					${tbStudent.knowledge}
				</td>
				<td>
					${tbStudent.email}
				</td>
				<td>
					${tbStudent.tell}
				</td>
				<td>
					<fmt:formatDate value="${tbStudent.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${tbStudent.remarks}
				</td>
				<shiro:hasPermission name="stud:tbStudent:edit"><td>
    				<a href="${ctx}/stud/tbStudent/form?id=${tbStudent.id}">修改</a>
					<a href="${ctx}/stud/tbStudent/delete?id=${tbStudent.id}" onclick="return confirmx('确认要删除该基本信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>