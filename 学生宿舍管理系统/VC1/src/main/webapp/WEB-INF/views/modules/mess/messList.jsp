<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>留言板管理</title>
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
		<li class="active"><a href="${ctx}/mess/mess/">留言板列表</a></li>
		<shiro:hasPermission name="mess:mess:edit"><li><a href="${ctx}/mess/mess/form">留言板添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="mess" action="${ctx}/mess/mess/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>内容</th>
				<th>发送者信息</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="mess:mess:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="mess">
			<tr>
				<td><a href="${ctx}/mess/mess/form?id=${mess.id}">
					${mess.neir}
				</a></td>
				<td>
					${mess.xinx}
				</td>
				<td>
					<fmt:formatDate value="${mess.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${mess.remarks}
				</td>
				<shiro:hasPermission name="mess:mess:edit"><td>
    				<a href="${ctx}/mess/mess/form?id=${mess.id}">修改</a>
					<a href="${ctx}/mess/mess/delete?id=${mess.id}" onclick="return confirmx('确认要删除该留言板吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>