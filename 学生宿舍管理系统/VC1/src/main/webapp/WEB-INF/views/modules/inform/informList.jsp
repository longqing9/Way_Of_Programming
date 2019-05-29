<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>消息通知表管理</title>
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
		<li class="active"><a href="${ctx}/inform/inform/">消息通知表列表</a></li>
		<shiro:hasPermission name="inform:inform:edit"><li><a href="${ctx}/inform/inform/form">消息通知表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="inform" action="${ctx}/inform/inform/" method="post" class="breadcrumb form-search">
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
				<th>内容</th>
				<th>发布时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="inform:inform:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="inform">
			<tr>
				<td><a href="${ctx}/inform/inform/form?id=${inform.id}">
					${inform.title}
				</a></td>
				<td>
					${inform.nr}
				</td>
				<td>
					<fmt:formatDate value="${inform.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${inform.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${inform.remarks}
				</td>
				<shiro:hasPermission name="inform:inform:edit"><td>
    				<a href="${ctx}/inform/inform/form?id=${inform.id}">修改</a>
					<a href="${ctx}/inform/inform/delete?id=${inform.id}" onclick="return confirmx('确认要删除该消息通知表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>